/*
 * Author: TopGear Group
 *
 * LoginController provides a way for system users to log into the system.
 * The login controller validates the user name and password. If the credentials
 * are valid the login proceeds, the user role is obtained and an activity logging
 * object is created. If the login fails the user is presented with a message
 * to tell them the possible error. The logon controller then allows the user to
 * try logging into the system again.
 *
 */

package topgearshop.controllers;

import topgearshop.views.LoginView;
import topgearshop.models.CredentialsModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JDialog;
import topgearshop.utils.ConnectionManager;
import topgearshop.views.LoginView;

public class LoginController {
  private final LoginView loginView;
  private final CredentialsModel credentials;
  private JDialog modalDialog;
  private Boolean successfulLogin = false;
    public LoginController()
    {
      loginView = new LoginView();
      modalDialog = new JDialog();
      modalDialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
      modalDialog.addWindowListener(
              new WindowAdapter(){
                @Override public void windowClosing(WindowEvent we){
                  System.exit(0);
                }
                                 });
      modalDialog.add(loginView);
      modalDialog.setTitle("Top Gear System - Logon");
      credentials = new CredentialsModel();
      loginView.setSubmitActionHandler(new LoginListener());
      loginView.setExitActionListener(new CancelLoginListener());
      modalDialog.setModal(true);
      modalDialog.pack();
      modalDialog.setVisible(true);
    }
    public CredentialsModel getCredentials()
    {
      return this.credentials;
    }
    
    public void validate(){
        boolean exists = false;
        
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = ConnectionManager.getConnection();
            
            statement = (PreparedStatement) conn.prepareStatement("select * from credentials where userName=? and password=?");
            statement.setString(1,credentials.getUserName());
            statement.setString(2,credentials.getPassword());
            resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                credentials.setEmployeeID(resultSet.getString(1));
                exists = true;
                //JOptionPane.showMessageDialog(null, "Login Successful! Hello " + credentials.getUserName(),"Information",JOptionPane.INFORMATION_MESSAGE);
                modalDialog.dispose();
            
            }
                
            if(!exists){
                
             JOptionPane.showMessageDialog(null, "Entered incorrect Username and Password","Information",JOptionPane.INFORMATION_MESSAGE);
             
            }
        }catch(Exception e){
            e.printStackTrace();
        }
       
    }
    class LoginListener implements ActionListener{
    
    public void actionPerformed(ActionEvent e){
      credentials.setUserName(loginView.UserName.getText());
      credentials.setPassword(loginView.Password.getText());
        validate();
    }
  }    
  class CancelLoginListener implements ActionListener{
    
    public void actionPerformed(ActionEvent e){
      System.exit(0);
    }
  }
}


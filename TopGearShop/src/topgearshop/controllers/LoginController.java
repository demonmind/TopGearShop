/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package topgearshop.controllers;
import topgearshop.views.LoginView;
import topgearshop.models.CredentialsModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author rmattaway
 */
public class LoginController {
  
    private LoginView loginView;
    private CredentialsModel credentialsModel;
    
    public LoginController(LoginView loginView, CredentialsModel credentialsModel){
    
        this.loginView = loginView;
        this.credentialsModel = credentialsModel;
        
        this.loginView.addloginListener(new LoginListener());
    }
    
    public void validate(){
        boolean exists = false;
        
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/Allan/csc4350.db");
            statement = (PreparedStatement) conn.prepareStatement("select * from users where userName=? and password=?");
            statement.setString(1,credentialsModel.getUserName());
            statement.setString(2,credentialsModel.getPassword());
            resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                exists = true;
                JOptionPane.showMessageDialog(null, "Login Successful! Hello " + credentialsModel.getUserName(),"Information",JOptionPane.INFORMATION_MESSAGE);
            
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
        credentialsModel.setUserName(loginView.getUserName());
        credentialsModel.setPassword(loginView.getUserPassword());
        validate();
    }
    }
}


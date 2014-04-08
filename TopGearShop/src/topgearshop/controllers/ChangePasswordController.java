/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package topgearshop.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import topgearshop.models.CredentialsModel;
import topgearshop.utils.DataAccessLayer;
import topgearshop.views.ChangePassword;

/**
 *
 * @author rmattaway
 */
public class ChangePasswordController {
  private CredentialsModel credentials;
  private ChangePassword cpwd;
  private JDialog modalDialog;
  public ChangePasswordController(CredentialsModel cm)
  {
    credentials = cm;
    cpwd = new ChangePassword();
      modalDialog = new JDialog();
      modalDialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
      modalDialog.addWindowListener(
              new WindowAdapter(){
                @Override public void windowClosing(WindowEvent we){
                }
                                 });
      modalDialog.add(cpwd);
      
      modalDialog.setTitle("Top Gear System - Change Password");
      cpwd.setSubmitActionHandler(new ChangePasswordListener());
      cpwd.setCancelActionHandler(new CancelChangePasswordListener());
      modalDialog.setModal(true);
      modalDialog.pack();
      modalDialog.setVisible(true);
      
      
  }
  
  
  public class ChangePasswordListener implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e){
      System.out.println("The Submit New Password event listner was called");
      String newPassword = cpwd.NewPassword.getText();
      String ConfirmPassword = cpwd.ConfirmNewPassword.getText();
      String oldPassword = cpwd.OldPassword.getText();
      if(newPassword.equals(ConfirmPassword)&&credentials.getPassword().equals(oldPassword))
      {
        boolean success = DataAccessLayer.ChangePassword(credentials, newPassword);
        System.out.println(success);
      }
      else{
        JOptionPane.showMessageDialog(null, "The update to your password was not successful. Try again.", "Information",JOptionPane.INFORMATION_MESSAGE);
      }
      modalDialog.dispose();
    }
  }
  public class CancelChangePasswordListener implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e){
      System.out.println("The ChangePassword cancel listner was called");
      modalDialog.dispose();
    }
  }
         
}

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
import topgearshop.models.CredentialsModel;
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

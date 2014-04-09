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
import topgearshop.views.CreateEditUserView;
import topgearshop.views.LoginView;

/**
 *
 * @author rmattaway
 */
public class CreateEditUserController {
  private CreateEditUserView createEditUser;
  private CredentialsModel systemUserModel;
  private Boolean cancelled = false;
  private JDialog modalDialog;
  
  public CreateEditUserController()
  {
      createEditUser = new CreateEditUserView();
      modalDialog = new JDialog();
      modalDialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
      modalDialog.addWindowListener(
              new WindowAdapter(){
                @Override public void windowClosing(WindowEvent we){
                  System.exit(0);
                }
                                 });
      modalDialog.add(createEditUser);
      modalDialog.setTitle("Top Gear System - Create User");
      systemUserModel = new CredentialsModel();
      createEditUser.setSubmitActionHandler(new SaveListener());
      createEditUser.setCancelActionListener(new CancelListener());
      modalDialog.setModal(true);
      modalDialog.pack();
      modalDialog.setVisible(true);
  }
  
  class SaveListener implements ActionListener{
    
    public void actionPerformed(ActionEvent e){
      modalDialog.dispose();
    }
  }    
  class CancelListener implements ActionListener{
    
    public void actionPerformed(ActionEvent e){
      modalDialog.dispose();
    }
  }  
}

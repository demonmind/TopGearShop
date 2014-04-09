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
import topgearshop.utils.Notifications;
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
  private Boolean CreateUser = true;
  private JDialog modalDialog;
  
  public CreateEditUserController(CredentialsModel credentials)
  {
    if(credentials!=null)
    {
      CreateUser = false;
      systemUserModel = credentials;
    }
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
      if(!CreateUser)
      {
        loadUserInformation();
      }
      modalDialog.setVisible(true);
  }
  public Boolean getCancelledStatus()
  {
    return cancelled;
  }
  private void loadUserInformation()
  {
    createEditUser.EmployeeID.setText(systemUserModel.getEmployeeID());
    createEditUser.UserName.setText(systemUserModel.getUserName());
    createEditUser.Password.setText("");
    createEditUser.ConfirmPassword.setText("");
    createEditUser.Salt.setText(systemUserModel.getSalt());
  }
  private void setUserInformation()
  {
    systemUserModel.setEmployeeID(createEditUser.EmployeeID.getText());
    systemUserModel.setUserName(createEditUser.UserName.getText());
    systemUserModel.setPassword(createEditUser.Password.getText());
    systemUserModel.setSalt(createEditUser.Salt.getText()); 
  }
  private Boolean validateModel()
  {
    if(systemUserModel.getEmployeeID().equals("") ||
       systemUserModel.getPassword().equals("") ||
            systemUserModel.getUserName().equals("") ||
            systemUserModel.getSalt().equals(""))
      return false;
    return true;
              
  }
  class SaveListener implements ActionListener{
    
    public void actionPerformed(ActionEvent e){
      if(CreateUser)
      {
        systemUserModel = new CredentialsModel();
      }
      setUserInformation();
      
      String ConfirmedPassword = createEditUser.ConfirmPassword.getText();
      if(!validateModel())
      {
        Notifications.DisplayNotification("You must enter all values.");
        return;
      }
      if(!systemUserModel.getPassword().equals(ConfirmedPassword))
      {
        Notifications.DisplayNotification("The two passwords do not match");
        return;
      }
      if(!DataAccessLayer.CreateUser(systemUserModel))
      {
        Notifications.DisplayNotification("A user with the specified Employee ID already exists");
        return;
      }
      if(CreateUser)
      {
        DataAccessLayer.CreateUser(systemUserModel);
      }
      else
      {
        DataAccessLayer.UpdateUser(systemUserModel);
      } 
      modalDialog.dispose();
      
    }
  }    
  class CancelListener implements ActionListener{
    
    public void actionPerformed(ActionEvent e){
      cancelled = true;
      modalDialog.dispose();
    }
  }  
}

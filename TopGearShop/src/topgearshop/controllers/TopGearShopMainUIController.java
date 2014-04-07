/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package topgearshop.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JDialog;
import topgearshop.models.*;
import topgearshop.views.*;
/**
 *
 * @author rmattaway
 */
public class TopGearShopMainUIController {
  private TopGearShopMainUI tgsMainUI;
  private ActivityTypeModel activityTypeModel;
  private CredentialsModel credentialsModel;
  
  public TopGearShopMainUIController(){
    tgsMainUI = new TopGearShopMainUI();
    tgsMainUI.setChangePasswordAction(new ChangePasswordListener());
    tgsMainUI.setCreateCustomerAction(new CreateCustomerListener());
    tgsMainUI.setCreateInventoryAction(new CreateInventoryListener());
    tgsMainUI.setCreateServiceAction(new CreateServiceListener());
    tgsMainUI.setCreateUserAction(new CreateUserListener());
    
  }
  public void setActivityModel(ActivityTypeModel am)
  {
    this.activityTypeModel = am;
    tgsMainUI.viewActivity.setActiveActivity(am.getActivityName());
  }
  public void setCredentialsModel(CredentialsModel cm)
  {
    this.credentialsModel = cm;
    tgsMainUI.viewActivity.setActiveUser(cm.getUserName());
  }
  public void showView()
  {
    tgsMainUI.setVisible(true);
  }
  
  
  
  
  
  /* Action methods to create all controllers and views */
  class ChangePasswordListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        System.out.println("You want to change your password");
    }
  }
  class CreateCustomerListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        System.out.println("You want to create a customer");
    }
  }
  class CreateInventoryListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        System.out.println("You want to create inventory");
    }
  }
  class CreateServiceListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        System.out.println("You want to create a service provided by the shop");
    }
  }
  class CreateUserListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        System.out.println("You want to create a user");
    }
  }
  class CreateVehicleListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        System.out.println("You want to create a vehicle");
    }
  }
  class CreateWarrantyListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        System.out.println("You want to create a warranty");
    }
  }
  class CreateCustomerReportListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        System.out.println("You want to create a customer report");
    }
  }
  class EditCustomerListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        System.out.println("You want to edit a customer");
    }
  }
  class EditInventoryListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        System.out.println("You want to edit inventory");
    }
  }
  class EditServiceListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        System.out.println("You want to edit a service the shop provides");
    }
  }
  class EditUserListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        System.out.println("You want to edit a user");
    }
  }
  class EditVehicleListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        System.out.println("You want to edit a vehicle");
    }
  }
  class EditWarrantyListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        System.out.println("You want to edit a warranty");
    }
  }
  class FindCustomerListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        System.out.println("You want to find a customer");
    }
  }
  class FindInventoryListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        System.out.println("You want to find inventory");
    }
  }
  class FindUserListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        System.out.println("You want to find a user");
    }
  }
  class FindVehicleListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        System.out.println("You want to find a vehicle");
    }
  }
  class CreateHoursWorkedReportListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        System.out.println("You want to create an hours worked report");
    }
  }
  class CreateProfitReportListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        System.out.println("You want to create a profit report");
    }
  }
  class RemoveServiceListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        System.out.println("You want to remove a service provided by the shop");
    }
  }
  class RemoveWarrantyListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        System.out.println("You want to remove a warranty that is no longer required");
    }
  }
  class CreateServicesPerformedReportListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        System.out.println("You want to create  a services performed report");
    }
  }
  class CreateTechnicianReportListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        System.out.println("You want to create a technician report");
    }
  }
  class CreateVehicleHistoryReportListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        System.out.println("You want to create a vehicle history report");
    }
  }
}

/*
 * Author: TopGear Group
 *
 * TopGearShopMainUIController is the main controller in the system which receives
 * control from the main method once main validates the user and signs the user
 * into the system. The TopGearShopMainUIController then coordinates all other
 * requests with all of the other controllers. If two controllers need to
 * communicate they must pass models to the main controller.
 *
 */
package topgearshop.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import topgearshop.views.*;
import topgearshop.models.*;
import topgearshop.utils.DataAccessLayer;

public class TopGearShopMainUIController {
  private TopGearMainUI tgsUI;
  private CredentialsModel credentials;
  
  public TopGearShopMainUIController(CredentialsModel cm)
  {
    tgsUI = new TopGearMainUI();
    tgsUI.setVisible(true);
    credentials = cm;
    tgsUI.setChangePasswordActionListener(new ChangePasswordListener());
    tgsUI.setCompleteWorkOrderActionListener(new CompleteWorkOrderListener());
    tgsUI.setCreateCustomerActionListener(new CreateCustomerListener());
    tgsUI.setCreateEmployeeActionListener(new CreateEmployeeListener());
    tgsUI.setCreateInventoryActionListener(new CreateInventoryListener());
    tgsUI.setCreateServiceActionListener(new CreateServiceListener());
    tgsUI.setCreateUserActionListener(new CreateUserListener());
    tgsUI.setCreateVehicleActionListener(new CreateVehicleListener());
    tgsUI.setCreateWarrantyActionListener(new CreateWarrantyListener());
    tgsUI.setCreateWorkOrderActionListener(new CreateWorkOrderListener());
    tgsUI.setCustomerReportActionListener(new CustomerReportListener());
    tgsUI.setEditCustomerActionListener(new EditCustomerListener());
    tgsUI.setEditEmployeeActionListener(new EditEmployeeListener());
    tgsUI.setEditInventoryActionListener(new EditInventoryListener());
    tgsUI.setEditServiceActionListener(new EditServiceListener());
    tgsUI.setEditUserActionListener(new EditUserListener());
    tgsUI.setEditVehicleActionListener(new EditVehicleListener());
    tgsUI.setEditWarrantyActionListener(new EditWarrantyListener());
    tgsUI.setEditWorkOrderActionListener(new EditWorkOrderListener());
    tgsUI.setFindCustomerActionListener(new FindCustomerListener());
    tgsUI.setFindEmployeeActionListener(new FindEmployeeListener());
    tgsUI.setFindInventoryActionListener(new FindInventoryListener());
    tgsUI.setFindUserActionListener(new FindUserListener());
    tgsUI.setFindVehicleActionListener(new FindVehicleListener());
    tgsUI.setFindWarrantyActionListener(new FindWarrantyListener());
    tgsUI.setFindWorkOrderActionListener(new FindWorkOrderListener());
    tgsUI.setHoursWorkedReportActionListener(new HoursWorkedReportListener());
    tgsUI.setProfitReportActionListener(new ProfitReportListener());
    tgsUI.setRemoveInventoryActionListener(new RemoveInventoryListener());
    tgsUI.setRemoveServiceActionListener(new RemoveServiceListener());
    tgsUI.setRemoveWarrantyActionListener(new RemoveWarrantyListener());
    tgsUI.setServicesPerformedActionListener(new ServicesPerformedListener());
    tgsUI.setTechnicianReportActionListener(new TechnicianReportListener());
    tgsUI.setVehicleHistoryActionListener(new VehicleHistoryListener());
  }
  public class ChangePasswordListener implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e){
      ChangePasswordController changePassword = new ChangePasswordController(credentials);
      System.out.println("The ChangePassword event listner was called");
    }
  }
class CompleteWorkOrderListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      System.out.println("The CompleteWorkOrder event listner was called");
    }
  }
class CreateCustomerListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      CreateEditCustomerController customerController = new CreateEditCustomerController(null, false);
      
      System.out.println("The CreateCustomer event listner was called");
    }
  }
class CreateEmployeeListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      CreateEditEmployeeController employeeController = new CreateEditEmployeeController(null, false);
      
      System.out.println("The CreateCustomer event listner was called");
    }
  }
class CreateInventoryListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      CreateEditInventoryItemController createInventoryItem = new CreateEditInventoryItemController(null, false);
      System.out.println("The CreateInventory event listner was called");
    }
  }
class CreateServiceListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      System.out.println("The CreateService event listner was called");
    }
  }
class CreateUserListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      CreateEditUserController createUser = new CreateEditUserController(null, false);
      
      System.out.println("The CreateUser event listner was called");
    }
  }
class CreateVehicleListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      CreateEditVehicleController createVehicle = new CreateEditVehicleController(null, false);
      System.out.println("The CreateVehicle event listner was called");
    }
  }
class CreateWarrantyListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      CreateEditWarrantyInfoController createWarrantyInfo = new CreateEditWarrantyInfoController(null, false);
      System.out.println("The CreateWarranty event listner was called");
    }
  }
class CreateWorkOrderListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      CreateEditWorkItemController ceWorkItem = new CreateEditWorkItemController();
      System.out.println("The CreateWorkOrder event listner was called");
      
    }
  }
class CustomerReportListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      System.out.println("The CustomerReport event listner was called");
    }
  }
class EditCustomerListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      FindCustomerController findCustomer = new FindCustomerController();
      CustomerModel m = findCustomer.getCustomer();
      if(!findCustomer.getCancelledStatus())
      {
        CreateEditCustomerController cc = new CreateEditCustomerController(m, false);
      }
      System.out.println("The EditCustomer event listner was called");
    }
  }
class EditEmployeeListener implements ActionListener{
  @Override
  public void actionPerformed(ActionEvent e){
    FindEmployeeController findEmployee = new FindEmployeeController();
    if(!findEmployee.getCancelledStatus())
    {
      CreateEditEmployeeController ceEmployee = new CreateEditEmployeeController(new EmployeeModel(), false);
    }
  }
          
}
class FindEmployeeListener implements ActionListener{
  @Override
  public void actionPerformed(ActionEvent e){
    FindEmployeeController findEmployee = new FindEmployeeController();
   
  }
          
}
class EditInventoryListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      System.out.println("The EditInventory event listner was called");
    }
  }
class EditServiceListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      System.out.println("The EditService event listner was called");
    }
  }
class EditUserListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      FindUserController findUser = new FindUserController();
      if(!findUser.getCancelledStatus())
      {
        CredentialsModel cm = findUser.getUser();
        CreateEditUserController editUser = new CreateEditUserController(cm, false);
      }
      System.out.println("The EditUser event listner was called");
    }
  }
class EditVehicleListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      FindVehicleController findVehicle = new FindVehicleController();
      if(!findVehicle.getCancelledStatus())
      {
      CreateEditVehicleController createVehicle = new CreateEditVehicleController(null, false);
      }
      System.out.println("The EditVehicle event listner was called");
    }
  }
class EditWarrantyListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      System.out.println("The EditWarranty event listner was called");
    }
  }
class EditWorkOrderListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      System.out.println("The EditWorkOrder event listner was called");
    }
  }
class FindCustomerListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      FindCustomerController findCustomer = new FindCustomerController();
      CustomerModel m = findCustomer.getCustomer();
      //CreateEditCustomerController cc = new CreateEditCustomerController(m);
      System.out.println("The FindCustomer event listner was called");
    }
  }
class FindInventoryListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      System.out.println("The FindInventory event listner was called");
    }
  }
class FindUserListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      FindUserController findUser = new FindUserController();
      System.out.println("The FindUser event listner was called");
    }
  }
class FindVehicleListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      FindVehicleController fvc = new FindVehicleController();
      System.out.println("The FindVehicle event listner was called");
    }
  }
class FindWarrantyListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      FindWarrantyInfoController findWarranty = new FindWarrantyInfoController();
      System.out.println("The FindWarranty event listner was called");
    }
  }
class FindWorkOrderListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      System.out.println("The FindWorkOrder event listner was called");
    }
  }
class HoursWorkedReportListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      System.out.println("The HoursWorkedReport event listner was called");
    }
  }
class ProfitReportListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      System.out.println("The ProfitReport event listner was called");
    }
  }
class RemoveInventoryListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      System.out.println("The RemoveInventory event listner was called");
    }
  }
class RemoveServiceListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      System.out.println("The RemoveService event listner was called");
    }
  }
class RemoveWarrantyListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      System.out.println("The RemoveWarranty event listner was called");
    }
  }
class ServicesPerformedListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      System.out.println("The ServicesPerformed event listner was called");
    }
  }
class TechnicianReportListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      System.out.println("The TechnicianReport event listner was called");
    }
  }
class VehicleHistoryListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      System.out.println("The VehicleHistory event listner was called");
    }
  }

}

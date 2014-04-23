/*
 * Author: TopGear Group
 *
 * FindEmployeeController provides the way to find already created employees in
 * the system. The find employee interface is presented and depending on the criteria
 * provided the employee is returned. 
 *
 */


package topgearshop.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JDialog;
import topgearshop.controllers.CreateEditCustomerController.SubmitListener;
import topgearshop.models.EmployeeModel;
import topgearshop.views.FindCustomerView;
import topgearshop.views.FindEmployeeView;

public class FindEmployeeController {
  private EmployeeModel employeeModel;
  private FindEmployeeView findEmployee;
  private JDialog modalDialog;
  private Boolean cancelled = false;
  
  public FindEmployeeController()
  {
    findEmployee = new FindEmployeeView();
    modalDialog = new JDialog();
    modalDialog.add(findEmployee);
    modalDialog.setTitle("Top Gear System - Find Employee");
    findEmployee.setSubmitActionHandler(new SubmitListener());
    findEmployee.setCancelActionListener(new CancelListener());
    modalDialog.setModal(true);
    modalDialog.pack();
    modalDialog.setVisible(true);

  }
  boolean getCancelledStatus() {
    return cancelled;
  }
  
  class SubmitListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      // The default cancelled value should be false. It is auto set when the
      // instance is created. It should only be set to false in the cancel event
      
      modalDialog.dispose();
    }
  }
  class CancelListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      // The default cancelled value should be false. It is auto set when the
      // instance is created. It should only be set to false in the cancel event
      cancelled = true;
      modalDialog.dispose();
    }
  }
}

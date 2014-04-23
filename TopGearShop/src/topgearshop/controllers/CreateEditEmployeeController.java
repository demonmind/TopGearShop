/*
 * Author: TopGear Group
 *
 * CreateEditEmployeeController provides the way to create and edit employees
 * depending on the parameter values of the constructor. Because there is 
 * a requirement to find a employee before editing the controller also is used
 * by the FindEmployeeController to visualize the employee information
 *
 */
package topgearshop.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import topgearshop.models.EmployeeModel;
import topgearshop.utils.DataAccessLayer;
import topgearshop.views.CreateEditEmployeeView;

public class CreateEditEmployeeController {
  private EmployeeModel employee;
  private CreateEditEmployeeView employeeView;
  private Boolean cancelled = false;
  private Boolean CreateEmployee = true;
  private JDialog modalDialog;
  
  public CreateEditEmployeeController(EmployeeModel em, Boolean readOnly)
  {
    if(em!=null)
    {
      CreateEmployee = false;
      employee = em;
    }
    
    employeeView = new CreateEditEmployeeView();

    modalDialog = new JDialog();
    modalDialog.add(employeeView);
    modalDialog.setTitle("Top Gear System - Create or Edit Employee");
    if(readOnly)
    {
      setFoundInterface();
    }
    employeeView.setSubmitActionHandler(new SubmitListener());
    employeeView.setCancelActionListener(new CancelListener());
    modalDialog.setModal(true);
    modalDialog.pack();
    if(!CreateEmployee)
    {
      loadEmployeeInformation();      
    }
    else
    {
      employeeView.EmployeeTypeID.setModel(getComboModel());
    }
    modalDialog.setVisible(true);
  }
  private ComboBoxModel getComboModel ()
  {
    return new DefaultComboBoxModel<> (DataAccessLayer.getEmployeeTypes());
  }
  private void setEmployeeInformation() {
    employee.setEmployeeID(Integer.parseInt(employeeView.EmployeeID.getText()));
    employee.setFirstName(employeeView.FirstName.getText());
    employee.setMiddleName(employeeView.MiddleName.getText());
    employee.setLastName(employeeView.LastName.getText());
    employee.setDateOfBirth(new Date( employeeView.DateOfBirth.getText()));
    employee.setDriversLicenseNumber(employeeView.DriversLicenseNumber.getText());
    /* Lookup the employee type id because the combo box doesn't support value */
    employee.setEmployeeTypeID(employeeView.EmployeeTypeID.getSelectedIndex());
     }
  private void setFoundInterface() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  private void loadEmployeeInformation() {
    employeeView.EmployeeID.setText(employee.getEmployeeID().toString());
    employeeView.FirstName.setText(employee.getFirstName());
    employeeView.MiddleName.setText(employee.getMiddleName());
    employeeView.LastName.setText(employee.getLastName());
    employeeView.DateOfBirth.setText(employee.getDateOfBirth().toString());
    employeeView.DriversLicenseNumber.setText(employee.getDriversLicenseNumber());
    employeeView.EmployeeTypeID.setSelectedItem(employee.getEmployeeTypeID());
  }
  
  private EmployeeModel validateEmployeeInformation() {
      return DataAccessLayer.FindEmployee(employee);
    }
    
    
    class SubmitListener implements ActionListener{
    
    public void actionPerformed(ActionEvent e){
      if(CreateEmployee)
      {
        employee = new EmployeeModel();
      }
      setEmployeeInformation();
      if(CreateEmployee)
      {
        DataAccessLayer.CreateEmployee(employee);
      }
      else
      {
        DataAccessLayer.UpdateEmployee(employee);
      }
      EmployeeModel existingEmployee = validateEmployeeInformation();
      if(existingEmployee==null)
      {
        return;
      }
      modalDialog.dispose();
    }   
  }
  class CancelListener implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e){
      cancelled = true;
      modalDialog.dispose();
    }
  }  
}

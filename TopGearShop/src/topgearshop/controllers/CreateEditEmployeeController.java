/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package topgearshop.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import topgearshop.models.EmployeeModel;
import topgearshop.utils.DataAccessLayer;
import topgearshop.views.CreateEditEmployeeView;

/**
 *
 * @author rmattaway
 */
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
    modalDialog.setVisible(true);
  }
  private void setCustomerInformation() {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     }
  private void setFoundInterface() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  private void loadEmployeeInformation() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
      setCustomerInformation();
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

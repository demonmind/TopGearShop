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
import topgearshop.models.CustomerModel;
import topgearshop.utils.DataAccessLayer;
import topgearshop.utils.SequenceIDManager;
import topgearshop.views.CreateEditCustomerView;
import topgearshop.views.LoginView;

/**
 *
 * @author rmattaway
 */
public class CreateEditCustomerController {
  private CustomerModel customerModel;
  private CreateEditCustomerView ceCustomerView;
  private Boolean CreateCustomer = true;
  private JDialog modalDialog;
  
  public CreateEditCustomerController(CustomerModel cm)
  {
    if(cm!=null)
    {
      CreateCustomer = false;
      customerModel = cm;
    }
    
    ceCustomerView = new CreateEditCustomerView();
    modalDialog = new JDialog();
    modalDialog.add(ceCustomerView);
    modalDialog.setTitle("Top Gear System - Create or Edit Customer");
    ceCustomerView.setSubmitActionHandler(new SubmitListener());
    ceCustomerView.setCancelActionListener(new CancelListener());
    modalDialog.setModal(true);
    modalDialog.pack();
    if(!CreateCustomer)
    {
      setCustomerInformation();      
    }
    modalDialog.setVisible(true);
  }
  private void setCustomerInformation()
  {
      customerModel.setPhoneNumber(ceCustomerView.PhoneNumber.getText());
      customerModel.setCity(ceCustomerView.City.getText());
      customerModel.setEmailAddress(ceCustomerView.EmailAddress.getText());
      customerModel.setFirstName(ceCustomerView.FirstName.getText());
      customerModel.setLastName(ceCustomerView.LastName.getText());
      customerModel.setState(ceCustomerView.State.getText());
      customerModel.setStreetAddress(ceCustomerView.StreetAddress.getText());
      customerModel.setZipCode(ceCustomerView.ZipCode.getText());
  }
  class SubmitListener implements ActionListener{
    
    public void actionPerformed(ActionEvent e){
      if(CreateCustomer)
      {
        customerModel = new CustomerModel();
        customerModel.setCustomerID(DataAccessLayer.GetNextCustomerID());
      }
      setCustomerInformation();
      DataAccessLayer.CreateCustomer(customerModel);
      modalDialog.dispose();
    }
  }
  class CancelListener implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e){
      modalDialog.dispose();
    }
  }  
}

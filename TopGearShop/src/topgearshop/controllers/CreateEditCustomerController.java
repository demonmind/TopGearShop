/*
 * Author: TopGear Group
 *
 * CreateEditCustomerController provides the way to create and edit users
 * depending on the parameter values of the constructor. Because there is 
 * a requirement to find a customer before editing the controller also is used
 * by the FindCustomerController to visualize the customer information
 *
 */
package topgearshop.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JDialog;
import topgearshop.models.CredentialsModel;
import topgearshop.models.CustomerModel;
import topgearshop.utils.DataAccessLayer;
import topgearshop.views.CreateEditCustomerView;
import topgearshop.views.LoginView;

public class CreateEditCustomerController {
  private CustomerModel customerModel;
  private CreateEditCustomerView ceCustomerView;
  private Boolean CreateCustomer = true;
  private JDialog modalDialog;
  private Boolean cancelled = false;
  private Date customerCreationDate;
  
  public CreateEditCustomerController(CustomerModel cm, Boolean readOnly)
  {
    customerCreationDate = new Date();
    if(cm!=null)
    {
      CreateCustomer = false;
      customerModel = cm;
    }
    
    ceCustomerView = new CreateEditCustomerView();

    modalDialog = new JDialog();
    modalDialog.add(ceCustomerView);
    modalDialog.setTitle("Top Gear System - Create or Edit Customer");
    if(readOnly)
    {
      setFoundInterface();
    }
    ceCustomerView.setSubmitActionHandler(new SubmitListener());
    ceCustomerView.setCancelActionListener(new CancelListener());
    modalDialog.setModal(true);
    modalDialog.pack();
    if(!CreateCustomer)
    {
      loadCustomerInformation();      
    }
    modalDialog.setVisible(true);
  }
  public Boolean getCancelledStatus()
  {
    return cancelled;
  }
  private void setFoundInterface()
  {
    modalDialog.setTitle("Top Gear System - Find Customer Results");
    ceCustomerView.City.setEnabled(false);
    ceCustomerView.EmailAddress.setEnabled(false);
    ceCustomerView.FirstName.setEnabled(false);
    ceCustomerView.LastName.setEnabled(false);
    ceCustomerView.PhoneNumber.setEnabled(false);
    ceCustomerView.State.setEnabled(false);
    ceCustomerView.StreetAddress.setEnabled(false);
    ceCustomerView.ZipCode.setEnabled(false);
  }
  private void loadCustomerInformation()
  {
    ceCustomerView.PhoneNumber.setText(customerModel.getPhoneNumber());
    ceCustomerView.City.setText(customerModel.getCity());
    ceCustomerView.EmailAddress.setText(customerModel.getEmailAddress());
    ceCustomerView.FirstName.setText(customerModel.getFirstName());
    ceCustomerView.LastName.setText(customerModel.getLastName());
    ceCustomerView.State.setText(customerModel.getState());
    ceCustomerView.StreetAddress.setText(customerModel.getStreetAddress());
    ceCustomerView.ZipCode.setText(customerModel.getZipCode());
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    ceCustomerView.CustomerCreationDate.setText(sdf.format(customerModel.getCustomerCreationDate()));
    
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
      customerModel.setCustomerCreationDate(customerCreationDate);
  }
  class SubmitListener implements ActionListener{
    
    public void actionPerformed(ActionEvent e){
      if(CreateCustomer)
      {
        customerModel = new CustomerModel();
        customerModel.setCustomerID(DataAccessLayer.GetNextCustomerID());
      }
      setCustomerInformation();
      if(CreateCustomer)
      {
        DataAccessLayer.CreateCustomer(customerModel);
      }
      else
      {
        DataAccessLayer.UpdateCustomer(customerModel);
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

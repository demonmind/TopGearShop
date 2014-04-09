/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package topgearshop.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import topgearshop.models.CustomerModel;
import topgearshop.utils.DataAccessLayer;
import topgearshop.views.CreateEditCustomerView;
import topgearshop.views.FindCustomerView;

/**
 *
 * @author rmattaway
 */
public class FindCustomerController {
  private FindCustomerView findCustomer;
  private JDialog modalDialog;
  private CustomerModel foundCustomer;
  
  public FindCustomerController()
  {
    findCustomer = new FindCustomerView();
    modalDialog = new JDialog();
    modalDialog.add(findCustomer);
    modalDialog.setTitle("Top Gear System - Find Customer");
    findCustomer.setSubmitActionHandler(new SubmitListener());
    findCustomer.setCancelActionListener(new CancelListener());
    modalDialog.setModal(true);
    modalDialog.pack();
    modalDialog.setVisible(true);
  }
  public CustomerModel getCustomer()
  {
    return foundCustomer;
  }
  class SubmitListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      CustomerModel cm = new CustomerModel();
      cm.setEmailAddress(findCustomer.EmailAddress.getText());
      cm.setPhoneNumber(findCustomer.PhoneNumber.getText());
      cm.setFirstName(findCustomer.FirstName.getText());
      cm.setLastName(findCustomer.LastName.getText());
      foundCustomer = DataAccessLayer.FindCustomer(cm);
      modalDialog.dispose();
      
      CreateEditCustomerController theFoundCustomer = new CreateEditCustomerController(foundCustomer);
    }
  }
  class CancelListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      modalDialog.dispose();
    }
  }
}

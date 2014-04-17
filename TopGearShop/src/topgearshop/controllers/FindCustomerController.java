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
  /*
  All of the Controllers shall contain at least one view and one model
  It is possible to have many view and many models.
  The modalDialog is a container for our views such that we can easily
  get the return values from a modal form.
  */
  private FindCustomerView findCustomer;
  private JDialog modalDialog;
  private CustomerModel foundCustomer;
  private Boolean cancelled = false;
  
  // The construtor is the work horse because these objects do not need
  // to have a long life span
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
  // Any view that implements a cancel button, which is practically all of them
  // needs to have a getCancelledStatus method. This can cascade to any controller
  // so the status of one action can be sent up the chain and handled as 
  // required
  public Boolean getCancelledStatus()
  {
    return cancelled;
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
      if(!cancelled)
      {
        CreateEditCustomerController theFoundCustomer = new CreateEditCustomerController(foundCustomer, true);
        cancelled = theFoundCustomer.getCancelledStatus();
      }
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

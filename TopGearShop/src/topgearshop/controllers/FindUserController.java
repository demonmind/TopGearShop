/*
 * Author: TopGear Group
 *
 * FindUserController provides the way to find already created users in
 * the system. The find user interface is presented and depending on the criteria
 * provided the user information is returned but without the password.
 *
 */

package topgearshop.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import topgearshop.models.CredentialsModel;
import topgearshop.models.CustomerModel;
import topgearshop.utils.DataAccessLayer;
import topgearshop.views.FindCustomerView;
import topgearshop.views.FindUserView;

public class FindUserController {
   /*
  All of the Controllers shall contain at least one view and one model
  It is possible to have many view and many models.
  The modalDialog is a container for our views such that we can easily
  get the return values from a modal form.
  */
  private FindUserView findUser;
  private JDialog modalDialog;
  private CredentialsModel foundUser;
  private Boolean cancelled = false;
  
  // The construtor is the work horse because these objects do not need
  // to have a long life span
  public FindUserController()
  {
    findUser = new FindUserView();
    modalDialog = new JDialog();
    modalDialog.add(findUser);
    modalDialog.setTitle("Top Gear System - Find User");
    findUser.setSubmitActionHandler(new SubmitListener());
    findUser.setCancelActionListener(new CancelListener());
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
  public CredentialsModel getUser()
  {
    return foundUser;
  }
  class SubmitListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      /*
      What you need to do is get the employee model going
      Then you need to assign an employee to a credential so you can
      Look up the employee by ID or by name which requires
      Two models
      */
      CredentialsModel cm = new CredentialsModel();
      cm.setEmployeeID(findUser.EmployeeID.getText());
//      cm.setUserName(findUser.
//      foundUser = DataAccessLayer.FindUser(cm);
      modalDialog.dispose();
      if(!cancelled)
      {
        //CreateEditCustomerController theFoundCustomer = new CreateEditCustomerController(foundCustomer, true);
//        cancelled = theFoundCustomer.getCancelledStatus();
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

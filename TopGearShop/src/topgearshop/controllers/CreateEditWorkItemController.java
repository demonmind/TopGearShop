/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package topgearshop.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JDialog;
import topgearshop.models.CustomerModel;
import topgearshop.utils.DataAccessLayer;
import topgearshop.views.CreateEditWorkItemView;

/**
 *
 * @author rmattaway
 */
public class CreateEditWorkItemController {
  private Date workOrderCreationDate;
  private CreateEditWorkItemView ceWorkItemView;
  private JDialog modalDialog;
  private Boolean cancelled = false;
  
  public CreateEditWorkItemController()
  {
    workOrderCreationDate = new Date();
//    if(cm!=null)
//    {
//      CreateCustomer = false;
//      customerModel = cm;
//    }
//    
    ceWorkItemView = new CreateEditWorkItemView();

    modalDialog = new JDialog();
    modalDialog.add(ceWorkItemView);
    modalDialog.setTitle("Top Gear System - Create or Edit Work Order Items");
    ceWorkItemView.setSubmitActionHandler(new SubmitListener());
    ceWorkItemView.setCancelActionListener(new CancelListener());
    modalDialog.setModal(true);
    modalDialog.pack();

    modalDialog.setVisible(true);
  }
    class SubmitListener implements ActionListener{
    
    public void actionPerformed(ActionEvent e){

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

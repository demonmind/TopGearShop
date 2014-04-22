package topgearshop.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JDialog;
import topgearshop.models.CustomerModel;
import topgearshop.models.WarrantyModel;
import topgearshop.utils.DataAccessLayer;
import topgearshop.views.CreateEditWarrantyInfoView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rmattaway
 */
public class CreateEditWarrantyInfoController {
  private WarrantyModel warrantyModel;
  private CreateEditWarrantyInfoView createWarranty;
  private Boolean CreateWarranty = true;
  private JDialog modalDialog;
  private Boolean cancelled = false;
  private Date warrantyCreationDate;
  public CreateEditWarrantyInfoController()
  {
    warrantyCreationDate = new Date();
    createWarranty = new CreateEditWarrantyInfoView();
    modalDialog = new JDialog();
    modalDialog.add(createWarranty);
    modalDialog.setTitle("Top Gear System - Create or Edit Warranty");
    createWarranty.setSubmitActionHandler(new SubmitListener());
    createWarranty.setCancelActionHandler(new CancelListener());
    modalDialog.setModal(true);
    modalDialog.pack();
    if(!CreateWarranty)
    {
      //loadCustomerInformation();      
    }
    modalDialog.setVisible(true);
  }
   class SubmitListener implements ActionListener{
    
    public void actionPerformed(ActionEvent e){
//      if(CreateWarranty)
//      {
//        warrantyModel = new WarrantyModel();
//      }
//      //setCustomerInformation();
//      if(CreateWarranty)
//      {
//        DataAccessLayer.CreateWarranty(warrantyModel);
//      }
//      else
//      {
//        DataAccessLayer.UpdateWarranty(warrantyModel);
//      }
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

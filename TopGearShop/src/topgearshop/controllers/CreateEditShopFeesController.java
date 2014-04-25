/*
 * Author: TopGear Group
 *
 * CreateEditShopFeesController provides the way to create and edit shop fee
 * items depending on the parameter values of the constructor. Because there is 
 * a requirement to find a shop fee item before editing the controller also is used
 * by the FindShopFeesController to visualize the shop fee item information
 *
 */

package topgearshop.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JDialog;
import topgearshop.models.RequiredFeesModel;
import topgearshop.views.CreateEditServiceItemView;
import topgearshop.views.CreateEditShopFeesView;

public class CreateEditShopFeesController {
  private RequiredFeesModel fees;
  private Boolean cancelled;
  private JDialog modalDialog;
  private Boolean CreateFees = true;
  private Date feeCreationDate;
  private CreateEditShopFeesView ceShopFees;
  
  public CreateEditShopFeesController(RequiredFeesModel rfm, Boolean readOnly)
  {
    feeCreationDate = new Date();
    if(rfm!=null)
    {
      CreateFees = false;
      fees = rfm;
    }
    
    ceShopFees = new CreateEditShopFeesView();

    modalDialog = new JDialog();
    modalDialog.add(ceShopFees);
    modalDialog.setTitle("Top Gear System - Create or Edit Shop Fees");
    if(readOnly)
    {
      setFoundInterface();
    }
    ceShopFees.setSubmitActionHandler(new SubmitListener());
    ceShopFees.setCancelActionListener(new CancelListener());
    modalDialog.setModal(true);
    modalDialog.pack();
    if(!CreateFees)
    {
      loadFeeInformation();      
    }
    modalDialog.setVisible(true);    
  }

  private void loadFeeInformation() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  private void setFoundInterface() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

/*
 * Author: TopGear Group
 *
 * CreateEditServiceItemController provides the way to create and edit service
 * items depending on the parameter values of the constructor. Because there is 
 * a requirement to find a service item before editing the controller also is used
 * by the FindServiceItemController to visualize the service item information
 *
 */

package topgearshop.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JDialog;
import topgearshop.models.ServiceItemModel;
import topgearshop.views.CreateEditPart;
import topgearshop.views.CreateEditServiceItemView;

public class CreateEditServiceItemController {
  private ServiceItemModel serviceItem;
  private Boolean cancelled;
  private JDialog modalDialog;
  private Boolean CreateServiceItem = true;
  private Date serviceItemCreationDate;
  private CreateEditServiceItemView ceServiceItem;
  
  public CreateEditServiceItemController(ServiceItemModel sm, Boolean readOnly)
  {
    serviceItemCreationDate = new Date();
    if(sm!=null)
    {
      CreateServiceItem = false;
      serviceItem = sm;
    }
    
    ceServiceItem = new CreateEditServiceItemView();

    modalDialog = new JDialog();
    modalDialog.add(ceServiceItem);
    modalDialog.setTitle("Top Gear System - Create or Edit Service Item");
    if(readOnly)
    {
      setFoundInterface();
    }
    ceServiceItem.setSubmitActionHandler(new SubmitListener());
    ceServiceItem.setCancelActionListener(new CancelListener());
    modalDialog.setModal(true);
    modalDialog.pack();
    if(!CreateServiceItem)
    {
      loadDiscountInformation();      
    }
    modalDialog.setVisible(true);     
  }

  private void loadDiscountInformation() {
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

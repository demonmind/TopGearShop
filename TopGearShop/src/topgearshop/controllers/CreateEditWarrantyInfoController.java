/*
 * Author: TopGear Group
 *
 * CreateEditWarrantyInfoController provides the way to create and edit warranty
 * informationdepending on the parameter values of the constructor. Because there is 
 * a requirement to find warranty information before editing the controller also is used
 * by the FindWarrantyInfoController to visualize the warranty information
 *
 */
package topgearshop.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JDialog;
import topgearshop.models.CustomerModel;
import topgearshop.models.WarrantyModel;
import topgearshop.utils.DataAccessLayer;
import topgearshop.views.CreateEditWarrantyInfoView;

public class CreateEditWarrantyInfoController {
  private WarrantyModel warrantyModel;
  private CreateEditWarrantyInfoView createWarranty;
  private Boolean CreateWarranty = true;
  private JDialog modalDialog;
  private Boolean cancelled = false;
  private Date warrantyCreationDate;
  public CreateEditWarrantyInfoController(WarrantyModel wm, Boolean readOnly)
  {
    if(wm!=null)
        CreateWarranty = false;
    
    warrantyCreationDate = new Date();
    createWarranty = new CreateEditWarrantyInfoView();
    modalDialog = new JDialog();
    modalDialog.add(createWarranty);
    modalDialog.setTitle("Top Gear System - Create or Edit Warranty");
    createWarranty.setSubmitActionHandler(new SubmitListener());
    createWarranty.setCancelActionHandler(new CancelListener());
    modalDialog.setModal(true);
    modalDialog.pack();
    
    createWarranty.WarrantyID.setEditable(false);

    modalDialog.setVisible(true);
  }
   class SubmitListener implements ActionListener{
    
    public void actionPerformed(ActionEvent e){
      if(CreateWarranty)
      {
        warrantyModel = new WarrantyModel();
      }
      setWarrantyInformation();
      if(CreateWarranty)
      {
        DataAccessLayer.CreateWarranty(warrantyModel);
      }
      else
      {
        DataAccessLayer.UpdateWarranty(warrantyModel);
      }
      modalDialog.dispose();
    }

    private void setWarrantyInformation() {
      warrantyModel.setWarranty(createWarranty.Warranty.getText());
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

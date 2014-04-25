/*
 * Author: TopGear Group
 *
 * CreateEditMaterialsListController provides the way to create and edit material
 * lists depending on the parameter values of the constructor. Because there is 
 * a requirement to find an inventory list before editing the controller also is used
 * by the FindMaterialsListController to visualize the material list information
 *
 */
package topgearshop.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import javax.swing.JDialog;
import topgearshop.models.MaterialsListModel;
import topgearshop.views.CreateEditMaterialsList;

public class CreateEditMaterialsListController {
  private List<MaterialsListModel> materialsList;
  private Boolean cancelled;
  private JDialog modalDialog;
  private Boolean CreateMaterialsList = true;
  private Date listCreationDate;
  private CreateEditMaterialsList ceMaterialsList;
  
  public CreateEditMaterialsListController(List<MaterialsListModel> ml, Boolean readOnly)
  {    
    listCreationDate = new Date();
    if(ml!=null)
    {
      CreateMaterialsList = false;
      materialsList = ml;
    }
    
    ceMaterialsList = new CreateEditMaterialsList();

    modalDialog = new JDialog();
    modalDialog.add(ceMaterialsList);
    modalDialog.setTitle("Top Gear System - Create or Edit Materials List");
    if(readOnly)
    {
      setFoundInterface();
    }
    ceMaterialsList.setSubmitActionHandler(new SubmitListener());
    ceMaterialsList.setCancelActionListener(new CancelListener());
    modalDialog.setModal(true);
    modalDialog.pack();
    if(!CreateMaterialsList)
    {
      loadDiscountInformation();      
    }
    modalDialog.setVisible(true);
    
  }

  private void setFoundInterface() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  private void loadDiscountInformation() {
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

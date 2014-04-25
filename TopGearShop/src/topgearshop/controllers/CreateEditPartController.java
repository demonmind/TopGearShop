/*
 * Author: TopGear Group
 *
 * CreateEditPartController provides the way to create and edit parts
 * depending on the parameter values of the constructor. Because there is 
 * a requirement to find a part before editing the controller also is used
 * by the FindPartController to visualize the part information
 *
 */
package topgearshop.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JDialog;
import topgearshop.models.PartsModel;
import topgearshop.views.CreateEditPart;

public class CreateEditPartController {
  private PartsModel part;
  private Boolean cancelled;
  private JDialog modalDialog;
  private Boolean CreatePart = true;
  private Date partCreationDate;
  private CreateEditPart cePart;
  
  public CreateEditPartController(PartsModel pm, Boolean readOnly)
  {
    partCreationDate = new Date();
    if(pm!=null)
    {
      CreatePart = false;
      part = pm;
    }
    
    cePart = new CreateEditPart();

    modalDialog = new JDialog();
    modalDialog.add(cePart);
    modalDialog.setTitle("Top Gear System - Create or Edit Part");
    if(readOnly)
    {
      setFoundInterface();
    }
    cePart.setSubmitActionHandler(new SubmitListener());
    cePart.setCancelActionListener(new CancelListener());
    modalDialog.setModal(true);
    modalDialog.pack();
    if(!CreatePart)
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

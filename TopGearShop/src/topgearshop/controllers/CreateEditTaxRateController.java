/*
 * Author: TopGear Group
 *
 * CreateEditTaxRateController provides the way to create and edit tax rate
 * items depending on the parameter values of the constructor. Because there is 
 * a requirement to find a tax rate item before editing the controller also is used
 * by the FindTaxRateController to visualize the shop fee item information
 *
 */
package topgearshop.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JDialog;
import topgearshop.models.TaxRateModel;
import topgearshop.views.CreateEditTaxView;

public class CreateEditTaxRateController {
  private TaxRateModel taxRate;
  private Boolean cancelled;
  private JDialog modalDialog;
  private Boolean CreateDiscount = true;
  private Date taxRateCreationDate;
  private CreateEditTaxView taxView;
  
  public CreateEditTaxRateController(TaxRateModel trm, Boolean readOnly)
  {
    taxRateCreationDate = new Date();
    if(trm!=null)
    {
      CreateDiscount = false;
      taxRate = trm;
    }
    
    taxView = new CreateEditTaxView();

    modalDialog = new JDialog();
    modalDialog.add(taxView);
    modalDialog.setTitle("Top Gear System - Create or Edit Discounts");
    if(readOnly)
    {
      setFoundInterface();
    }
    taxView.setSubmitActionHandler(new SubmitListener());
    taxView.setCancelActionListener(new CancelListener());
    modalDialog.setModal(true);
    modalDialog.pack();
    if(!CreateDiscount)
    {
      loadTaxInformation();      
    }
    modalDialog.setVisible(true);    
  }    

  private void setFoundInterface() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  private void loadTaxInformation() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  class SubmitListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      // The default cancelled value should be false. It is auto set when the
      // instance is created. It should only be set to false in the cancel event

      modalDialog.dispose();
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

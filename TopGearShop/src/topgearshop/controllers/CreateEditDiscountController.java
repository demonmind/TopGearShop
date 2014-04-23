/*
 * Author: TopGear Group
 *
 * CreateEditDiscountController provides the way to create and edit discounts
 * depending on the parameter values of the constructor. Because there is 
 * a requirement to find a discount before editing the controller also is used
 * by the FindDiscountController to visualize the discount information
 *
 */

package topgearshop.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JDialog;
import topgearshop.models.CustomerModel;
import topgearshop.models.DiscountsModel;
import topgearshop.utils.DataAccessLayer;
import topgearshop.views.CreateEditCustomerView;
import topgearshop.views.CreateEditDiscountView;

public class CreateEditDiscountController {
  private DiscountsModel discount;
  private Boolean cancelled;
  private JDialog modalDialog;
  private Boolean CreateDiscount = true;
  private Date discountCreationDate;
  private CreateEditDiscountView discountView;
  
  public CreateEditDiscountController(DiscountsModel dm, Boolean readOnly)
  { 
    discountCreationDate = new Date();
    if(dm!=null)
    {
      CreateDiscount = false;
      discount = dm;
    }
    
    discountView = new CreateEditDiscountView();

    modalDialog = new JDialog();
    modalDialog.add(discountView);
    modalDialog.setTitle("Top Gear System - Create or Edit Discounts");
    if(readOnly)
    {
      setFoundInterface();
    }
    discountView.setSubmitActionHandler(new SubmitListener());
    discountView.setCancelActionListener(new CancelListener());
    modalDialog.setModal(true);
    modalDialog.pack();
    if(!CreateDiscount)
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

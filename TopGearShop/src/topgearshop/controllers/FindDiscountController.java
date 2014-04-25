/*
 * Author: TopGear Group
 *
 * FindDiscountController provides the way to find already created discounts in
 * the system. The find discount interface is presented and depending on the criteria
 * provided the discount is returned. 
 *
 */

package topgearshop.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;

public class FindDiscountController {
  private JDialog modalDialog;
  private Boolean cancelled = false;
  public FindDiscountController()
  {
  
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

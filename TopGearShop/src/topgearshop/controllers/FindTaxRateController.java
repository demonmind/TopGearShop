/*
 * Author: TopGear Group
 *
 * FindTaxRateController provides the way to find already created tax rates in
 * the system. The find tax rate interface is presented and depending on the criteria
 * provided the tax rate information is returned. 
 *
 */

package topgearshop.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;

public class FindTaxRateController {
  private JDialog modalDialog;
  private Boolean cancelled = false;
  public FindTaxRateController()
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

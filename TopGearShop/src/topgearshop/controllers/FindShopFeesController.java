/*
 * Author: TopGear Group
 *
 * FindShopFeesController provides the way to find already created shop fees in
 * the system. The find shop fees interface is presented and depending on the criteria
 * provided the shop fee is returned. 
 *
 */

package topgearshop.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;

public class FindShopFeesController {
  private JDialog modalDialog;
  private Boolean cancelled = false;
  public FindShopFeesController()
  {
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
  
}

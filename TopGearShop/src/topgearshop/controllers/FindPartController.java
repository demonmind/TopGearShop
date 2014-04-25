/*
 * Author: TopGear Group
 *
 * FindPartController provides the way to find already created parts in
 * the system. The find part interface is presented and depending on the criteria
 * provided the part information is returned. 
 *
 */

package topgearshop.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;

public class FindPartController {
  private JDialog modalDialog;
  private Boolean cancelled = false;
  public FindPartController()
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

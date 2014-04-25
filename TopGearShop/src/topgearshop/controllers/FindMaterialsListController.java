/*
 * Author: TopGear Group
 *
 * FindMaterialsListController provides the way to find already created material lists in
 * the system. The find materials list interface is presented and depending on the criteria
 * provided the materials list is returned. 
 *
 */

package topgearshop.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;

public class FindMaterialsListController {
  private JDialog modalDialog;
  private Boolean cancelled = false;
  public FindMaterialsListController()
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

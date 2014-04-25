/*
 * Author: TopGear Group
 *
 * StatusPanelViewController keeps track of the application status and modifies
 * various sections of the activity panel to display information about the 
 * system to the user.
 *
 */
package topgearshop.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;

public class StatusPanelViewController {
  private JDialog modalDialog;
  private Boolean cancelled = false;
  public StatusPanelViewController()
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

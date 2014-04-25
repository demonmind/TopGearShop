/*
 * Author: TopGear Group
 *
 * ReportViewController provides a way for the system to take run predefined
 * reports required for the operations of the business. ReportViewController
 * will use various models as required by the specific reports to be run.
 * ReportViewController may also use various views to display reports with
 * different information
 *
 */


package topgearshop.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;

public class ReportViewController {
  private JDialog modalDialog;
  private Boolean cancelled = false;
  public ReportViewController()
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

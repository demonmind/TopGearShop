/*
 * Author: TopGear Group
 *
 * FindVehicleController provides the way to find already created vehicles in
 * the system. The find vehicle interface is presented and depending on the criteria
 * provided the vehicle information is returned..
 *
 */

package topgearshop.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import topgearshop.models.CustomerModel;
import topgearshop.models.VehicleModel;
import topgearshop.utils.DataAccessLayer;
import topgearshop.views.FindVehicleView;

public class FindVehicleController {
    /*
  All of the Controllers shall contain at least one view and one model
  It is possible to have many view and many models.
  The modalDialog is a container for our views such that we can easily
  get the return values from a modal form.
  */
  private FindVehicleView findVehicle;
  private JDialog modalDialog;
  private VehicleModel foundVehicle;
  private Boolean cancelled = false;
  
  // The construtor is the work horse because these objects do not need
  // to have a long life span
  public FindVehicleController()
  {
    findVehicle = new FindVehicleView();
    modalDialog = new JDialog();
    modalDialog.add(findVehicle);
    modalDialog.setTitle("Top Gear System - Find Vehicle");
    findVehicle.setSubmitActionHandler(new SubmitListener());
    findVehicle.setCancelActionListener(new CancelListener());
    modalDialog.setModal(true);
    modalDialog.pack();
    modalDialog.setVisible(true);
  }
  // Any view that implements a cancel button, which is practically all of them
  // needs to have a getCancelledStatus method. This can cascade to any controller
  // so the status of one action can be sent up the chain and handled as 
  // required
  public Boolean getCancelledStatus()
  {
    return cancelled;
  }
  public VehicleModel getVehicle()
  {
    return foundVehicle;
  }
  class SubmitListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      VehicleModel vm = new VehicleModel();
      vm.setVehicleIDNumber(findVehicle.VehicleIDNumber.getText());
      vm.setMake(findVehicle.Make.getText());
      vm.setModel(findVehicle.Model.getText());
      vm.setYear(findVehicle.Year.getText());
      foundVehicle = DataAccessLayer.FindVehicle(vm);
      modalDialog.dispose();
      if(!cancelled)
      {
        CreateEditVehicleController theFoundVehicle = new CreateEditVehicleController(foundVehicle, true);
        cancelled = theFoundVehicle.getCancelledStatus();
      }
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



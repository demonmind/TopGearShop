/*
 * Author: TopGear Group
 *
 * CreateEditVehicleController provides the way to create and edit vehicles
 * depending on the parameter values of the constructor. Because there is 
 * a requirement to find a vehicle before editing the controller also is used
 * by the FindVehicleController to visualize the vehicle information
 *
 */
package topgearshop.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JDialog;
import topgearshop.models.VehicleModel;
import topgearshop.utils.DataAccessLayer;
import topgearshop.views.CreateEditVehicleView;

public class CreateEditVehicleController {
  private VehicleModel vehicleModel;
  private CreateEditVehicleView ceVehicleView;
  private Boolean CreateVehicle = true;
  private JDialog modalDialog;
  private Boolean cancelled = false;
  private Date vehicleCreationDate;
  private Boolean readOnly;
  public CreateEditVehicleController(VehicleModel cm, Boolean readOnly)
  {
    this.readOnly = readOnly;
    vehicleCreationDate = new Date();
    if(cm!=null)
    {
      CreateVehicle = false;
      vehicleModel = cm;
    }
    
    ceVehicleView = new CreateEditVehicleView();

    modalDialog = new JDialog();
    modalDialog.add(ceVehicleView);
    modalDialog.setTitle("Top Gear System - Create or Edit Vehicle");
    if(readOnly)
    {
      setFoundInterface();
    }
    ceVehicleView.setSubmitActionHandler(new SubmitListener());
    ceVehicleView.setCancelActionListener(new CancelListener());
    modalDialog.setModal(true);
    modalDialog.pack();
    if(!CreateVehicle)
    {
      loadCustomerInformation();      
    }
    modalDialog.setVisible(true);
  }
  public Boolean getCancelledStatus()
  {
    return cancelled;
  }
  private void setFoundInterface()
  {
    modalDialog.setTitle("Top Gear System - Find Vehicle Results");
    ceVehicleView.Color.setEnabled(false);
    ceVehicleView.Make.setEnabled(false);
    ceVehicleView.Mileage.setEnabled(false);
    ceVehicleView.Model.setEnabled(false);
    ceVehicleView.VehicleIDNumber.setEnabled(false);
    ceVehicleView.Year.setEnabled(false);
  }
  private void loadCustomerInformation()
  {
    ceVehicleView.Color.setText(vehicleModel.getColor());
    ceVehicleView.Make.setText(vehicleModel.getMake());
    ceVehicleView.Mileage.setText(vehicleModel.getMileage().toString());
    ceVehicleView.Model.setText(vehicleModel.getModel());
    ceVehicleView.VehicleIDNumber.setText(vehicleModel.getVehicleIDNumber());
    ceVehicleView.Year.setText(vehicleModel.getYear());
    // this needs to be added 
    //ceVehicleView.vehicleCreationDate.setText(sdf.format(customerModel.getCustomerCreationDate()));
    
  }
  private void setCustomerInformation()
  {
      vehicleModel.setColor(ceVehicleView.Color.getText());
      vehicleModel.setMake(ceVehicleView.Make.getText());
      vehicleModel.setMileage(Integer.parseInt(ceVehicleView.Mileage.getText()));
      vehicleModel.setModel(ceVehicleView.Model.getText());
      vehicleModel.setVehicleIDNumber(ceVehicleView.VehicleIDNumber.getText());
      vehicleModel.setYear(ceVehicleView.Year.getText()); 
      // need to implement
      //vehicleModel.setVehicleCreationDate(vehicleCreationDate);
  }
  class SubmitListener implements ActionListener{
    
    public void actionPerformed(ActionEvent e){
      if(CreateVehicle)
      {
        vehicleModel = new VehicleModel();
      }
      setCustomerInformation();
      if(!readOnly)
        {
        if(CreateVehicle)
        {
          DataAccessLayer.CreateVehicle(vehicleModel);
        }
        else
        {
          DataAccessLayer.UpdateVehicle(vehicleModel);
        }
      }
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package topgearshop.controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import topgearshop.models.ServiceItemModel;
import topgearshop.views.CreateEditServiceItemView;
import topgearshop.utils.SequenceIDManager;
import topgearshop.utils.ConnectionManager;
/**
 *
 * @author rmattaway
 */
public class CreateEditServiceItemController {
  private ServiceItemModel serviceModel;
  private CreateEditServiceItemView serviceView;
  private Boolean CreateService = true;
  private JDialog modalDialog;
  private Boolean cancelled = false;
  
  public CreateEditServiceItemController(ServiceItemModel sm, Boolean readOnly)
  {
    if(sm!=null)
    {
      CreateService = false;
      serviceModel = sm;
    }
    
    serviceView = new CreateEditServiceItemView();

    modalDialog = new JDialog();
    modalDialog.add(serviceView);
    modalDialog.setTitle("Top Gear System - Create or Edit Service");
    if(readOnly)
    {
      setFoundInterface();
    }
    serviceView.setSubmitActionHandler(new SubmitListener());
    serviceView.setCancelActionListener(new CancelListener());
    modalDialog.setModal(true);
    modalDialog.pack();
    if(!CreateService)
    {
      loadServiceInformation();      
    }
    modalDialog.setLocationRelativeTo(null);
    modalDialog.setVisible(true);
  }
    
  private void setFoundInterface()
  {
    modalDialog.setTitle("Top Gear System - Find Service Results");
    serviceView.ServiceItemID.setEnabled(false);
    serviceView.ServiceItemName.setEnabled(false);
    serviceView.ServiceItemCost.setEnabled(false);
    serviceView.TimeRequiredToComplete.setEnabled(false);
    serviceView.MaterialListID.setEnabled(false);
    serviceView.TaxRateID.setEnabled(false); 
  }
  
  private void loadServiceInformation()
  {
    serviceView.ServiceItemID.setText(Integer.toString(serviceModel.getServiceItemID()));
    serviceView.ServiceItemName.setText(serviceModel.getServiceItemName());
    serviceView.ServiceItemCost.setText(String.valueOf(serviceModel.getServiceItemCost()));
    serviceView.TimeRequiredToComplete.setText(Integer.toString(serviceModel.getTimeRequiredToComplete()));
    serviceView.MaterialListID.setSelectedItem(serviceModel.getMaterialListID());
    serviceView.TaxRateID.setSelectedItem(serviceModel.getTaxRateID());
  }
  
  public void createItem(){
        
        PreparedStatement statement = null;
           
            try {
                Class.forName("org.sqlite.JDBC");
                Connection conn = ConnectionManager.getConnection();
                statement = (PreparedStatement) conn.prepareStatement("insert into service_items(serviceItemID,serviceItemName,serviceItemCost,timeRequiredToComplete,MaterialListID,TaxRateID)values(?,?,?,?,?,?)");
                statement.setInt(1, serviceModel.getServiceItemID());
                statement.setString(2, serviceModel.getServiceItemName());
                statement.setDouble(3, serviceModel.getServiceItemCost());
                statement.setInt(4, serviceModel.getTimeRequiredToComplete());
                statement.setInt(5, serviceModel.getMaterialListID());
                statement.setInt(6, serviceModel.getTaxRateID());
                statement.executeUpdate();

                conn.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
    }
  
  public void editServiceItem(ServiceItemModel serviceModel)
  {
    PreparedStatement statement = null;
    Connection conn;
    try
    {
        Class.forName("org.sqlite.JDBC");
        conn = ConnectionManager.getConnection();
        
        statement = (PreparedStatement) conn.prepareStatement("UPDATE customers "
                + "SET serviceItemID = ?,serviceItemName = ?,serviceItemCost = ?,"
                + "timeRequiredToComplete = ?,MaterialListID = ?,TaxRateID = ?");
                statement.setInt(1, serviceModel.getServiceItemID());
                statement.setString(2, serviceModel.getServiceItemName());
                statement.setDouble(3, serviceModel.getServiceItemCost());
                statement.setInt(4, serviceModel.getTimeRequiredToComplete());
                statement.setInt(5, serviceModel.getMaterialListID());
                statement.setInt(6, serviceModel.getTaxRateID());
                statement.execute();

        conn.close();
      
    }
    catch(Exception e){System.out.println(e.toString());}
    
  }
  
  class SubmitListener implements ActionListener{
    
    public void actionPerformed(ActionEvent e){
            if(CreateService)
      {
        serviceModel = new ServiceItemModel();
        boolean numberError = false;
      
            serviceModel.setServiceItemName(serviceView.ServiceItemName.getText());
            
            try{
            serviceModel.setMaterialListID(Integer.parseInt((String) serviceView.MaterialListID.getSelectedItem()));
            serviceModel.setTaxRateID(Integer.parseInt((String) serviceView.TaxRateID.getSelectedItem()));
            serviceModel.setServiceItemID(Integer.parseInt(serviceView.ServiceItemID.getText()));
            serviceModel.setServiceItemCost(Double.parseDouble(serviceView.ServiceItemCost.getText()));
            serviceModel.setTimeRequiredToComplete(Integer.parseInt(serviceView.TimeRequiredToComplete.getText()));
            
            
            }catch(Exception exc){
                JOptionPane.showMessageDialog(null, "Please enter a number where requiered","Information",JOptionPane.INFORMATION_MESSAGE);
                numberError = true;
            }
  
            if(!numberError){    
            createItem();
            modalDialog.dispose();
            }
      }      
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

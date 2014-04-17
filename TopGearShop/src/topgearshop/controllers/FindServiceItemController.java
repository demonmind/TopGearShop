/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package topgearshop.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import topgearshop.models.ServiceItemModel;
import topgearshop.views.FindServiceItemView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import topgearshop.utils.ConnectionManager;
import topgearshop.views.FindCustomerView;

/**
 *
 * @author Allan
 */
public class FindServiceItemController {
 
  private FindServiceItemView findService;
  private JDialog modalDialog;
  private ServiceItemModel foundService;
  
  
  // The construtor is the work horse because these objects do not need
  // to have a long life span
  public FindServiceItemController()
  {
    findService = new FindServiceItemView();
    modalDialog = new JDialog();
    modalDialog.add(findService);
    modalDialog.setTitle("Top Gear System - Find Service");
    findService.setSubmitActionHandler(new SubmitListener());
    findService.setCancelActionListener(new CancelListener());
    modalDialog.setModal(true);
    modalDialog.pack();
    modalDialog.setLocationRelativeTo(null);
    modalDialog.setVisible(true);
  }
  
  
  
  class SubmitListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
            
            PreparedStatement statement = null;
            ResultSet resultSet = null;
            Connection conn;
        
            
            try {
                Class.forName("org.sqlite.JDBC");
                conn = ConnectionManager.getConnection();
                statement = (PreparedStatement) conn.prepareStatement("select * from service_items where serviceItemName = ?;");
                statement.setString(1, findService.serviceName.getText());
                resultSet = statement.executeQuery();
                
                
                if(resultSet.next()){
                    foundService = new ServiceItemModel();
                    foundService.setServiceItemID(resultSet.getInt(1));
                    foundService.setServiceItemName(resultSet.getString(2));
                    foundService.setServiceItemCost(resultSet.getDouble(3));
                    foundService.setTimeRequiredToComplete(resultSet.getInt(4));
                    foundService.setMaterialListID(resultSet.getInt(5));
                    foundService.setTaxRateID(resultSet.getInt(6));
                    
                    conn.close();
                    
                    CreateEditServiceItemController controller = new CreateEditServiceItemController(foundService, false);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }   
            //conn.close();
            
            
            
            
    }
  }
  class CancelListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      // The default cancelled value should be false. It is auto set when the
      // instance is created. It should only be set to false in the cancel event
      modalDialog.dispose();
    }
  }
  
}

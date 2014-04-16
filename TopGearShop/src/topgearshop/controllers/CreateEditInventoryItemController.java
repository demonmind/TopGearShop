/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package topgearshop.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JDialog;
import topgearshop.models.EmployeeModel;
import topgearshop.models.InventoryItemModel;
import topgearshop.utils.DataAccessLayer;
import topgearshop.views.CreateEditEmployeeView;
import topgearshop.views.CreateEditInventoryItemView;

/**
 *
 * @author rmattaway
 */
public class CreateEditInventoryItemController {
  private CreateEditInventoryItemView createEditInventoryView;
  private InventoryItemModel inventoryItem;
  private Boolean cancelled = false;
  private Boolean Creating = true;
  private JDialog modalDialog;
  private Integer NewInventoryID;
  
  public CreateEditInventoryItemController(InventoryItemModel im, Boolean readOnly)
  {    
    if(im!=null)
    {
      Creating = false;
      inventoryItem = im;
    }
    
    createEditInventoryView = new CreateEditInventoryItemView();

    modalDialog = new JDialog();
    modalDialog.add(createEditInventoryView);
    modalDialog.setTitle("Top Gear System - Create or Edit Inventory");
    if(readOnly)
    {
      setFoundInterface();
    }
    createEditInventoryView.setSubmitActionHandler(new SubmitListener());
    createEditInventoryView.setCancelActionListener(new CancelListener());
    modalDialog.setModal(true);
    modalDialog.pack();
    if(!Creating)
    {
      loadModelInformation();      
    }
    else
    {
      NewInventoryID = DataAccessLayer.GetNextInventoryID();
      createEditInventoryView.InventoryItemID.setText(NewInventoryID.toString());
    }
    modalDialog.setVisible(true);
    
  }
  
  private void setModelInformation() {
    inventoryItem.setInventoryItemID(NewInventoryID);
    inventoryItem.setItemName(createEditInventoryView.ItemName.getText());
    inventoryItem.setItemCost(Double.parseDouble(createEditInventoryView.ItemCost.getText()));
    inventoryItem.setSellingPrice(Double.parseDouble(createEditInventoryView.SellingPrice.getText()));
    inventoryItem.setLocationInShop(createEditInventoryView.LocationInShop.getText());
    inventoryItem.setQuantityOnHand(Integer.parseInt(createEditInventoryView.QuantityOnHand.getText()));
    inventoryItem.setReorderLevel(Integer.parseInt(createEditInventoryView.ReorderLevel.getText()));
    inventoryItem.setGrossProfit(getGrossProfit());
  }
  private Double getGrossProfit()
  {
    return inventoryItem.getSellingPrice()-inventoryItem.getItemCost();
  }
  private void setFoundInterface() {
    
  }

  private void loadModelInformation() {

  }
  private InventoryItemModel validateModelInformation()
  {
    return DataAccessLayer.validateInventoryItem(inventoryItem);
  }
  class SubmitListener implements ActionListener{
    
    public void actionPerformed(ActionEvent e){
      if(Creating)
      {
        inventoryItem = new InventoryItemModel();
      }
      setModelInformation();
      if(Creating)
      {
        DataAccessLayer.CreateInventoryItem(inventoryItem);
      }
      else
      {
        DataAccessLayer.UpdateInventoryItem(inventoryItem);
      }
      InventoryItemModel existingInventoryItem = validateModelInformation();
      if(existingInventoryItem==null)
      {
        return;
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

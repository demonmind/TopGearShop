/*
 * Author: TopGear Group
 *
 * FindWarrantyInfoController provides the way to find already created warranties in
 * the system. The find warranty info interface is presented and depending on the criteria
 * provided the warranty information is returned..
 *
 */
package topgearshop.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import topgearshop.models.WarrantyModel;
import topgearshop.utils.DataAccessLayer;
import topgearshop.views.FindWarrantyView;

public class FindWarrantyInfoController {
  private WarrantyModel warrantyModel;
  private FindWarrantyView findWarranty;
  private JDialog modalDialog;
  private Boolean cancelled = false;
  private List<WarrantyModel> warranties;
  
  public FindWarrantyInfoController()
  {
    findWarranty = new FindWarrantyView();
    modalDialog = new JDialog();
    modalDialog.add(findWarranty);
    modalDialog.setTitle("Top Gear System - Find Warrantty");
    findWarranty.setSubmitActionHandler(new SubmitListener());
    findWarranty.setCancelActionListener(new CancelListener());
    getWarranties();
    setComboBoxModel();
    modalDialog.setModal(true);
    modalDialog.pack();
    modalDialog.setVisible(true);

  }
  private void getWarranties()
  {
    warranties = DataAccessLayer.GetWarranties();
  }
  private void setComboBoxModel()
  {
    Object[] models = new Object[warranties.size()];
    Integer idx = 0;
    for(WarrantyModel mod : warranties)
    {
      models[idx++] = mod.getWarranty();
    }
    DefaultComboBoxModel cboModel = new DefaultComboBoxModel(models);
    findWarranty.cboWarranties.setModel(cboModel);
  }
  public boolean getCancelledStatus() {
    return cancelled;
  }
  
  class SubmitListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      // The default cancelled value should be false. It is auto set when the
      // instance is created. It should only be set to false in the cancel event
      for(WarrantyModel wm : warranties)
      {
        if(wm.getWarranty().equals(findWarranty.cboWarranties.getSelectedItem()))
          System.out.println(wm.getWarrantyID());
      }
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

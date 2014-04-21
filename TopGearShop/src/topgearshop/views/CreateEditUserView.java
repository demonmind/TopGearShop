/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package topgearshop.views;

import java.awt.event.ActionListener;

/**
 *
 * @author rmattaway
 */
public class CreateEditUserView extends javax.swing.JPanel {

  /**
   * Creates new form CreateUserView
   */
  public CreateEditUserView() {
    initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    EmployeeID = new javax.swing.JTextField();
    UserName = new javax.swing.JTextField();
    Password = new javax.swing.JPasswordField();
    Salt = new javax.swing.JPasswordField();
    cmdSubmit = new javax.swing.JButton();
    cmdCancel = new javax.swing.JButton();
    jLabel1 = new javax.swing.JLabel();
    ConfirmPassword = new javax.swing.JPasswordField();

    jLabel2.setText("Employee ID (SSN):");

    jLabel3.setText("User Name:");

    jLabel4.setText("Password:");

    jLabel5.setText("Password Salt:");

    cmdSubmit.setText("Submit");
    cmdSubmit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cmdSubmitActionPerformed(evt);
      }
    });

    cmdCancel.setText("Cancel");

    jLabel1.setText("Confirm Password:");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel2)
              .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(EmployeeID, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
              .addComponent(UserName)
              .addComponent(Password)
              .addComponent(Salt)
              .addComponent(ConfirmPassword)))
          .addGroup(layout.createSequentialGroup()
            .addGap(80, 80, 80)
            .addComponent(cmdSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(EmployeeID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(UserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel4)
          .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(ConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel5)
          .addComponent(Salt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(cmdSubmit)
          .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap())
    );
  }// </editor-fold>//GEN-END:initComponents

  private void cmdSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSubmitActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_cmdSubmitActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  public javax.swing.JPasswordField ConfirmPassword;
  public javax.swing.JTextField EmployeeID;
  public javax.swing.JPasswordField Password;
  public javax.swing.JPasswordField Salt;
  public javax.swing.JTextField UserName;
  private javax.swing.JButton cmdCancel;
  private javax.swing.JButton cmdSubmit;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  // End of variables declaration//GEN-END:variables

  public void setSubmitActionHandler(ActionListener al) {
    cmdSubmit.addActionListener(al);
  }

  public void setCancelActionListener(ActionListener al) {
    cmdCancel.addActionListener(al);
  }
}

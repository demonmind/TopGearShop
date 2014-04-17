/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package topgearshop.views;

import java.awt.event.ActionListener;

import topgearshop.controllers.CreateEditCustomerController;

/**
 *
 * @author rmattaway
 */
public class FindCustomerView extends javax.swing.JPanel {

  /**
   * Creates new form FindCustomerView
   */
  public FindCustomerView() {
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

    lblFirstName = new javax.swing.JLabel();
    lblLastName = new javax.swing.JLabel();
    lblPhoneNumber = new javax.swing.JLabel();
    lblEmailAddress = new javax.swing.JLabel();
    FirstName = new javax.swing.JTextField();
    LastName = new javax.swing.JTextField();
    PhoneNumber = new javax.swing.JTextField();
    EmailAddress = new javax.swing.JTextField();
    cmdSubmit = new javax.swing.JButton();
    cmdCancel = new javax.swing.JButton();

    lblFirstName.setText("First Name:");

    lblLastName.setText("Last Name:");

    lblPhoneNumber.setText("Phone Number:");

    lblEmailAddress.setText("Email Address:");

    PhoneNumber.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        PhoneNumberActionPerformed(evt);
      }
    });

    cmdSubmit.setText("Submit");

    cmdCancel.setText("Cancel");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(lblFirstName)
              .addComponent(lblLastName)
              .addComponent(lblPhoneNumber)
              .addComponent(lblEmailAddress))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(LastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(PhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(EmailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(FirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addGroup(layout.createSequentialGroup()
            .addComponent(cmdSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(cmdCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        .addContainerGap(20, Short.MAX_VALUE))
    );

    layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {EmailAddress, FirstName, LastName, PhoneNumber});

    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(20, 20, 20)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(lblFirstName)
          .addComponent(FirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(lblLastName)
          .addComponent(LastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(lblPhoneNumber)
          .addComponent(PhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(7, 7, 7)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(lblEmailAddress)
          .addComponent(EmailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(cmdSubmit)
          .addComponent(cmdCancel))
        .addContainerGap())
    );
  }// </editor-fold>//GEN-END:initComponents

  private void PhoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhoneNumberActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_PhoneNumberActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  public javax.swing.JTextField EmailAddress;
  public javax.swing.JTextField FirstName;
  public javax.swing.JTextField LastName;
  public javax.swing.JTextField PhoneNumber;
  private javax.swing.JButton cmdCancel;
  private javax.swing.JButton cmdSubmit;
  private javax.swing.JLabel lblEmailAddress;
  private javax.swing.JLabel lblFirstName;
  private javax.swing.JLabel lblLastName;
  private javax.swing.JLabel lblPhoneNumber;
  // End of variables declaration//GEN-END:variables

  public void setSubmitActionHandler(ActionListener al) {
    cmdSubmit.addActionListener(al);
  }

  public void setCancelActionListener(ActionListener al) {
    cmdCancel.addActionListener(al);
  }
}

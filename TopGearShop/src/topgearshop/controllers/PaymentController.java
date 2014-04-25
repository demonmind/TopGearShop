/*
 * Author: TopGear Group
 *
 * PaymentController provides a way for the system to take payments. The payment
 * controller uses two models, PaymentTypesModel and PaymentModel. The payment
 * controller presents the user with Payments view which takes all of the 
 * payment information and depending on the PaymentType a computer based
 * authorization may take place. Otherwise, the system takes the payment as
 * cash, check or money order.
 *
 */

package topgearshop.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import topgearshop.models.PaymentTypesModel;
import topgearshop.models.PaymentsModel;

public class PaymentController {
  private PaymentTypesModel paymentType;
  private PaymentsModel payment;
  private JDialog modalDialog;
  private Boolean cancelled = false;
  
  public PaymentController()
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

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

import topgearshop.models.PaymentTypesModel;
import topgearshop.models.PaymentsModel;

public class PaymentController {
  private PaymentTypesModel paymentType;
  private PaymentsModel payment;
  
  public PaymentController()
  {
    
  }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package topgearshop.utils;

import javax.swing.JOptionPane;

/**
 *
 * @author rmattaway
 */
public class Notifications {
  public static void DisplayNotification(String message)
  {
    JOptionPane.showMessageDialog(null, message,"Information",JOptionPane.INFORMATION_MESSAGE);
  }
}

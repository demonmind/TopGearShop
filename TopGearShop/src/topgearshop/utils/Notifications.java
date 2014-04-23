/*
 * Author: TopGear Group
 * Notifications is a quick simple way to display a message box in the system.
 * 
 */
package topgearshop.utils;

import javax.swing.JOptionPane;

public class Notifications {
  public static void DisplayNotification(String message)
  {
    JOptionPane.showMessageDialog(null, message,"Information",JOptionPane.INFORMATION_MESSAGE);
  }
}

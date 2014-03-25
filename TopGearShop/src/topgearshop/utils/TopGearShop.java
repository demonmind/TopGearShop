/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package topgearshop.utils;

/**
 *
 * @author kleon
 */
public class TopGearShop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      CredentialsModel cm = new CredentialsModel();
      MainWindow mw = new MainWindow();
      mw.SetCredentialModel(cm);
      mw.setVisible(true);
      System.out.println(cm.getPassword());
      System.out.println(cm.getUserName());
    }
    
}

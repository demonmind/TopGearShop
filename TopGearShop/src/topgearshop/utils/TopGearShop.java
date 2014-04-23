/*
 * Author: TopGear Group
 * TopGearShop is the main entry point into the TopGear system. The main method
 * creates a login controller which validates the user login and either creates
 * the main interface or exits because user credentials are not supplied
 * 
 */

package topgearshop.utils;

import topgearshop.controllers.*;
import topgearshop.models.CredentialsModel;
import topgearshop.views.*;

public class TopGearShop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      CredentialsModel cm = new CredentialsModel();
      LoginController lc = new LoginController();
      cm = lc.getCredentials();
      TopGearShopMainUIController tgsUI = new TopGearShopMainUIController(cm);
    }
}

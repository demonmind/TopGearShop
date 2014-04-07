/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package topgearshop.utils;

import topgearshop.controllers.*;
import topgearshop.models.CredentialsModel;
import topgearshop.views.*;

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
      LoginController lc = new LoginController();
      cm = lc.getCredentials();
      TopGearShopMainUIController tgsUI = new TopGearShopMainUIController(cm);
    }
}

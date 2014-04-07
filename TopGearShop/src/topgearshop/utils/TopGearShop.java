/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package topgearshop.utils;

import topgearshop.controllers.TopGearShopMainUIController;
import topgearshop.models.*;

/**
 *
 * @author kleon
 */
import java.sql.Connection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import topgearshop.controllers.LoginController;
import topgearshop.views.*;
public class TopGearShop {

    /**
     * @param args the command line arguments
     */
  
    public static void main(String[] args) {
      LoginController lic = new LoginController();
      
      Connection connection = null;
      PreparedStatement ps = null;        
      ResultSet resultSet = null;

      
      TopGearShopMainUIController UI = new TopGearShopMainUIController();
      CredentialsModel cm = new CredentialsModel();
      ActivityTypeModel am = new ActivityTypeModel();
      
      try {
        // TODO code application logic here
        connection = ConnectionManager.getConnection();
      } catch (ClassNotFoundException ex) {
        Logger.getLogger(TopGearShop.class.getName()).log(Level.SEVERE, null, ex);
      } catch (SQLException ex) {
        Logger.getLogger(TopGearShop.class.getName()).log(Level.SEVERE, null, ex);
      }
      try{
        ps = (PreparedStatement)connection.prepareStatement("select * from activity_type where activityName='Login'");
        resultSet = ps.executeQuery();
        am.setActivityTypeID(resultSet.getInt(1));
        am.setActivityName(resultSet.getString(2));
        am.setRoleID(resultSet.getInt(3));
      }
      catch(Exception e){
        
      }
      
      UI.setCredentialsModel(lic.getCredentials());
      UI.setActivityModel(am);
      UI.showView();
      
//      CredentialsModel cm = new CredentialsModel();
//      MainWindow mw = new MainWindow();
//      mw.SetCredentialModel(cm);
//      mw.setVisible(true);
//      System.out.println(cm.getPassword());
//      System.out.println(cm.getUserName());
    }
    
}

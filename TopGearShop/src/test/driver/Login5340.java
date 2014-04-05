/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.driver;
import topgearshop.controllers.*;
import topgearshop.models.*;
import topgearshop.views.*;

/**
 *
 * @author Allan
 */
public class Login5340 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       LoginView view = new LoginView();
       CredentialsModel model = new CredentialsModel();
       LoginController controller = new LoginController(view, model);
       view.setLocationRelativeTo(null);
       view.setVisible(true);

    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package topgearshop.utils;


/**
 *
 * @author rmattaway
 */
public class TestStubs {
  public static boolean ValidateLogin(CredentialsModel credentials)
  {
    if(credentials.getUserName().equals("admin") && credentials.getPassword().equals("admin"))
    {
      return true;
    }
    return false;
  }
}

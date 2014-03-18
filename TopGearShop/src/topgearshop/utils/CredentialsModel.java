/** Credential contains all of the properties to identity a user
*   and their level of responsibility in the system
*
* Author: Robert Attaway
*
* by TopGear. 
* static class
*/

package topgearshop.utils;

import java.util.List;

public class CredentialsModel{
  private Integer userIDNumber=null;
  private String userName="";
  private String passWord="";
  private List<String> userRoles=null;
  private Boolean isAuthenticated = false; // Obviously this is the default

  public CredentialsModel(String userName, String passWord){
  }
  public CredentialsModel(){}

  /**
  * setter - User Name
  * @pre - none
  * @post - none
  * @param userName is the username used to validate the login
  */
  public void setUserName(String userName){
    this.userName = userName;
  }
  /**
  * getter - User Name
  * @pre - none
  * @post - returns user Name as string
  * @return userName
  */
  public String getUserName(){
    return userName;
  }
  /**
  * setter - password
  * @pre - none
  * @post - none
  * @param passWord the password for the user. Note: No getter for this property
  */
  public void setPassword(String passWord){
    this.passWord = passWord;
  }
  /** Get Password is protected
   * @pre
   * @post
   * @return passWord
   */
  protected String getPassword()
  {
    return this.passWord;
  }
  /**
  * getter - User Roles
  * @pre - none
  * @post - none
  * @return A list of roles associated with this user.
  */
  public List<String> getUserRoles(){
    return this.userRoles;
  }
  /** Protected method so only those classes that interact with this data model
   *  can set the value
   * @pre - none
   * @post - none
   * @param isAuthenticated 
   */
  protected void setIsUserAuthenticated(Boolean isAuthenticated)
  {
    this.isAuthenticated = isAuthenticated;
  }
  /**
  * getter - isAuthenticated
  * @pre - none
  * @post - none
  * @return if the user is authenticated true is returned, else false
  */
  public Boolean isUserAuthenticated(){
    return this.isAuthenticated;
  }
}

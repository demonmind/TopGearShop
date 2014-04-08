/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package topgearshop.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import topgearshop.models.*;


/**
 *
 * @author rmattaway
 */
public class DataAccessLayer {
  public static boolean ChangePassword(CredentialsModel credentials, String newPassword)
  {
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try
    {
        Class.forName("org.sqlite.JDBC");
        Connection conn = ConnectionManager.getConnection();

        statement = (PreparedStatement) conn.prepareStatement("select * from credentials where userName=? and password=?;");
        statement.setString(1,credentials.getUserName());
        statement.setString(2,credentials.getPassword());
        resultSet = statement.executeQuery();
        if(resultSet.next())
        {
          statement = (PreparedStatement) conn.prepareStatement("UPDATE credentials SET password = ? where employeeID = ?;");
          statement.setString(1,newPassword);
          statement.setString(2,credentials.getEmployeeID());
          statement.executeUpdate();
        }
        conn.close();
      return true;
    }
    catch(Exception e){System.out.println(e.toString());}
    return false;
  }
  
  public static boolean CreateCustomer(CustomerModel customerModel)
  {
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    Connection conn;
    try
    {
        Class.forName("org.sqlite.JDBC");
        conn = ConnectionManager.getConnection();

        if(customerModel.getCustomerID() == null)
          customerModel.setCustomerID(DataAccessLayer.GetNextCustomerID());
        statement = (PreparedStatement) conn.prepareStatement("select * from customers where phoneNumber=?;");
        statement.setString(1,customerModel.getPhoneNumber());
        resultSet = statement.executeQuery();
        
        if(!resultSet.next())
        {
          conn.close();
          conn = ConnectionManager.getConnection();
          statement = (PreparedStatement) conn.prepareStatement("INSERT INTO customers(customerID,phoneNumber,firstName,lastName,emailAddress,streetAddress,city,state,zipCode) VALUES (?,?,?,?,?,?,?,?,?)");
          statement.setInt(1,customerModel.getCustomerID());
          statement.setString(2,customerModel.getPhoneNumber());
          statement.setString(3,customerModel.getFirstName());
          statement.setString(4,customerModel.getLastName());
          statement.setString(5,customerModel.getEmailAddress());
          statement.setString(6,customerModel.getStreetAddress());
          statement.setString(7,customerModel.getCity());
          statement.setString(8,customerModel.getState());
          statement.setString(9,customerModel.getZipCode());
          statement.execute();
        }
        conn.close();
      return true;
    }
    catch(Exception e){System.out.println(e.toString());}
    return false;
  }
  
  public static int GetNextCustomerID()
  {
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try
    {
        Class.forName("org.sqlite.JDBC");
        Connection conn = ConnectionManager.getConnection();

        statement = (PreparedStatement) conn.prepareStatement("select max(customerID) from customers;");
        resultSet = statement.executeQuery();
        if(resultSet.next())
        {
          int newID = resultSet.getInt(1) + 1;
          conn.close();
          return newID;
        }
    }
    catch(Exception e){System.out.println(e.toString());}
    return -1; // Convert this to a static variable
  }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package topgearshop.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
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

    public static boolean CreateUser(CredentialsModel credentials)
  {
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    Connection conn;
    try
    {
        Class.forName("org.sqlite.JDBC");
        conn = ConnectionManager.getConnection();

        statement = (PreparedStatement) conn.prepareStatement("select * from credentials where employeeID=?;");
        statement.setString(1,credentials.getEmployeeID());
        resultSet = statement.executeQuery();
        
        if(!resultSet.next())
        {
          conn.close();
          conn = ConnectionManager.getConnection();
          statement = (PreparedStatement) conn.prepareStatement("INSERT INTO credentials(employeeID,userName,password,salt) VALUES (?,?,?,?)");
          statement.setString(1,credentials.getEmployeeID());
          statement.setString(2,credentials.getUserName());
          statement.setString(3,credentials.getPassword());
          statement.setString(4,credentials.getSalt());
          statement.execute();
        }
        conn.close();
      return true;
    }
    catch(Exception e){System.out.println(e.toString());}
    return false;
  }
    
  public static boolean UpdateCustomer(CustomerModel customerModel)
  {
    PreparedStatement statement = null;
    Connection conn;
    try
    {
        Class.forName("org.sqlite.JDBC");
        conn = ConnectionManager.getConnection();
        
        statement = (PreparedStatement) conn.prepareStatement("UPDATE customers "
                + "SET phoneNumber = ?,firstName = ?,lastName = ?, "
                + "emailAddress = ?, streetAddress = ?, city = ?, state = ?, "
                + "zipCode = ? where customerID = ?");
        statement.setString(1,customerModel.getPhoneNumber());
        statement.setString(2,customerModel.getFirstName());
        statement.setString(3,customerModel.getLastName());
        statement.setString(4,customerModel.getEmailAddress());
        statement.setString(5,customerModel.getStreetAddress());
        statement.setString(6,customerModel.getCity());
        statement.setString(7,customerModel.getState());
        statement.setString(8,customerModel.getZipCode());
        statement.setInt(9,customerModel.getCustomerID());
        statement.execute();

        conn.close();
      return true;
    }
    catch(Exception e){System.out.println(e.toString());}
    return false;
  }
  
  public static CustomerModel getACustomer(String phone)
  {
    CustomerModel cm = new CustomerModel();
    
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try
    {
        Connection conn;
        Class.forName("org.sqlite.JDBC");
        conn = ConnectionManager.getConnection();

        statement = (PreparedStatement) conn.prepareStatement("select * from customers where phoneNumber = ?;");
        statement.setString(1,phone);
        resultSet = statement.executeQuery();
        if(resultSet.next())
        {
          //customerID,phoneNumber,firstName,lastName,emailAddress,streetAddress,city,state,zipCode
          cm.setCustomerID(resultSet.getInt(1));
          cm.setPhoneNumber(resultSet.getString(2));
          cm.setFirstName(resultSet.getString(3));
          cm.setLastName(resultSet.getString(4));
          cm.setEmailAddress(resultSet.getString(5));
          cm.setStreetAddress(resultSet.getString(6));
          cm.setCity(resultSet.getString(7));
          cm.setState(resultSet.getString(8));
          cm.setZipCode(resultSet.getString(9));
        }
      conn.close();
    }
    catch(Exception e){}
    return cm;
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

  public static CustomerModel FindCustomer(CustomerModel cm) {
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    CustomerModel foundCustomer = new CustomerModel();
    try
    {
        Class.forName("org.sqlite.JDBC");
        Connection conn = ConnectionManager.getConnection();
        // Try phone
        statement = (PreparedStatement) conn.prepareStatement("select * from customers where phoneNumber = ?;");
        statement.setString(1, cm.getPhoneNumber());
        resultSet = statement.executeQuery();
        if(resultSet.next())
        {
          //customerID,phoneNumber,firstName,lastName,emailAddress,streetAddress,city,state,zipCode
          foundCustomer.setCustomerID(resultSet.getInt(1));
          foundCustomer.setPhoneNumber(resultSet.getString(2));
          foundCustomer.setFirstName(resultSet.getString(3));
          foundCustomer.setLastName(resultSet.getString(4));
          foundCustomer.setEmailAddress(resultSet.getString(5));
          foundCustomer.setStreetAddress(resultSet.getString(6));
          foundCustomer.setCity(resultSet.getString(7));
          foundCustomer.setState(resultSet.getString(8));
          foundCustomer.setZipCode(resultSet.getString(9));
          foundCustomer.setCustomerCreationDate(new Date(resultSet.getDate(10).toString()));
          conn.close();
          return foundCustomer;
        }
        // try email
        statement = (PreparedStatement) conn.prepareStatement("select * from customers where emailAddress = ?;");
        statement.setString(1, cm.getEmailAddress());
        resultSet = statement.executeQuery();
        if(resultSet.next())
        {
          //customerID,phoneNumber,firstName,lastName,emailAddress,streetAddress,city,state,zipCode
          foundCustomer.setCustomerID(resultSet.getInt(1));
          foundCustomer.setPhoneNumber(resultSet.getString(2));
          foundCustomer.setFirstName(resultSet.getString(3));
          foundCustomer.setLastName(resultSet.getString(4));
          foundCustomer.setEmailAddress(resultSet.getString(5));
          foundCustomer.setStreetAddress(resultSet.getString(6));
          foundCustomer.setCity(resultSet.getString(7));
          foundCustomer.setState(resultSet.getString(8));
          foundCustomer.setZipCode(resultSet.getString(9));
          foundCustomer.setCustomerCreationDate(new Date(resultSet.getDate(10).toString()));
          conn.close();
          return foundCustomer;
        }
        
        statement = (PreparedStatement) conn.prepareStatement("select * from customers where firstName = ? and lastName = ?;");
        statement.setString(1, cm.getFirstName());
        statement.setString(2, cm.getLastName());
        
        resultSet = statement.executeQuery();
        if(resultSet.next())
        {
          //customerID,phoneNumber,firstName,lastName,emailAddress,streetAddress,city,state,zipCode
          foundCustomer.setCustomerID(resultSet.getInt(1));
          foundCustomer.setPhoneNumber(resultSet.getString(2));
          foundCustomer.setFirstName(resultSet.getString(3));
          foundCustomer.setLastName(resultSet.getString(4));
          foundCustomer.setEmailAddress(resultSet.getString(5));
          foundCustomer.setStreetAddress(resultSet.getString(6));
          foundCustomer.setCity(resultSet.getString(7));
          foundCustomer.setState(resultSet.getString(8));
          foundCustomer.setZipCode(resultSet.getString(9));
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          String c = resultSet.getString(10);
          System.out.println("Input date: " + c);
          foundCustomer.setCustomerCreationDate(sdf.parse(resultSet.getString(10)));
          conn.close();
          return foundCustomer;
        }
        conn.close();
    }
    catch(Exception e){System.out.println(e.toString());}
    return foundCustomer; // Convert this to a static variable
    
  }

  public static Boolean UpdateUser(CredentialsModel systemUserModel) {
    PreparedStatement statement = null;
    Connection conn;
    try
    {
        Class.forName("org.sqlite.JDBC");
        conn = ConnectionManager.getConnection();
        
        statement = (PreparedStatement) conn.prepareStatement("UPDATE credentials "
                + "SET password = ?, salt = ? where employeeID = ?" );
        statement.setString(1,systemUserModel.getPassword());
        statement.setString(2,systemUserModel.getSalt());
        statement.setString(3,systemUserModel.getUserName());
        statement.execute();

        conn.close();
      return true;
    }
    catch(Exception e){System.out.println(e.toString());}
    return false;    
  }

  public static Boolean CreateEmployee(EmployeeModel employee) {
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    Connection conn;
    try
    {
        Class.forName("org.sqlite.JDBC");
        conn = ConnectionManager.getConnection();

        statement = (PreparedStatement) conn.prepareStatement("select * from employee where employeeID=?;");
        statement.setInt(1,employee.getEmployeeID());
        resultSet = statement.executeQuery();
        
        if(!resultSet.next())
        {
          conn.close();
          conn = ConnectionManager.getConnection();
          statement = (PreparedStatement) conn.prepareStatement("INSERT INTO employee(employeeID,firstName,middleName,lastName,dateOfBirth,driversLicenseNumber,employeeTypeID) VALUES (?,?,?,?,?,?,?)");
          statement.setInt(1,employee.getEmployeeID());
          statement.setString(2,employee.getFirstName());
          statement.setString(3,employee.getMiddleName());
          statement.setString(4,employee.getLastName());
          
          SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
          statement.setString(5,sdf.format(employee.getDateOfBirth()));
          statement.setString(6,employee.getDriversLicenseNumber());
          statement.setInt(7,employee.getEmployeeTypeID());
          statement.execute();
        }
        conn.close();
      return true;
    }
    catch(Exception e){System.out.println(e.toString());}
    return false;
    
  }

  public static void UpdateEmployee(EmployeeModel employee) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  public static EmployeeModel FindEmployee(EmployeeModel employee) {
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    EmployeeModel foundEmployee = new EmployeeModel();
    try
    {
        Class.forName("org.sqlite.JDBC");
        Connection conn = ConnectionManager.getConnection();
        // Try id (SSN)
        statement = (PreparedStatement) conn.prepareStatement("select * from employee where employeeID = ?;");
        statement.setInt(1, employee.getEmployeeID());
        resultSet = statement.executeQuery();
        if(resultSet.next())
        {
          //customerID,phoneNumber,firstName,lastName,emailAddress,streetAddress,city,state,zipCode
          foundEmployee.setEmployeeID(resultSet.getInt(1));
          foundEmployee.setFirstName(resultSet.getString(2));
          foundEmployee.setMiddleName(resultSet.getString(3));
          foundEmployee.setLastName(resultSet.getString(4));
          foundEmployee.setDateOfBirth(resultSet.getDate(5));
          foundEmployee.setDriversLicenseNumber(resultSet.getString(6));
          foundEmployee.setEmployeeTypeID(resultSet.getInt(7));
          conn.close();
          return foundEmployee;
        }
        // try drivers license
        statement = (PreparedStatement) conn.prepareStatement("select * from employee where driversLicenseNumber = ?;");
        statement.setString(1, employee.getDriversLicenseNumber());
        resultSet = statement.executeQuery();
        if(resultSet.next())
        {
          //customerID,phoneNumber,firstName,lastName,emailAddress,streetAddress,city,state,zipCode
          foundEmployee.setEmployeeID(resultSet.getInt(1));
          foundEmployee.setFirstName(resultSet.getString(2));
          foundEmployee.setMiddleName(resultSet.getString(3));
          foundEmployee.setLastName(resultSet.getString(4));
          foundEmployee.setDateOfBirth(resultSet.getDate(5));
          foundEmployee.setDriversLicenseNumber(resultSet.getString(6));
          foundEmployee.setEmployeeTypeID(resultSet.getInt(7));
          conn.close();
          return foundEmployee;
        }
        
        statement = (PreparedStatement) conn.prepareStatement("select * from employee where firstName = ? and lastName = ? and dateOfBirth = ?;");
        statement.setString(1, employee.getDriversLicenseNumber());
        resultSet = statement.executeQuery();
        if(resultSet.next())
        {
          //customerID,phoneNumber,firstName,lastName,emailAddress,streetAddress,city,state,zipCode
          foundEmployee.setEmployeeID(resultSet.getInt(1));
          foundEmployee.setFirstName(resultSet.getString(2));
          foundEmployee.setMiddleName(resultSet.getString(3));
          foundEmployee.setLastName(resultSet.getString(4));
          foundEmployee.setDateOfBirth(resultSet.getDate(5));
          foundEmployee.setDriversLicenseNumber(resultSet.getString(6));
          foundEmployee.setEmployeeTypeID(resultSet.getInt(7));
          conn.close();
          return foundEmployee;
        }
        conn.close();
    }
    catch(Exception e){System.out.println(e.toString());}
    return foundEmployee; // Convert this to a static variable
  }


  public static Boolean CreateInventoryItem(InventoryItemModel inventoryItem) {
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    Connection conn;
    try
    {
        Class.forName("org.sqlite.JDBC");
        conn = ConnectionManager.getConnection();

        statement = (PreparedStatement) conn.prepareStatement("select * from inventory_items where inventoryItemID=?;");
        statement.setInt(1,inventoryItem.getInventoryItemID());
        resultSet = statement.executeQuery();
        
        if(!resultSet.next())
        {
          conn.close();
          conn = ConnectionManager.getConnection();
          statement = (PreparedStatement) conn.prepareStatement("INSERT INTO inventory_items(inventoryItemID,itemName,itemCost,sellingPrice,locationInShop,quantityOnHand,reorderLevel,grossProfit) VALUES (?,?,?,?,?,?,?,?)");
          statement.setInt(1,inventoryItem.getInventoryItemID());
          statement.setString(2,inventoryItem.getItemName());
          statement.setDouble(3,inventoryItem.getItemCost());
          statement.setDouble(4,inventoryItem.getSellingPrice());
          statement.setString(5,inventoryItem.getLocationInShop());
          statement.setInt(6,inventoryItem.getQuantityOnHand());
          statement.setInt(7,inventoryItem.getReorderLevel());
          statement.setDouble(8,inventoryItem.getGrossProfit());
          statement.execute();
        }
        conn.close();
      return true;
    }
    catch(Exception e){System.out.println(e.toString());}
    return false;
  }

  public static void UpdateInventoryItem(InventoryItemModel inventoryItem) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  public static InventoryItemModel validateInventoryItem(InventoryItemModel inventoryItem) {
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    InventoryItemModel foundInventoryItem = new InventoryItemModel();
    try
    {
        Class.forName("org.sqlite.JDBC");
        Connection conn = ConnectionManager.getConnection();
        // Try id (SSN)
        statement = (PreparedStatement) conn.prepareStatement("select * from inventory_items where inventoryItemID = ?;");
        statement.setString(1, inventoryItem.getInventoryItemID().toString());
        resultSet = statement.executeQuery();
        if(resultSet.next())
        {
          //customerID,phoneNumber,firstName,lastName,emailAddress,streetAddress,city,state,zipCode
          foundInventoryItem.setInventoryItemID(Integer.SIZE);
          foundInventoryItem.setItemName(null);
          foundInventoryItem.setGrossProfit(Double.NaN);
          foundInventoryItem.setSellingPrice(Double.NaN);
          foundInventoryItem.setLocationInShop(null);
          foundInventoryItem.setQuantityOnHand(Integer.MIN_VALUE);
          foundInventoryItem.setReorderLevel(Integer.MIN_VALUE);
          foundInventoryItem.setGrossProfit(Double.NaN);
          conn.close();
          return foundInventoryItem;
        }
    }
    catch(Exception e)
    {
      
    }
    return foundInventoryItem;
  }
  public static int GetNextInventoryID()
  {
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try
    {
        Class.forName("org.sqlite.JDBC");
        Connection conn = ConnectionManager.getConnection();

        statement = (PreparedStatement) conn.prepareStatement("select max(inventoryItemID) from inventory_items;");
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
  public static Object[] getEmployeeTypes()
  {
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    List<String> employeeTypes = new ArrayList<String>();
    try
    {
        Class.forName("org.sqlite.JDBC");
        Connection conn = ConnectionManager.getConnection();

        statement = (PreparedStatement) conn.prepareStatement("select employeeType from employee_types order by employeeTypeID;");
        resultSet = statement.executeQuery();
        while(resultSet.next())
        {
          employeeTypes.add(resultSet.getString(1));
        }
        conn.close();
        return employeeTypes.toArray(new Object[employeeTypes.size()]);
    }
    catch(Exception e){System.out.println(e.toString());}
    return employeeTypes.toArray(new Object[employeeTypes.size()]); // Convert this to a static variable
    
  }

  public static Boolean CreateVehicle(VehicleModel vehicleModel) {
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    Connection conn;
    try
    {
        Class.forName("org.sqlite.JDBC");
        conn = ConnectionManager.getConnection();

        statement = (PreparedStatement) conn.prepareStatement("select * from vehicles where vehicleIDNumber=?;");
        statement.setString(1,vehicleModel.getVehicleIDNumber());
        resultSet = statement.executeQuery();
        
        if(!resultSet.next())
        {
          conn.close();
          conn = ConnectionManager.getConnection();
          statement = (PreparedStatement) conn.prepareStatement("INSERT INTO vehicles(vehicleIDNumber,year,make,model,color,mileage) VALUES (?,?,?,?,?,?)");
          statement.setString(1,vehicleModel.getVehicleIDNumber());
          statement.setString(2,vehicleModel.getYear());
          statement.setString(3,vehicleModel.getMake());
          statement.setString(4,vehicleModel.getModel());
          statement.setString(5,vehicleModel.getColor());
          statement.setInt(6,vehicleModel.getMileage());
          statement.execute();
        }
        conn.close();
      return true;
    }
    catch(Exception e){System.out.println(e.toString());}
    return false;
  }

  public static void UpdateVehicle(VehicleModel vehicleModel) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  public static VehicleModel FindVehicle(VehicleModel vm) {
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    VehicleModel foundVehicle = new VehicleModel();
    try
    {
        Class.forName("org.sqlite.JDBC");
        Connection conn = ConnectionManager.getConnection();
        // Try id (SSN)
        statement = (PreparedStatement) conn.prepareStatement("select * from vehicles where vehicleIDNumber = ?;");
        statement.setString(1, vm.getVehicleIDNumber());
        resultSet = statement.executeQuery();
        if(resultSet.next())
        {
          //customerID,phoneNumber,firstName,lastName,emailAddress,streetAddress,city,state,zipCode
          foundVehicle.setVehicleIDNumber(resultSet.getString(1));
          foundVehicle.setYear(resultSet.getString(2));
          foundVehicle.setMake(resultSet.getString(3));
          foundVehicle.setModel(resultSet.getString(4));
          foundVehicle.setColor(resultSet.getString(5));
          foundVehicle.setMileage(resultSet.getInt(6));
          conn.close();
          return foundVehicle;
        }
        // try drivers license
        statement = (PreparedStatement) conn.prepareStatement("select * from vehicles where year = ? and make = ? and model = ?;");
        statement.setString(1, vm.getYear());
        statement.setString(2, vm.getMake());
        statement.setString(3, vm.getModel());
        resultSet = statement.executeQuery();
        if(resultSet.next())
        {
          //customerID,phoneNumber,firstName,lastName,emailAddress,streetAddress,city,state,zipCode
          foundVehicle.setVehicleIDNumber(resultSet.getString(1));
          foundVehicle.setYear(resultSet.getString(2));
          foundVehicle.setMake(resultSet.getString(3));
          foundVehicle.setModel(resultSet.getString(4));
          foundVehicle.setColor(resultSet.getString(5));
          foundVehicle.setMileage(resultSet.getInt(6));
          conn.close();
          return foundVehicle;
        }
        conn.close();
    }
    catch(Exception e){System.out.println(e.toString());}
    return foundVehicle; // Convert this to a static variable
  }
}

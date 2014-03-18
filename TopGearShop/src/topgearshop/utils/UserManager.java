/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package topgearshop.utils;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author klkita
 */
public class UserManager {
    private Connection c;
    private Statement st;
    private User user;
    
    public UserManager() throws ClassNotFoundException, SQLException{
        c = ConnectionManager.getConnection();
        st = c.createStatement();
    }
    
    public User getUser(){
        return user;
    }
}

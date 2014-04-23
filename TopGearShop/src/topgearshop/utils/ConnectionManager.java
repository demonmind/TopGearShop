/*
 * Author: TopGear Group
 *
 * ConnectionManager is single configuration point to where the system database
 * resides and the method by which all static methods in the DataAccessLayer
 * obtain their connections to the database.
 *
 */
package topgearshop.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager
{
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
	    String connURL = "jdbc:sqlite:data/main";
	    Class.forName("org.sqlite.JDBC");
	    Connection con = DriverManager.getConnection(connURL);
	    return con;
	}
}
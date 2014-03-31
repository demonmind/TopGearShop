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
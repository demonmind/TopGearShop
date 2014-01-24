package topgearshop;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager
{
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
	    String connURL = "jdbc:sqlite:/Users/klkita/Documents/workspace/TopGearShop/data/database.db";
	    Class.forName("org.sqlite.JDBC");
	    Connection con = DriverManager.getConnection(connURL);
	    return con;
	}
}
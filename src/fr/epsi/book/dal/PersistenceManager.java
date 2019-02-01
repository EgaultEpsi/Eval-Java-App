package fr.epsi.book.dal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.*;

public class PersistenceManager {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/evaljava3?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String DB_LOGIN = "root";
	private static final String DB_PWD = "";
	
	private static Connection connection;
	
	private PersistenceManager() {}
	
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName ("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Erreur au niveau du driver");
			e.printStackTrace();
		}
		
		connection = null;
		
		try {
			connection = DriverManager.getConnection(DB_URL, DB_LOGIN, DB_PWD);
		} catch (Exception e) {
			System.err.println("erreur au niveau de la connection a la BDD");
			e.printStackTrace();
		}
        
		return connection;
	}
	
	public static void closeConnection() throws SQLException {
		if ( null != connection && !connection.isClosed() ) {
			connection.close();
		}
	}
}

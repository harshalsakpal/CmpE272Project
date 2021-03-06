package edu.sjsu.cmpe272.databaseapi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Connection Factory for database connections
 * 
 * @author PallaviMokashi
 *
 */
public class ConnectionFactory {
	private String driverClassName = "org.postgresql.Driver";
	private String connectionUrl = "jdbc:postgresql://localhost:5555/CarDatabase";
	private String dbUser = "postgres";
	private String dbPwd = "postgres";
	
	 private static ConnectionFactory connectionFactory = null;

     public ConnectionFactory() {
             try {
                     Class.forName(driverClassName);
             } catch (ClassNotFoundException e) {
                     e.printStackTrace();
             }
     }

     public Connection getConnection() throws SQLException {
             Connection conn = null;
             conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
             return conn;
     }

     public static ConnectionFactory getInstance() {
             if (connectionFactory == null) {
                     connectionFactory = new ConnectionFactory();
             }
             return connectionFactory;
     }

}

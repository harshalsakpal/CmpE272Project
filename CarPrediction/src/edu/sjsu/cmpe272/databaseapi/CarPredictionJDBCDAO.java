package edu.sjsu.cmpe272.databaseapi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Test Client for database
 * TODO : Need to change this class according to database schema
 * @author PallaviMokashi
 *
 */

public class CarPredictionJDBCDAO {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;

	public CarPredictionJDBCDAO() {

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}


	public boolean authenticateUser() {
		try 
		{
			String queryString = "SELECT \"UserID\", \"UserName\", \"Password\"FROM \"User\"";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();


			while (resultSet.next()) 
			{
				System.out.println("UserId: " + resultSet.getString(1) );
				System.out.println("UserName: " + resultSet.getString(2) );
				System.out.println("Password: " + resultSet.getString(3) );
				return true;

			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		} finally 
		{
			try {
				if (resultSet != null)
					resultSet.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			} catch (Exception e) 
			{
				e.printStackTrace();
			}

		}
		return false;

	}


	public static void main(String[] args) {
		CarPredictionJDBCDAO carDatabase = new CarPredictionJDBCDAO();

		boolean loginSucess = carDatabase.authenticateUser();
		if(loginSucess == true)
		{
			System.out.println("Ok Success");
		}
	}
}
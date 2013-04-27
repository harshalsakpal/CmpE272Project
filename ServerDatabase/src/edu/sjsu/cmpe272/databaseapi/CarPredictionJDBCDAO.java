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


	
	
	public void getWeightage() {
		try 
		{
			String queryString = "Select ur.\"QuestionID\", ur.\"AnswerID\", " +
					"q.\"QuestionWeight\", a.\"AnswerWeight\" " +
					"from \"AnswerResponse\" ur,  \"Questions\" q, \"Answers\" a " +
					"where ur.\"QuestionID\" = q.\"QuestionID\" " +
					"and ur.\"AnswerID\"  = a.\"AnswerID\" " +
					"and a.\"QuestionID\" = q.\"QuestionID\"";
			
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();


			while (resultSet.next()) 
			{
				System.out.println("QuestionID: " + resultSet.getString(1) );
				System.out.println("AnswerID: " + resultSet.getString(2) );
				System.out.println("QuestionWeight: " + resultSet.getString(3) );
				System.out.println("AnswerWeight: " + resultSet.getString(4) );

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

	}
	
	

	public static void main(String[] args) {
		CarPredictionJDBCDAO carDatabase = new CarPredictionJDBCDAO();

		carDatabase.getWeightage();
		
	}
}
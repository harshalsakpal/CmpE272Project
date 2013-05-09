package edu.sjsu.cmpe272.databaseapi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.sjsu.cmpe272.beans.AnswerBean;
import edu.sjsu.cmpe272.beans.QuestionsBean;
import edu.sjsu.cmpe272.beans.ResponseBean;

/**
 * Test Client for database TODO : Need to change this class according to
 * database schema
 * 
 * @author PallaviMokashi
 * 
 */

public class CarPredictionJDBCDAO {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;

	public static CarPredictionJDBCDAO carPredictionJDBCDAO = null;

	private CarPredictionJDBCDAO() {

	}

	public static CarPredictionJDBCDAO getInstance() {
		if (carPredictionJDBCDAO == null) {
			carPredictionJDBCDAO = new CarPredictionJDBCDAO();
		}
		return carPredictionJDBCDAO;
	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	public List<AnswerBean> getAllAnswers() {
		List<AnswerBean> listAnswerBean = new ArrayList<AnswerBean>();

		try {
			String queryString = "SELECT \"AnswerID\", \"QuestionID\", \"AnswerDesc\", "
					+ "\"AnswerWeight\", \"AnswerAnalysis\" FROM \"Answers\" ";

			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			int iCount = 0;

			while (resultSet.next()) {
				AnswerBean answerBean = new AnswerBean();
				/*
				 * System.out.println("AnswerID: " + resultSet.getString(1));
				 * System.out.println("QuestionID: " + resultSet.getString(2));
				 * System.out.println("AnswerDesc: " + resultSet.getString(3));
				 * System.out.println("AnswerWeight: " +
				 * resultSet.getString(4));
				 */

				answerBean.setAnswerId(resultSet.getString(1));
				answerBean.setQuestionId(resultSet.getString(2));
				answerBean.setAnswerDescrition(resultSet.getString(3));
				answerBean.setAnswerWeight(resultSet.getString(4));
				answerBean.setAnswerAnalysis(resultSet.getString(5));

				listAnswerBean.add(iCount, answerBean);
				iCount++;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return listAnswerBean;
	}

	public List<QuestionsBean> getAllQuestions() {

		List<QuestionsBean> listQuestionsBean = new ArrayList<QuestionsBean>();

		try {
			String queryString = "SELECT \"QuestionID\", \"QuestionDesc\", \"QuestionWeight\"  "
					+ "FROM \"Questions\" ";

			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			int iCount = 0;

			while (resultSet.next()) {
				QuestionsBean questionsBean = new QuestionsBean();
				/*
				 * System.out.println("QuestionID: " + resultSet.getString(1));
				 * System.out.println("QuestionDesc: " +
				 * resultSet.getString(2));
				 * System.out.println("QuestionWeight: " +
				 * resultSet.getString(3));
				 */

				questionsBean.setQuestionId(resultSet.getString(1));
				questionsBean.setQuestionDescription(resultSet.getString(2));
				questionsBean.setQuestionWeight(resultSet.getString(3));

				listQuestionsBean.add(iCount, questionsBean);
				iCount++;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return listQuestionsBean;
	}

	public boolean insertEmailId(String userid) {
		try {

			System.out.println("userid in insertEmailId ::  " + userid);
			String queryString = "SELECT \"UserID\" FROM \"UserResponse\" where \"UserID\" = ?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, userid);
			resultSet = ptmt.executeQuery();

			if (!resultSet.next()) {
				queryString = "INSERT INTO \"User\"(\"UserID\") VALUES (?)";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				ptmt.setString(1, userid);
				ptmt.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return true;

	}

	public void getWeightage() {

		ResponseBean responseBean = new ResponseBean();

		try {
			String queryString = "Select ur.\"UserID\", ur.\"QuestionID\","
					+ " ur.\"AnswerID\", q.\"QuestionWeight\" , a.\"AnswerWeight\""
					+ "from \"UserResponse\" ur,  \"Questions\" q, \"Answers\" a, \"User\" u "
					+ "where ur.\"UserID\" = u.\"UserID\""
					+ "and ur.\"QuestionID\" = q.\"QuestionID\""
					+ "and ur.\"AnswerID\"  = a.\"AnswerID\""
					+ "and a.\"QuestionID\" = q.\"QuestionID\""
					+ "and ur.\"UserID\" = 'a@272.com'";

			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();

			while (resultSet.next()) {
				/*
				 * System.out.println("UserID: " + resultSet.getString(1));
				 * System.out.println("QuestionID: " + resultSet.getString(2));
				 * System.out.println("AnswerID: " + resultSet.getString(3));
				 * System.out.println("QuestionWeight: " +
				 * resultSet.getString(4)); System.out.println("AnswerWeight: "
				 * + resultSet.getString(5));
				 */

				responseBean.setUserID(resultSet.getString(1));
				responseBean.setQuestionID(resultSet.getString(2));
				responseBean.setAnswerID(resultSet.getString(3));
				responseBean.setQuestionWeight(resultSet.getString(4));
				responseBean.setAnswerWeight(resultSet.getString(5));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void updateUserResponse(String userid, String answer1,
			String answer2, String answer3, String answer4, String answer5) {
		try {
			System.out.println("userid in updateUserResponse ::  " + userid);
			String queryString = "SELECT \"UserID\" FROM \"UserResponse\" where \"UserID\" = ?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, userid);
			System.out.println("");
			resultSet = ptmt.executeQuery();

			if (resultSet.next()) {
				queryString = "UPDATE \"UserResponse\" "
						+ "SET  \"AnswerID\"= ? WHERE \"UserID\"= ? and  \"QuestionID\"=1";
				ptmt = connection.prepareStatement(queryString);

				ptmt.setInt(1, Integer.parseInt(answer1));
				ptmt.setString(2, userid);

				ptmt.executeUpdate();

				queryString = "UPDATE \"UserResponse\" "
						+ "SET   \"AnswerID\"= ? WHERE \"UserID\"=? and  \"QuestionID\"=2";

				ptmt = connection.prepareStatement(queryString);

				ptmt.setInt(1, Integer.parseInt(answer2));
				ptmt.setString(2, userid);

				ptmt.executeUpdate();

				queryString = "UPDATE \"UserResponse\" "
						+ "SET   \"AnswerID\"= ? WHERE \"UserID\"=? and  \"QuestionID\"=3";
				ptmt = connection.prepareStatement(queryString);

				ptmt.setInt(1, Integer.parseInt(answer3));
				ptmt.setString(2, userid);

				ptmt.executeUpdate();

				queryString = "UPDATE \"UserResponse\" "
						+ "SET  \"QuestionID\"=4, \"AnswerID\"= ? WHERE \"UserID\"= ? and  \"QuestionID\"=4";
				ptmt = connection.prepareStatement(queryString);

				ptmt.setInt(1, Integer.parseInt(answer4));
				ptmt.setString(2, userid);

				ptmt.executeUpdate();

				queryString = "UPDATE \"UserResponse\" "
						+ "SET \"AnswerID\"= ? WHERE \"UserID\"= ? and  \"QuestionID\"=5";
				ptmt = connection.prepareStatement(queryString);

				ptmt.setInt(1, Integer.parseInt(answer5));
				ptmt.setString(2, userid);

				ptmt.executeUpdate();

			} else {
				queryString = "INSERT INTO \"UserResponse\"(\"UserID\", \"QuestionID\", \"AnswerID\") VALUES (?, 1, ?)";
				ptmt = connection.prepareStatement(queryString);

				ptmt.setString(1, userid);
				ptmt.setInt(2, Integer.parseInt(answer1));

				ptmt.executeUpdate();

				queryString = "INSERT INTO \"UserResponse\"(\"UserID\", \"QuestionID\", \"AnswerID\") VALUES (?, 2, ?)";
				ptmt = connection.prepareStatement(queryString);

				ptmt.setString(1, userid);
				ptmt.setInt(2, Integer.parseInt(answer2));

				ptmt.executeUpdate();

				queryString = "INSERT INTO \"UserResponse\"(\"UserID\", \"QuestionID\", \"AnswerID\") VALUES (?, 3, ?)";
				ptmt = connection.prepareStatement(queryString);

				ptmt.setString(1, userid);
				ptmt.setInt(2, Integer.parseInt(answer3));

				ptmt.executeUpdate();

				queryString = "INSERT INTO \"UserResponse\"(\"UserID\", \"QuestionID\", \"AnswerID\") VALUES (?, 4, ?)";
				ptmt = connection.prepareStatement(queryString);

				ptmt.setString(1, userid);
				ptmt.setInt(2, Integer.parseInt(answer4));

				ptmt.executeUpdate();

				queryString = "INSERT INTO \"UserResponse\"(\"UserID\", \"QuestionID\", \"AnswerID\") VALUES (?, 5, ?)";
				ptmt = connection.prepareStatement(queryString);

				ptmt.setString(1, userid);
				ptmt.setInt(2, Integer.parseInt(answer5));

				ptmt.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {
		CarPredictionJDBCDAO carDatabase = new CarPredictionJDBCDAO();
		// carDatabase.getWeightage();
		// carDa.tabase.insertEmailId("f@272.com");
		carDatabase.getAllQuestions();
	}
}
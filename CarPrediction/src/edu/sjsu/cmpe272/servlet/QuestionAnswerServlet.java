package edu.sjsu.cmpe272.servlet;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.sjsu.cmpe272.beans.AnswerBean;
import edu.sjsu.cmpe272.beans.QuestionsBean;
import edu.sjsu.cmpe272.databaseapi.CarPredictionJDBCDAO;
import edu.sjsu.cmpe272.util.CarPredictionUtil;

/**
 * Servlet implementation class QuestionAnswerServlet
 */
public class QuestionAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QuestionAnswerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		System.out.println("email id in doPost is    "
				+ session.getAttribute("userid"));
		String selectedAnswers = "", answer1 = "", answer2 = "", answer3 = "", answer4 = "", answer5 = "";
		if (request.getParameter("selectedAnswers") != null) {
			System.out.println("Value of selected answers are is::  "
					+ request.getParameter("selectedAnswers"));
			selectedAnswers = request.getParameter("selectedAnswers");
		}
		System.out
				.println("Value of Selected Answers is::  " + selectedAnswers);
		session.setAttribute("selectedAnswers", selectedAnswers);

		answer1 = selectedAnswers.substring(0, selectedAnswers.indexOf(","));

		selectedAnswers = selectedAnswers.substring(answer1.length() + 1);
		answer2 = selectedAnswers.substring(0, selectedAnswers.indexOf(","));

		selectedAnswers = selectedAnswers.substring((answer2.length()) + 1);
		answer3 = selectedAnswers.substring(0, selectedAnswers.indexOf(","));

		selectedAnswers = selectedAnswers.substring((answer3.length()) + 1);
		answer4 = selectedAnswers.substring(0, selectedAnswers.indexOf(","));

		selectedAnswers = selectedAnswers.substring((answer4.length()) + 1);
		answer5 = selectedAnswers.substring(0, selectedAnswers.length());

		// TODO Code to insert user's response to the database.
		CarPredictionJDBCDAO.getInstance().updateUserResponse(
				(String) session.getAttribute("userid"), answer1, answer2,
				answer3, answer4, answer5);

		// TODO Code to calculate the user result.
		List<QuestionsBean> questionList = (List<QuestionsBean>) session
				.getAttribute("questionList");

		List<AnswerBean> answerList = (List<AnswerBean>) session
				.getAttribute("answerList");
		
		Collections.sort(answerList);
		
		double answer1weight = Double.parseDouble(answerList.get(Integer.parseInt(answer1)-1).getAnswerWeight());
		double answer2weight = Double.parseDouble(answerList.get(Integer.parseInt(answer2)-1).getAnswerWeight());
		double answer3weight = Double.parseDouble(answerList.get(Integer.parseInt(answer3)-1).getAnswerWeight());
		double answer4weight = Double.parseDouble(answerList.get(Integer.parseInt(answer4)-1).getAnswerWeight());
		double answer5weight = Double.parseDouble(answerList.get(Integer.parseInt(answer5)-1).getAnswerWeight());
		
		session.setAttribute("answer1weight", answer1weight*100);
		session.setAttribute("answer2weight", answer2weight*100);
		session.setAttribute("answer3weight", answer3weight*100);
		session.setAttribute("answer4weight", answer4weight*100);
		session.setAttribute("answer5weight", answer5weight*100);
		
		// To get the list of Answers.
		String result = CarPredictionUtil.getResult(answer1, answer2, answer3,
				answer4, answer5, questionList, answerList);
		System.out.println("result is :: " + result);
		session.setAttribute("result", result);
		request.getRequestDispatcher("/view/result.jsp").forward(request,
				response);
	}
}

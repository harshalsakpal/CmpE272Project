package edu.sjsu.cmpe272.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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
 * Servlet implementation class IntroServlet
 */
public class IntroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public IntroServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String emailid = "";
		HttpSession session = request.getSession();
		
		if(!"".equals(request.getParameter("emailid")) || request.getParameter("emailid")!=null){
			emailid = request.getParameter("emailid");
		}
		System.out.println("email id in doPost is    "+emailid);
		
		// To insert email id in the database.
		boolean isSuccess = CarPredictionJDBCDAO.getInstance().insertEmailId(emailid);

		session.setAttribute("userid", emailid);
		
		// To get the list of questions.
		List<QuestionsBean> questionList = CarPredictionJDBCDAO.getInstance().getAllQuestions();
		session.setAttribute("questionList", questionList);
		
		// To get the list of Answers.
		List<AnswerBean> answerList = CarPredictionJDBCDAO.getInstance().getAllAnswers();
		session.setAttribute("answerList", answerList);
		
		Map<Integer, List<AnswerBean>> mapOfQandA = CarPredictionUtil.seperateQandA(questionList, answerList);
		request.setAttribute("mapOfQandA", mapOfQandA);
		
		request.getRequestDispatcher("view/questions.jsp").forward(request, response);
		
	}
	
}

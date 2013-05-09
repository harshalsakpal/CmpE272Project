package edu.sjsu.cmpe272.beans;

public class ResponseBean {

	private String UserID;
	private String QuestionID;
	private String AnswerID;
	private String QuestionWeight;
	private String AnswerWeight;

	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	public String getQuestionID() {
		return QuestionID;
	}

	public void setQuestionID(String questionID) {
		QuestionID = questionID;
	}

	public String getAnswerID() {
		return AnswerID;
	}

	public void setAnswerID(String answerID) {
		AnswerID = answerID;
	}

	public String getQuestionWeight() {
		return QuestionWeight;
	}

	public void setQuestionWeight(String questionWeight) {
		QuestionWeight = questionWeight;
	}

	public String getAnswerWeight() {
		return AnswerWeight;
	}

	public void setAnswerWeight(String answerWeight) {
		AnswerWeight = answerWeight;
	}

}

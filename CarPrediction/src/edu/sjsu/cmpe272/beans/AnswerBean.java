package edu.sjsu.cmpe272.beans;

public class AnswerBean implements Comparable<AnswerBean> {
	private String answerId;
	private String questionId;
	private String answerDescrition;
	private String answerWeight;
	private String answerAnalysis;

	public String getAnswerAnalysis() {
		return answerAnalysis;
	}

	public void setAnswerAnalysis(String answerAnalysis) {
		this.answerAnalysis = answerAnalysis;
	}

	public String getAnswerId() {
		return answerId;
	}

	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getAnswerDescrition() {
		return answerDescrition;
	}

	public void setAnswerDescrition(String answerDescrition) {
		this.answerDescrition = answerDescrition;
	}

	public String getAnswerWeight() {
		return answerWeight;
	}

	public void setAnswerWeight(String answerWeight) {
		this.answerWeight = answerWeight;
	}

	public int compareTo(AnswerBean answerBean) {
		if (Integer.parseInt(this.answerId) < Integer
				.parseInt(answerBean.answerId)) {
			return -1;
		}
		return 1;
	}

}

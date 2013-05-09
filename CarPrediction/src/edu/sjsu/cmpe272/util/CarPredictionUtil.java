/**
 * 
 */
package edu.sjsu.cmpe272.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.sjsu.cmpe272.beans.AnswerBean;
import edu.sjsu.cmpe272.beans.QuestionsBean;

/**
 * This class is defined for validation of input from front end as well as for
 * the prediction algorithm to decide the type of car for the user.
 * 
 */
public class CarPredictionUtil {

	public static Map<Integer, List<AnswerBean>> seperateQandA(
			List<QuestionsBean> questionsBeans, List<AnswerBean> answerBeans) {

		List<AnswerBean> tempAnswerBean = null;
		Map<Integer, List<AnswerBean>> mapOfQandA = new HashMap<Integer, List<AnswerBean>>();

		for (AnswerBean itr : answerBeans) {
			if (mapOfQandA.containsKey(Integer.parseInt(itr.getQuestionId()))) {
				tempAnswerBean = mapOfQandA.get(Integer.parseInt(itr
						.getQuestionId()));
				tempAnswerBean.add(itr);
			} else {
				tempAnswerBean = new ArrayList<AnswerBean>();
				tempAnswerBean.add(itr);
				mapOfQandA.put(Integer.parseInt(itr.getQuestionId()),
						tempAnswerBean);
			}
		}

		// Printing Question and Answer Map starts.
		for (int key : mapOfQandA.keySet()) {
			System.out.println("The question id is ==> " + key);
			for (AnswerBean answers : mapOfQandA.get(key)) {
				System.out.println("Answers ==> "
						+ answers.getAnswerDescrition()
						+ " Answer Weightage ==> " + answers.getAnswerWeight());
			}
		}
		return mapOfQandA;
	}

	public static String getResult(String answer1, String answer2,
			String answer3, String answer4, String answer5,
			List<QuestionsBean> questionList, List<AnswerBean> answerList) {
		/*
		 * (Question1Weight * Answer1Weight) + (Question2Weight * Answer2Weight)
		 * + (Question3Weight * Answer3Weight) + (Question4Weight *
		 * Answer4Weight) + (Question5Weight * Answer5Weight) *100
		 */
		
		System.out.println("All Question Weights");
		System.out.println(questionList.get(0).getQuestionWeight());
		System.out.println(questionList.get(1).getQuestionWeight());
		System.out.println(questionList.get(2).getQuestionWeight());
		System.out.println(questionList.get(3).getQuestionWeight());
		System.out.println(questionList.get(4).getQuestionWeight());
		System.out.println("All Question Weights");

		System.out.println("All Answer Weights");
		System.out.println(answerList.get(Integer.parseInt(answer1)-1)
				.getAnswerWeight());
		System.out.println(answerList.get(Integer.parseInt(answer2)-1)
				.getAnswerWeight());
		System.out.println(answerList.get(Integer.parseInt(answer3)-1)
				.getAnswerWeight());
		System.out.println(answerList.get(Integer.parseInt(answer4)-1)
				.getAnswerWeight());
		System.out.println(answerList.get(Integer.parseInt(answer5)-1)
				.getAnswerWeight());
		System.out.println("All Answer Weights");

		Double totalWeightCalcutolated = (Double.parseDouble((questionList
				.get(0).getQuestionWeight()))
				* Double.parseDouble(answerList.get(Integer.parseInt(answer1)-1)
						.getAnswerWeight())

				+ Double.parseDouble((questionList.get(1).getQuestionWeight()))
				* Double.parseDouble(answerList.get(Integer.parseInt(answer2)-1)
						.getAnswerWeight())
				+

				Double.parseDouble((questionList.get(2).getQuestionWeight()))
				* Double.parseDouble(answerList.get(Integer.parseInt(answer3)-1)
						.getAnswerWeight())
				+

				Double.parseDouble((questionList.get(3).getQuestionWeight()))
				* Double.parseDouble(answerList.get(Integer.parseInt(answer4)-1)
						.getAnswerWeight())

		+

		Double.parseDouble((questionList.get(4).getQuestionWeight()))
				* Double.parseDouble(answerList.get(Integer.parseInt(answer5)-1)
						.getAnswerWeight()));

		System.out.println(Double.valueOf(totalWeightCalcutolated));

		return totalWeightCalcutolated.toString();
	}
}

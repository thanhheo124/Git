/**
 * @Copyright Group 2 - OOP - KS2.K37
 */
package com.bkhn.controller;

import java.util.ArrayList;

import com.bkhn.gui.GuiEditQuestion;
import com.bkhn.model.ChoiceQuestion;
import com.bkhn.model.QuizQuestion;

/**
 * @author Mr Thanh Nov 12, 2017
 *
 */
public class ControllerQuestion {
	private ArrayList<QuizQuestion> listQuizQuestion;
	private ArrayList<ChoiceQuestion> listChoiceQuestion;

	private GuiEditQuestion guiEditQuestion;

	/**
	 * Contructor default
	 */
	public ControllerQuestion() {
		listQuizQuestion = new ArrayList<>();
		listChoiceQuestion = new ArrayList<>();
		// Add Question : (Manh will delele them after you solve invole
		// database.
		// Begin delete
		QuizQuestion quizQuestion1 = new QuizQuestion(1, "Is thanh a handsome man?", "OK", 1, 1,
				"not only handsome but also intelligent");
		QuizQuestion quizQuestion2 = new QuizQuestion(2, "Toi dang code bai OOP co phai khong?", "OK", 2, 3,
				"Dung roi ban oi");
		QuizQuestion quizQuestion3 = new QuizQuestion(3, "Ha noi dem nay day sao, tai sao em con ngoi do?", "OK", 1, 1,
				"Vi ngoi do ngam sao ma a?");

		listQuizQuestion.add(quizQuestion1);
		listQuizQuestion.add(quizQuestion2);
		listQuizQuestion.add(quizQuestion3);

		ArrayList<String> listChoice1 = new ArrayList<>();
		listChoice1.add("1");
		listChoice1.add("2");
		listChoice1.add("3");
		listChoice1.add("4");

		ArrayList<String> listAnswers1 = new ArrayList<>();
		listAnswers1.add("1");
		listAnswers1.add("2");

		ArrayList<String> listChoice2 = new ArrayList<>();
		listChoice2.add("Ừm");
		listChoice2.add("Không phải");
		listChoice2.add("Gần đúng");

		ArrayList<String> listAnswer2 = new ArrayList<>();
		listAnswer2.add("Ừm");
		listAnswer2.add("Gần đúng");

		ChoiceQuestion choiceQuestion1 = new ChoiceQuestion(1, "1 +1 = ?", "Toán", 2, 2, listChoice1, listAnswers1);
		ChoiceQuestion choiceQuestion2 = new ChoiceQuestion(2, "thành đẹp trai có phải không?", "Đẹp trai học", 1, 3,
				listChoice2, listAnswer2);
		// End delete
		listChoiceQuestion.add(choiceQuestion1);
		listChoiceQuestion.add(choiceQuestion2);

		guiEditQuestion = new GuiEditQuestion();
		guiEditQuestion.setListChoiceQuestion(listChoiceQuestion);
		guiEditQuestion.setListQuizQuestion(listQuizQuestion);
		guiEditQuestion.setVisible(true);
		// Load data ListQuizQuestion.
		// If start, we need provide two list Question
	}

}

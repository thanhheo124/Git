/**
 * @Copyright Gruop2 . OOP - KS2 k37
 * 
 */
package com.bkhn.interfacecommon;

import com.bkhn.model.ChoiceQuestion;
import com.bkhn.model.QuizQuestion;
	/**
	 * 
	 * @author Mr Thanh
	 *
	 */
public interface IManagerQuestion {
	/**
	 * to insert choice Question
	 * @param choiceQuestion : choiceQuestion to insert to ArrayList
	 */
	public boolean insertChoiceQuestion(ChoiceQuestion choiceQuestion);
	
	/**
	 * to insert quiz Question
	 * @param quizQuestion : to insert to ArrayList
	 */
	
	public boolean insertQuizQuestion(QuizQuestion quizQuestion);
	
	/**
	 * to change information choiceQuestion in ArrayList
	 * @param : choiceQuestion : to update
	 */
	public boolean upDateChoiceQuestion(ChoiceQuestion choiceQuestion);
	
	/**
	 * to change information quizQuestion in ArrayList
	 * @param quizQuestion : to update
	 */
	public boolean upDateQuizQuestion(QuizQuestion quizQuestion);
	
	/**
	 * to delete Question in ArrayList after choose Remove
	 * @param choiceQuestion : object to remove
	 */
	public boolean deleteChoiceQuestion(ChoiceQuestion choiceQuestion);
	
	/**
	 * to delete QuizQuestion in ArrayList after choose Remove
	 * @param quizQuestion : Object to remove
	 */
	public boolean deleteQuizQuestion(QuizQuestion quizQuestion);
}

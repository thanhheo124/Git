package com.bkhn.model;

import java.util.ArrayList;

public class Exam {
	ArrayList<ChoiceQuestion> choiceQuestions;
	ArrayList<QuizQuestion> quizQuestions;
	
	public Exam(){
		choiceQuestions = new ArrayList<ChoiceQuestion>();
		quizQuestions = new ArrayList<QuizQuestion>();
	}
	
}

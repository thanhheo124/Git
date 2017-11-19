package com.bkhn.model;

import java.util.ArrayList;

public class Exam {
	private ArrayList<ChoiceQuestion> choiceQuestions;
	private ArrayList<QuizQuestion> quizQuestions;
	private String subjectName;
	private String subjectId;
	private String name;
	private float time;
	
	public Exam(){
		choiceQuestions = new ArrayList<ChoiceQuestion>();
		quizQuestions = new ArrayList<QuizQuestion>();
		subjectName = "noSubjectName";
		subjectId = "noIdName";
		name = "noName";
		time = 0;
	}
		
	public Exam(String subjectName, String subjectId, float time) {
		super();
		this.subjectName = subjectName;
		this.subjectId = subjectId;
		this.time = time;
	}

	public ArrayList<ChoiceQuestion> getChoiceQuestions() {
		return choiceQuestions;
	}

	public void setChoiceQuestions(ArrayList<ChoiceQuestion> choiceQuestions) {
		this.choiceQuestions = choiceQuestions;
	}

	public ArrayList<QuizQuestion> getQuizQuestions() {
		return quizQuestions;
	}

	public void setQuizQuestions(ArrayList<QuizQuestion> quizQuestions) {
		this.quizQuestions = quizQuestions;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public float getTime() {
		return time;
	}

	public void setTime(float time) {
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String ExamToQuestionString() {
		String content = "";
		int numQuest = 0;
		for(int i=0; i< choiceQuestions.size(); i++) {
			content += "Question: " + numQuest +"\n"+ choiceQuestions.get(i).ToQuestionString();
			numQuest ++;
		}
		for(int i=0; i< quizQuestions.size(); i++) {
			content += "Question: " + numQuest +"\n"+ quizQuestions.get(i).ToQuestionString();
			numQuest ++;
		}
		return content;
	}
	
	public String ExamToAnswerString() {
		String content = "";
		int numQuest = 0;
		for(int i=0; i< choiceQuestions.size(); i++) {
			content += "Question: " + numQuest +"\n"+ choiceQuestions.get(i).ToQuestionString();
			content += "Answer: " + "\n" + choiceQuestions.get(i).ToAnswerString();
			numQuest ++;
		}
		for(int i=0; i< quizQuestions.size(); i++) {
			content += "Question: " + numQuest +"\n"+ quizQuestions.get(i).ToQuestionString();
			content += "Answer: " + "\n" + quizQuestions.get(i).ToAnswerString();
			numQuest ++;
		}
		return content;
	}
}

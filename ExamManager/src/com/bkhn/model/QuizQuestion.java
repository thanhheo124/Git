package com.bkhn.model;

public class QuizQuestion extends Question{
	private String suggestion;

	public QuizQuestion() {
		super();
	}
	
	public QuizQuestion(int id, String content, String subject, int chapter, int level, String suggestion) {
		super(id, content,subject,chapter, level);
		this.suggestion = suggestion;
	}

	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	
	@Override
	public String QuestionToString() {
		// TODO Auto-generated method stub
		return "QuizQuestion:\t" + id + "\t" + content + "\t" + subject +"\t" + chapter + "\t" + level + "\t" + suggestion;
	}
	
}

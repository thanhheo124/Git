package com.bkhn.model;

import org.json.simple.JSONObject;

public class QuizQuestion extends Question{
	private String suggestion;

	public QuizQuestion() {
	}
	
	public QuizQuestion(String content, int chapter, int level, String suggestion) {
		super(content,chapter, level);
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
		return "QuizQuestion:\t"+"\t" + chapter + "\t" + level + "\t" + suggestion;
	}
	
	@Override
	public String ToQuestionString() {
		return content + "\n";
	}

	@Override
	public String ToAnswerString() {
		return suggestion + "\n";
	}

	@Override
	public String ToJsonString() {
		JSONObject jsonObject = ToJsonObject();
		jsonObject.put("suggestion", suggestion);
		return jsonObject.toString();
	}
}

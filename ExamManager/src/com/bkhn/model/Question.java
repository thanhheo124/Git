package com.bkhn.model;

import org.json.simple.JSONObject;

public abstract class Question {
	protected String content;
	protected int chapter;
	protected int level;
	protected double mark;
	protected boolean isChoiceQ;

	public Question() {
		this.mark = 0;
	}

	public Question(String content, int chapter, int level) {
		this.content = content;
		this.chapter = chapter;
		this.level = level;
		this.mark = 0;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getChapter() {
		return chapter;
	}

	public void setChapter(int chapter) {
		this.chapter = chapter;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public double getMark() {
		return mark;
	}

	public void setMark(double mark) {
		if (mark < 0)
			mark = 0;
		if (mark > 10)
			mark = 10;
		this.mark = mark;
	}
	
	public boolean isChoiceQ() {
		return isChoiceQ;
	}

	public abstract String QuestionToString();

	public abstract String ToQuestionString();

	public abstract String ToAnswerString();

	public abstract String ToJsonString();

	public JSONObject ToJsonObject() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("content", content);
		jsonObject.put("chapter", new Integer(chapter));
		jsonObject.put("level", new Integer(level));
		jsonObject.put("mark", new Double(mark));
		jsonObject.put("isChoiceQ", new Boolean(isChoiceQ));
		return jsonObject;
	}

}

package com.bkhn.model;

public abstract class Question {
	protected int		id;
	protected String 	content;
	protected String 	subject;
	protected int		chapter;
	protected int		level;
	
	public Question() {
		
	}
	
	public Question(int id, String content, String subject, int chapter, int level) {
		this.id = id;
		this.content = content;
		this.subject = subject;
		this.chapter = chapter;
		this.level = level;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
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
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public abstract String QuestionToString();
	public abstract String ToQuestionString();
	public abstract String ToAnswerString();
	public abstract String ToJsonString();
}

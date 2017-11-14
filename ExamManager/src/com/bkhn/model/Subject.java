package com.bkhn.model;

import java.io.IOException;
import java.io.StringWriter;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Subject {
	private String name;
	private String id;
	private int numChapter;
	private String introduction;

	public Subject() {

	}
	
	public Subject(String name, String id, int numChapter, String introduction) {
		super();
		this.name = name;
		this.id = id;
		this.numChapter = numChapter;
		this.introduction = introduction;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNumChapter() {
		return numChapter;
	}

	public void setNumChapter(int numChapter) {
		this.numChapter = numChapter;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String SujectToString() {
		String str = "";
		str += "subject:\t" + this.id + "\t" + this.name + "\t" + introduction;
		return str;
	}

	public String ToJsonString() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", name);
		jsonObject.put("id", id);
		jsonObject.put("numChapter", new Integer(numChapter));
		jsonObject.put("introduction", introduction);
		return jsonObject.toString();
	}
}

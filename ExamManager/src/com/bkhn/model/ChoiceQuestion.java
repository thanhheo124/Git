package com.bkhn.model;

import java.util.ArrayList;

public class ChoiceQuestion extends Question{
	private ArrayList<String> 	choices;
	private ArrayList<String>	answers; 
	
	public ChoiceQuestion(){
	}
	
	public ChoiceQuestion(String content, int chapter, int level, ArrayList<String> choices, ArrayList<String> answers) {
		super(content, chapter, level);
		this.choices = choices;
		this.answers = answers;
	}
	
	public ArrayList<String> getChoices() {
		return choices;
	}

	public void setChoices(ArrayList<String> choices) {
		this.choices = choices;
	}

	public ArrayList<String> getAnswers() {
		return answers;
	}

	public void setAnswers(ArrayList<String> answers) {
		this.answers = answers;
	}

	public void addChoices(String choice) {
		if(this.choices == null)
			this.choices = new ArrayList<String>();
		this.choices.add(choice);
	}
	
	public void addAnswers(String answer) {
		if(this.answers == null)
			this.answers = new ArrayList<String>();
		this.answers.add(answer);
	}
	
	@Override
	public String QuestionToString() {
		// TODO Auto-generated method stub
		String string = "";
		string += "ChoiceQuestion:\t" +"\t" + chapter + "\t" + level;
		string += "\n\t\t\t choice:";
		if(this.choices != null)
			for(int i=0; i< this.choices.size(); i++)
				string+= "\n\t\t\t" + this.choices.get(i);
		string += "\n\t\t\t answer:";
		if(this.answers != null)
			for(int i=0; i< this.answers.size(); i++)
				string+= "\n\t\t\t" + this.answers.get(i);
		return string;
	}
	
	@Override
	public String ToQuestionString(){
		String string = "";
		string += content + "\n";
		if(this.choices != null)
			for(int i=0; i< this.choices.size(); i++)
				string+= ""+ String.valueOf(Character.toChars('A' + i)) + ". " + this.choices.get(i)+ "\n";
		return string;
	}
	
	@Override
	public String ToAnswerString()
	{
		String string = "";
		if(this.answers != null)
			for(int i=0; i< this.answers.size(); i++)
			{
				for(int j=0; j< this.choices.size(); j++){
					if(answers.get(i).equals(choices.get(j))){
						string+= ""+ String.valueOf(Character.toChars('A' + j)) + ". " + this.answers.get(i)+ "\n";
					}
				}
			}
		return string;
	}
	
	@Override
	public String ToJsonString()
	{
		
		return null;
	}
}

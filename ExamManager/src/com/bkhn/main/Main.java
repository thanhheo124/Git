package com.bkhn.main;

import java.util.ArrayList;

import com.bkhn.gui.GuiManager;
import com.bkhn.model.ChoiceQuestion;
import com.bkhn.model.QuizQuestion;
import com.bkhn.model.Subject;
import com.bkhn.model.User;
import com.bkhn.util.DatabaseConnection;

public class Main {
	public static void main(String[] args) {
		GuiManager gui = new GuiManager();
		// demo gui
		DatabaseConnection connection = new DatabaseConnection();
		connection.connectToDataBase();
		// demo database
		Subject subject1 = new Subject("Ky Thuat So", "IT100", 8, "Hoc ky thuat so");
		Subject subject2 = new Subject("Cau Truc DL", "IT101", 9, "Hoc thuat toan");
		Subject subject3 = new Subject("Mang May Tinh", "IT102", 9, "Hoc mang may tinh");
		connection.insertSubject(subject1);
		connection.insertSubject(subject2);
		connection.insertSubject(subject3);
		subject2.setName("Thuat toan");
		connection.updateSubject(subject2);
		connection.deleteSubject(new Subject("", "IT102", 0, ""));
		
		QuizQuestion question1 = new QuizQuestion(0, "Content 0", "IT101", 2, 3, "suggestion0");
		QuizQuestion question2 = new QuizQuestion(1, "Content 1", "IT101", 2, 3, "suggestion1");
		QuizQuestion question3 = new QuizQuestion(2, "Content 2", "IT101", 2, 3, "suggestion2");
		connection.insertQuizQuestion(question1);
		connection.insertQuizQuestion(question2);
		connection.insertQuizQuestion(question3);
		question1.setContent("change 1");
		question1.setChapter(4);
		question1.setLevel(2);
		question1.setSuggestion("change suggestion 1");
		connection.updateQuizQuestion(question1);
		connection.deleteQuizQuestion(question2);
		
		ChoiceQuestion choiceQuestion0 = new ChoiceQuestion(4, "Choise question 0", "IT101", 9, 8, null, null);
		choiceQuestion0.addChoices("hanoi");
		choiceQuestion0.addAnswers("hanoi");
		choiceQuestion0.addChoices("vietnam");
		ChoiceQuestion choiceQuestion1 = new ChoiceQuestion(5, "Choise question 1", "IT101", 8, 0, null, null);
		choiceQuestion1.addChoices("hanoi");
		choiceQuestion1.addAnswers("hanoi");
		choiceQuestion1.addChoices("vietnam");
		connection.insertChoiceQuestion(choiceQuestion0);
		connection.insertChoiceQuestion(choiceQuestion1);
		choiceQuestion1.addChoices("haiphong");
		connection.updateChoiceQuestion(choiceQuestion1);
		
		User user1 = new User("manh", "abc", true);
		User user2 = new User("trang", "123", false);
		connection.insertUser(user1);
		connection.insertUser(user2);
		
		ArrayList<Subject> arrayList = connection.getAllSubject();
		for(int i=0; i< arrayList.size(); i++)
			System.out.println(arrayList.get(i).SujectToString());
		
		ArrayList<QuizQuestion> arrayListQuiz = connection.getAllQuizQuestion("IT101");
		for(int i=0; i< arrayListQuiz.size(); i++)
			System.out.println(arrayListQuiz.get(i).QuestionToString());
		
		ArrayList<ChoiceQuestion> arrayListChoice = connection.getAllChoiceQuestion("IT101");
		for(int i=0; i< arrayListChoice.size(); i++)
			System.out.println(arrayListChoice.get(i).QuestionToString());
		
		User manh =  connection.getUser("manh");
		System.out.println(manh.toString());
		User trang =  connection.getUser("trang");
		System.out.println(trang.toString());
	}
}

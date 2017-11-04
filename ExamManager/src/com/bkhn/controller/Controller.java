package com.bkhn.controller;

import java.util.ArrayList;

import com.bkhn.gui.GuiManager;
import com.bkhn.model.ChoiceQuestion;
import com.bkhn.model.QuizQuestion;
import com.bkhn.model.Subject;
import com.bkhn.model.User;
import com.bkhn.util.DatabaseConnection;
import com.bkhn.util.Printer;

public class Controller {
	static GuiManager m_guiManager;
	static DatabaseConnection m_dataBaseConnection;
	static Printer m_printer;
	
	public static void main(String[] args) {
		m_guiManager = new GuiManager();
		
		m_dataBaseConnection = new DatabaseConnection();
		m_dataBaseConnection.connectToDataBase();
		// demo database
		Subject subject1 = new Subject("Ky Thuat So", "IT100", 8, "Hoc ky thuat so");
		Subject subject2 = new Subject("Cau Truc DL", "IT101", 9, "Hoc thuat toan");
		Subject subject3 = new Subject("Mang May Tinh", "IT102", 9, "Hoc mang may tinh");
		m_dataBaseConnection.insertSubject(subject1);
		m_dataBaseConnection.insertSubject(subject2);
		m_dataBaseConnection.insertSubject(subject3);
		subject2.setName("Thuat toan");
		m_dataBaseConnection.updateSubject(subject2);
		m_dataBaseConnection.deleteSubject(new Subject("", "IT102", 0, ""));
		
		QuizQuestion question1 = new QuizQuestion(0, "Content 0", "IT101", 2, 3, "suggestion0");
		QuizQuestion question2 = new QuizQuestion(1, "Content 1", "IT101", 2, 3, "suggestion1");
		QuizQuestion question3 = new QuizQuestion(2, "Content 2", "IT101", 2, 3, "suggestion2");
		m_dataBaseConnection.insertQuizQuestion(question1);
		m_dataBaseConnection.insertQuizQuestion(question2);
		m_dataBaseConnection.insertQuizQuestion(question3);
		question1.setContent("change 1");
		question1.setChapter(4);
		question1.setLevel(2);
		question1.setSuggestion("change suggestion 1");
		m_dataBaseConnection.updateQuizQuestion(question1);
		m_dataBaseConnection.deleteQuizQuestion(question2);
		
		ChoiceQuestion choiceQuestion0 = new ChoiceQuestion(4, "Choise question 0", "IT101", 9, 8, null, null);
		choiceQuestion0.addChoices("hanoi");
		choiceQuestion0.addAnswers("hanoi");
		choiceQuestion0.addChoices("vietnam");
		ChoiceQuestion choiceQuestion1 = new ChoiceQuestion(5, "Choise question 1", "IT101", 8, 0, null, null);
		choiceQuestion1.addChoices("hanoi");
		choiceQuestion1.addAnswers("hanoi");
		choiceQuestion1.addChoices("vietnam");
		m_dataBaseConnection.insertChoiceQuestion(choiceQuestion0);
		m_dataBaseConnection.insertChoiceQuestion(choiceQuestion1);
		choiceQuestion1.addChoices("haiphong");
		m_dataBaseConnection.updateChoiceQuestion(choiceQuestion1);
		
		User user1 = new User("manh", "abc", true);
		User user2 = new User("trang", "123", false);
		m_dataBaseConnection.insertUser(user1);
		m_dataBaseConnection.insertUser(user2);
		
		ArrayList<Subject> arrayList = m_dataBaseConnection.getAllSubject();
		for(int i=0; i< arrayList.size(); i++)
			System.out.println(arrayList.get(i).SujectToString());
		
		ArrayList<QuizQuestion> arrayListQuiz = m_dataBaseConnection.getAllQuizQuestion("IT101");
		for(int i=0; i< arrayListQuiz.size(); i++)
			System.out.println(arrayListQuiz.get(i).QuestionToString());
		
		ArrayList<ChoiceQuestion> arrayListChoice = m_dataBaseConnection.getAllChoiceQuestion("IT101");
		for(int i=0; i< arrayListChoice.size(); i++)
			System.out.println(arrayListChoice.get(i).QuestionToString());
		
		User manh =  m_dataBaseConnection.getUser("manh");
		System.out.println(manh.toString());
		User trang =  m_dataBaseConnection.getUser("trang");
		System.out.println(trang.toString());
	}
}

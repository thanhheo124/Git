package com.bkhn.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.bkhn.model.ChoiceQuestion;
import com.bkhn.model.Exam;
import com.bkhn.model.QuizQuestion;
import com.bkhn.model.Subject;

public class FileIO {
	public static final String ORIGINAL_PATH = "D:\\OOP\\data";

	public boolean WriteStringToFile(String content, String filePath, String fileName) {
		try {
			File directory = new File(ORIGINAL_PATH + filePath);
			if (!directory.exists())
				directory.mkdirs();
			File file = new File(ORIGINAL_PATH + filePath + "\\" + fileName);
			if (!file.exists())
				file.createNewFile();

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	/*------------------------ Handle subjects ---------------------*/
	public int UpdateListSubject(ArrayList<Subject> subjects) {
		String content = "";
		for (int i = 0; i < subjects.size(); i++) {
			content += subjects.get(i).ToJsonString();
			content += "\n";
		}
		WriteStringToFile(content, "", "subjects.txt");
		return subjects.size();
	}

	public ArrayList<Subject> GetListSubject() {
		ArrayList<Subject> subjects = new ArrayList<Subject>();
		try {
			File directory = new File(ORIGINAL_PATH + "");
			if (!directory.exists())
				directory.mkdirs();
			File file = new File(ORIGINAL_PATH + "\\" + "subjects.txt");
			if (!file.exists())
				file.createNewFile();
			BufferedReader reader = new BufferedReader(new FileReader(ORIGINAL_PATH + "\\" + "subjects.txt"));
			String str;

			while ((str = reader.readLine()) != null) {
				if (!str.equals("") && !str.equals("\n")) {
					Object obj = JSONValue.parse(str);
					JSONObject object = (JSONObject) obj;
					String name = (String) object.get("name");
					String id = (String) object.get("id");
					int numChapter = Integer.parseInt(((Long) object.get("numChapter")).toString());
					String intro = (String) object.get("introduction");
					Subject subject = new Subject(name, id, numChapter, intro);
					subjects.add(subject);
				}
			}
		} catch (IOException e) {
		}
		return subjects;
	}

	/*------------------------ Question common ---------------------*/

	private ChoiceQuestion JsonStringToChoiceQuestion(String jsonStr) {
		return null;
	}

	private QuizQuestion jsonStringToQuizQuestion(String jsonStr) {
		return null;
	}

	private int UpdateListChoiceQuestion(ArrayList<ChoiceQuestion> choiceQuestions, String filePath, String fileName) {
		String content = "";
		if (choiceQuestions.size() <= 0)
			return 0;
		for (int i = 0; i < choiceQuestions.size(); i++) {
			content += choiceQuestions.get(i).ToJsonString();
			content += "\n";
		}
		WriteStringToFile(content, filePath, fileName);
		return choiceQuestions.size();
	}

	private ArrayList<ChoiceQuestion> GetListChoiceQuestion(String filePath, String fileName) {
		ArrayList<ChoiceQuestion> questiones = new ArrayList<ChoiceQuestion>();

		try {
			File directory = new File(ORIGINAL_PATH + filePath);
			if (!directory.exists())
				directory.mkdirs();
			File file = new File(ORIGINAL_PATH + filePath + "\\" + fileName);
			if (!file.exists())
				file.createNewFile();
			BufferedReader reader = new BufferedReader(new FileReader(ORIGINAL_PATH + filePath + "\\" + fileName));
			String str = null;
			while ((str = reader.readLine()) != null) {
				if (!str.equals("") && !str.equals("\n")) {
					Object obj = JSONValue.parse(str);
					JSONObject object = (JSONObject) obj;
					String content = (String) object.get("content");
					int chapter = Integer.parseInt(((Long) object.get("chapter")).toString());
					int level = Integer.parseInt(((Long) object.get("level")).toString());
					int numc = Integer.parseInt(((Long) object.get("numc")).toString());
					int numa = Integer.parseInt(((Long) object.get("numa")).toString());
					ChoiceQuestion question = new ChoiceQuestion(content, chapter, level, null, null);
					for (int i = 0; i < numc; i++) {
						String choice = (String) object.get("choices" + i);
						question.addChoices(choice);
					}
					for (int i = 0; i < numa; i++) {
						String answer = (String) object.get("answers" + i);
						question.addChoices(answer);
					}
					questiones.add(question);
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return questiones;
	}

	private int UpdateListQuizQuestion(ArrayList<QuizQuestion> quizQuestions, String filePath, String fileName) {
		String content = "";
		if (quizQuestions.size() <= 0)
			return 0;
		for (int i = 0; i < quizQuestions.size(); i++) {
			content += quizQuestions.get(i).ToJsonString();
			content += "\n";
		}
		WriteStringToFile(content, filePath, fileName);
		return quizQuestions.size();
	}

	private ArrayList<QuizQuestion> GetListQuizQuestion(String filePath, String fileName) {
		ArrayList<QuizQuestion> questiones = new ArrayList<QuizQuestion>();

		try {
			File directory = new File(ORIGINAL_PATH + filePath);
			if (!directory.exists())
				directory.mkdirs();
			File file = new File(ORIGINAL_PATH + filePath + "\\" + "quiz.txt");
			if (!file.exists())
				file.createNewFile();
			BufferedReader reader = new BufferedReader(new FileReader(ORIGINAL_PATH + filePath + "\\" + "quiz.txt"));
			String str = null;
			while ((str = reader.readLine()) != null) {
				if (!str.equals("") && !str.equals("\n")) {
					Object obj = JSONValue.parse(str);
					JSONObject object = (JSONObject) obj;
					String content = (String) object.get("content");
					int chapter = Integer.parseInt(((Long) object.get("chapter")).toString());
					int level = Integer.parseInt(((Long) object.get("level")).toString());
					String suggestion = (String) object.get("suggestion");
					QuizQuestion question = new QuizQuestion(content, chapter, level, suggestion);
					questiones.add(question);
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return questiones;
	}

	/*------------------------ ChoiceQuestion ---------------------*/
	public int UpdateListChoiceQuestion(ArrayList<ChoiceQuestion> choiceQuestions, String subjectName) {
		return UpdateListChoiceQuestion(choiceQuestions, "\\" + subjectName, "choice.txt");
	}

	public ArrayList<ChoiceQuestion> GetListChoiceQuestion(String subjectName) {
		return GetListChoiceQuestion("\\" + subjectName, "choice.txt");
	}

	/*------------------------ QuizQuestion ---------------------*/
	public int UpdateListQuizQuestion(ArrayList<QuizQuestion> quizQuestions, String subjectName) {
		return UpdateListQuizQuestion(quizQuestions, "\\" + subjectName, "quiz.txt");
	}

	public ArrayList<QuizQuestion> GetListQuizQuestion(String subjectName) {
		return GetListQuizQuestion("\\" + subjectName, "quiz.txt");
	}

	/*------------------------ Exam -----------------------------*/

	public void UpdateExam(Exam exam) {
		String filePath = "\\Exams\\" + exam.getSubjectId() + "\\" + exam.getName();
		String fileName = "general.txt";
		String content = exam.getName() +"\n" + exam.getSubjectName() + "\n" + exam.getSubjectId() + "\n" + exam.getTime();
		WriteStringToFile(content, filePath, fileName);
		UpdateListChoiceQuestion(exam.getChoiceQuestions(), filePath, "choice.txt");
		UpdateListQuizQuestion(exam.getQuizQuestions(), filePath, "quiz.txt");
	}

	public Exam GetExame(String subjectName, String examName) {
		Exam exam = new Exam();
		String filePath = "\\Exams\\" + exam.getSubjectId() + "\\" + exam.getName();
		String fileName = "general.txt";
		
		try {
			File directory = new File(ORIGINAL_PATH + filePath);
			if (!directory.exists())
				directory.mkdirs();
			File file = new File(ORIGINAL_PATH + filePath + "\\" + fileName);
			if (!file.exists())
				file.createNewFile();
			BufferedReader reader = new BufferedReader(new FileReader(ORIGINAL_PATH + filePath + "\\" + fileName));
			String str;
			if((str = reader.readLine()) != null)
				exam.setName(str);

			if((str = reader.readLine()) != null)
				exam.setSubjectName(str);
			
			if((str = reader.readLine()) != null)
				exam.setSubjectId(str);
				
			if((str = reader.readLine()) != null)
				exam.setTime(Float.parseFloat(str));
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		exam.setChoiceQuestions(GetListChoiceQuestion(filePath, "choice.txt"));
		exam.setQuizQuestions(GetListQuizQuestion(filePath, "quiz.txt"));
		
		return exam;
	}
}

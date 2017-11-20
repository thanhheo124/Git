package com.bkhn.controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import com.bkhn.gui.GuiChooseSubject;
import com.bkhn.gui.GuiCreatExamAuto;
import com.bkhn.gui.GuiEditExam;
import com.bkhn.gui.GuiEditQuestion;
import com.bkhn.gui.GuiManageExam;
import com.bkhn.gui.GuiManageObject;
import com.bkhn.gui.GuiStart;
import com.bkhn.interfacecommon.IChooseSubject;
import com.bkhn.interfacecommon.IEditExam;
import com.bkhn.interfacecommon.IEditQuestion;
import com.bkhn.interfacecommon.IGuiManageExam;
import com.bkhn.interfacecommon.IManagerObject;
import com.bkhn.interfacecommon.IStart;
import com.bkhn.model.ChoiceQuestion;
import com.bkhn.model.Exam;
import com.bkhn.model.QuizQuestion;
import com.bkhn.model.Subject;
import com.bkhn.util.FileIO;

public class Controller implements IManagerObject, IStart, IChooseSubject, IEditQuestion, IGuiManageExam, IEditExam {
	public static int CREAT_QUESTION_MODE = 1;
	public static int CREAT_EXAM_MODE = 2;
	private ArrayList<Subject> subjects;
	private ArrayList<ChoiceQuestion> choiceQuestions;
	private ArrayList<QuizQuestion> quizQuestions;
	private FileIO fileIO;
	private int guiMode;
	private String idSubject;

	private GuiStart guiStart;
	private GuiChooseSubject guiChooseSubject;
	private GuiManageObject guiManageObject;
	private GuiEditQuestion guiEditQuestion;
	private GuiManageExam guiManageExam;
	private GuiEditExam guiEditExam;
	private GuiCreatExamAuto guiCreatExamAuto;

	public Controller() {
		subjects = new ArrayList<Subject>();
		choiceQuestions = new ArrayList<ChoiceQuestion>();
		quizQuestions = new ArrayList<QuizQuestion>();
		fileIO = new FileIO();
		subjects = fileIO.GetListSubject();
		ShowGuiStart();
	}

	public void ShowGuiStart() {
		guiStart = new GuiStart();
		guiStart.setVisible(true);
		guiStart.setOwner(this);
		guiStart.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}

	public void showChooseSubject() {
		guiStart.setVisible(false);
		guiChooseSubject = new GuiChooseSubject();
		guiChooseSubject.setVisible(true);
		guiChooseSubject.setOwner(this);
		guiChooseSubject.setSubjects(subjects);
		guiChooseSubject.updateView();
		guiChooseSubject.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				guiStart.setVisible(true);
			}
		});
	}

	public void showGuiManagerObject() {
		guiChooseSubject.setVisible(false);
		guiManageObject = new GuiManageObject();
		guiManageObject.setVisible(true);
		guiManageObject.setArrayListSubject(subjects);
		guiManageObject.setOwner(this);
		guiManageObject.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				guiChooseSubject.setVisible(true);
				guiChooseSubject.setSubjects(subjects);
				guiChooseSubject.updateView();
			}
		});
	}

	public void showGuiEditQuestions() {
		System.out.println("showGuiEditQuestions");
		guiChooseSubject.setVisible(false);
		guiEditQuestion = new GuiEditQuestion();
		guiEditQuestion.setVisible(true);
		guiEditQuestion.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				guiStart.setVisible(true);
			}
		});
		guiEditQuestion.setListChoiceQuestion(choiceQuestions);
		guiEditQuestion.setListQuizQuestion(quizQuestions);
		guiEditQuestion.setOwner(this);
	}

	public void showGUIManageExam() {
		guiManageExam = new GuiManageExam();
		guiManageExam.setVisible(true);
		guiManageExam.setOwner(this);
		guiManageExam.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				guiStart.setVisible(true);
			}
		});
	}

	public void showGuiEdiExam() {
		guiEditExam = new GuiEditExam();
		guiEditExam.setVisible(true);
		guiEditExam.setOwner(this);
		guiEditExam.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				guiManageExam.setVisible(true);
			}
		});
		guiEditExam.setListChoice(choiceQuestions);
		guiEditExam.setListQuiz(quizQuestions);
		for (int i = 0; i < subjects.size(); i++) {
			if (subjects.get(i).getId().equals(idSubject))
				guiEditExam.setSubject(subjects.get(i));
		}
	}

	public void showGuiAutoExam() {
		guiCreatExamAuto = new GuiCreatExamAuto();
		guiCreatExamAuto.setVisible(true);
		// guiCreatExamAuto.setOwner(this);
		guiCreatExamAuto.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				guiManageExam.setVisible(true);
			}
		});
		// guiCreatExamAuto.setListChoice(choiceQuestions);
		// guiCreatExamAuto.setListQuiz(quizQuestions);
		// for(int i=0; i< subjects.size(); i++) {
		// if(subjects.get(i).getId().equals(idSubject))
		// guiCreatExamAuto.setSubject(subjects.get(i));
		// }
	}

	@Override
	public void updateSubjectData(ArrayList<Subject> subjects) {
		this.subjects = subjects;
		fileIO.UpdateListSubject(subjects);
	}

	@Override
	public void questionsContruction() {
		System.out.println("questionsContruction");
		guiMode = CREAT_QUESTION_MODE;
		showChooseSubject();
	}

	@Override
	public void examContruction() {
		System.out.println("examContruction");
		guiMode = CREAT_EXAM_MODE;
		showChooseSubject();
	}

	@Override
	public void onChooseSubject(String idSubject) {
		System.out.println("onChooseSubject: " + idSubject);
		this.idSubject = idSubject;
		guiChooseSubject.setVisible(false);
		choiceQuestions = fileIO.GetListChoiceQuestion(idSubject);
		quizQuestions = fileIO.GetListQuizQuestion(idSubject);
		switch (guiMode) {
		case 1:
			showGuiEditQuestions();
			break;
		case 2:
			showGUIManageExam();
			break;
		}
	}

	@Override
	public void onManagerSubject() {
		System.out.println("onManagerSubject");
		showGuiManagerObject();
	}

	@Override
	public void onSaveQuestions() {
		fileIO.UpdateListChoiceQuestion(choiceQuestions, idSubject);
		fileIO.UpdateListQuizQuestion(quizQuestions, idSubject);
	}

	@Override
	public void onEditExam() {
		System.out.println("onEditExam");
		guiManageExam.setVisible(false);
	}

	@Override
	public void onCreatExamByHand() {
		System.out.println("onCreatExamByHand");
		guiManageExam.setVisible(false);
		showGuiEdiExam();
	}

	@Override
	public void onCreatExamAuto() {
		System.out.println("onCreatExamAuto");
		guiManageExam.setVisible(false);
		showGuiAutoExam();
	}

	@Override
	public void onUpdateExam(Exam exam) {
		System.out.println("onUpdateExam");
		fileIO.UpdateExam(exam);
	}
}

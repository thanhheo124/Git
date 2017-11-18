package com.bkhn.controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import com.bkhn.gui.GuiChooseSubject;
import com.bkhn.gui.GuiEditQuestion;
import com.bkhn.gui.GuiManageObject;
import com.bkhn.gui.GuiStart;
import com.bkhn.interfacecommon.IChooseSubject;
import com.bkhn.interfacecommon.IManagerObject;
import com.bkhn.interfacecommon.IStart;
import com.bkhn.model.Subject;
import com.bkhn.util.FileIO;

public class Controller implements IManagerObject, IStart, IChooseSubject {
	public static int CREAT_QUESTION_MODE = 1;
	public static int CREAT_EXAM_MODE = 2;
	private ArrayList<Subject> subjects;
	private FileIO fileIO;
	private int guiMode;
	private String idSubject;

	private GuiManageObject guiManageObject;
	private GuiStart guiStart;
	private GuiChooseSubject guiChooseSubject;
	private GuiEditQuestion guiEditQuestion;

	public Controller() {
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

	public void showGuiEditQuestions()
	{
		System.out.println("showGuiEditQuestions");
		guiChooseSubject.setVisible(false);
		guiEditQuestion = new GuiEditQuestion();
		guiEditQuestion.setVisible(true);
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
		switch (guiMode) {
		case 1:
			showGuiEditQuestions();
			break;
		case 2:
			// show exam mode
			break;
		}
	}

	@Override
	public void onManagerSubject() {
		System.out.println("onManagerSubject");
		showGuiManagerObject();
	}
}

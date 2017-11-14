package com.bkhn.controller;

import java.util.ArrayList;

import com.bkhn.gui.GuiManageObject;
import com.bkhn.interfacecommon.IManagerObject;
import com.bkhn.model.Subject;
import com.bkhn.util.FileIO;

public class Controller implements IManagerObject {
	private ArrayList<Subject> subjects;
	private FileIO fileIO;
	private GuiManageObject guiManageObject;
	
	public Controller() {
		fileIO = new FileIO();
		subjects = fileIO.GetListSubject();
		guiManageObject = new GuiManageObject();
		guiManageObject.setArrayListSubject(subjects);
		guiManageObject.setVisible(true);
	}

	@Override
	public void insertSuject(Subject subject) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteSubject(Subject subject) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateSubject(Subject subject) {
		// TODO Auto-generated method stub

	}

}

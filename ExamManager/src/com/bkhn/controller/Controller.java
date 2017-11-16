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
		guiManageObject.setVisible(true);
		guiManageObject.setArrayListSubject(subjects);
		guiManageObject.setOwner(this);
	}

	@Override
	public void updateSubjectData(ArrayList<Subject> subjects) {
		this.subjects = subjects;
		fileIO.UpdateListSubject(subjects);
	}	
}

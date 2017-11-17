package com.bkhn.controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
		guiManageObject.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				// System.exit(0);
			}
		});
	}

	@Override
	public void updateSubjectData(ArrayList<Subject> subjects) {
		this.subjects = subjects;
		fileIO.UpdateListSubject(subjects);
	}
}

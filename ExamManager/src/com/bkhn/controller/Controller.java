package com.bkhn.controller;

import java.util.ArrayList;

import com.bkhn.gui.GuiManageObject;
import com.bkhn.gui.GuiManager;
import com.bkhn.gui.interfacecommon.IManagerObject;
import com.bkhn.model.Subject;
import com.bkhn.util.DatabaseConnection;
import com.bkhn.util.Printer;

public class Controller implements IManagerObject{
	private GuiManager m_guiManager;	
	private DatabaseConnection m_dataBaseConnection;
	private Printer m_printer;
	private GuiManageObject m_guiManagerObject;
	
	private ArrayList<Subject> m_Subjects;
	
	
	public Controller() {
		m_dataBaseConnection = new DatabaseConnection();
		m_dataBaseConnection.connectToDataBase();
		
		m_Subjects = m_dataBaseConnection.getAllSubject();
		
		m_guiManagerObject = new GuiManageObject();
		m_guiManagerObject.setArrayListSubject(m_Subjects);
		m_guiManagerObject.setOwnerObject(this);
		m_guiManagerObject.guiManagerObjectStart();
		m_guiManagerObject.setVisible(true);
	}
	
	@Override
	public void insertSuject(Subject subject) {
		m_dataBaseConnection.insertSubject(subject);
	}
	@Override
	public void deleteSubject(Subject subject) {
		m_dataBaseConnection.deleteSubject(subject);
	}
	@Override
	public void updateSubject(Subject subject) {
		m_dataBaseConnection.updateSubject(subject);
	}
}

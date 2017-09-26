package com.bkhn.gui;

public class GuiManager {
	private GuiStart guiStart ;
	private GuiChooseSubject guiChooseSubject;
	private GuiManageObject guiManageObject;
	private GuiEditQuestion guiEditQuestion;
	private GuiListQuestion guiListQuestion;
	private GuiManageExam guiManageExam;
	private GuiEditExam guiEditExam;
	private GuiChooseExam guiChooseExam;
	private GuiCreatExamAuto guiCreatExamAuto;
	private GuiCorrectAnswer guiCorrectAnswer;
	
	public GuiManager() {
		guiStart = new GuiStart();
		guiStart.setVisible(true);
		
		guiChooseSubject = new GuiChooseSubject();
		guiChooseSubject.setVisible(true);
		
		guiManageObject = new GuiManageObject();
		guiManageObject.setVisible(true);
		
		guiEditQuestion = new GuiEditQuestion();
		guiEditQuestion.setVisible(true);
		
		guiListQuestion = new GuiListQuestion();
		guiListQuestion.setVisible(true);
		
		guiCorrectAnswer = new GuiCorrectAnswer();
		guiCorrectAnswer.setVisible(true);
		
		guiManageExam = new GuiManageExam();
		guiManageExam.setVisible(true);
		
		guiChooseExam = new GuiChooseExam();
		guiChooseExam.setVisible(true);
		
		guiEditExam = new GuiEditExam();
		guiEditExam.setVisible(true);
		
		guiCreatExamAuto = new GuiCreatExamAuto();
		guiCreatExamAuto.setVisible(true);
		
	}
}

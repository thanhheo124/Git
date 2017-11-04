package com.bkhn.util;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import com.bkhn.model.ChoiceQuestion;
import com.bkhn.model.QuizQuestion;

public class Printer {
	
	public static void PrintExam(ArrayList<ChoiceQuestion> listChoisQ, ArrayList<QuizQuestion> listQuizQ) throws IOException{
		
		XWPFDocument document = new XWPFDocument(); 
	    FileOutputStream out = null;
	    File file;

		JFileChooser chooser = new JFileChooser();
	     chooser.setCurrentDirectory(new File("C:/Users/"+System.getProperty("user.name")+"/Desktop"));
	     int save = chooser.showSaveDialog(null);
	     if (save == JFileChooser.APPROVE_OPTION) {        
	        	 file=new File(chooser.getSelectedFile() + ".docx");     		
	        	 out = new FileOutputStream(file);
	             Desktop.getDesktop().open(file);                      
	     }
	     
	     XWPFParagraph paragraph = document.createParagraph();
	     XWPFRun run = paragraph.createRun();
	     
	     for(int i=0;i<listChoisQ.size();i++){
	    	 run.setText(listChoisQ.get(i).getContent());
	    	 run.addBreak();
	    	 ArrayList<String> choie=listChoisQ.get(i).getChoices();
	    	 char c='A';
	    	 for(int j=0;j< choie.size();j++){
	    		 run.setText(c+" "+choie.get(j));
	    		 c++;
	    		 run.addBreak();
	    	 }
	     }
	     
	     for(int i=0;i<listQuizQ.size();i++){
	    	 run.setText(listQuizQ.get(i).getContent());
	    	 run.addBreak();
	     }
	     document.write(out);
	     out.close();
	}
	
	public void printAnswer(ArrayList<ChoiceQuestion> listChoisQ, ArrayList<QuizQuestion> listQuizQ) 
			throws IOException{
		XWPFDocument document = new XWPFDocument(); 
	    FileOutputStream out = null;
	    File file;
	    
		JFileChooser chooser = new JFileChooser();
	     chooser.setCurrentDirectory(new File("C:/Users/"+System.getProperty("user.name")+"/Desktop"));
	     int save = chooser.showSaveDialog(null);
	     if (save == JFileChooser.APPROVE_OPTION) {        
	        	 file=new File(chooser.getSelectedFile() + ".docx");     		
	        	 out = new FileOutputStream(file);
	             Desktop.getDesktop().open(file);                      
	     }
	     
	     XWPFParagraph paragraph = document.createParagraph();
	     XWPFRun run = paragraph.createRun();
	     
	     for(int i=0;i<listChoisQ.size();i++){
	    	 ArrayList<String> choie=listChoisQ.get(i).getAnswers();
	    	 for(int j=0;j< choie.size();j++){
	    		 run.setText(choie.get(j));
	    		 run.addBreak();
	    	 }
	     }
	     
	     for(int i=0;i<listQuizQ.size();i++){
	    	 run.setText(listQuizQ.get(i).getSuggestion());
	    	 run.addBreak();
	     }
	     
	    document.write(out);
	    out.close();
	}
}
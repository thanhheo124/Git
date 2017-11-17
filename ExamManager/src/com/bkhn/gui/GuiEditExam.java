package com.bkhn.gui;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import com.bkhn.gui.interfacecommon.ICommonGui;
import com.bkhn.model.ChoiceQuestion;
import com.bkhn.model.Question;
import com.bkhn.model.QuizQuestion;

import javax.swing.border.LineBorder;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class GuiEditExam extends JFrame implements ICommonGui{

	private static final int WIDTH_FRAME = 908;
	private static final int HEIGHT_FRAME = 970;
	private JLabel lblListQuestion;
	private JScrollPane scrollPane;
	private JTable tableListQuestion;
	private JButton btnChooseRandomQuestion;
	private JLabel lblPointQuestion;
	private JTextField txtPointQuestion;
	private JButton btnAddToExam;
	private JLabel lblTypeQuestion;
	private JRadioButton radioAll;
	private JRadioButton radioMulti;
	private JRadioButton radioEssay;
	private JScrollPane scrollPane_1;
	private JTable tableListQuestionInExam;
	private Component lblTime;
	private JLabel lblYear;
	private JLabel lblSeason;
	private JTextField txtTime;
	private JTextField txtSeason;
	private JLabel lblMinutes;
	private JLabel lblMixQuestion;
	private Component lblPrint;
	private Component lblExport;
	private JRadioButton radioSeason1;
	private JRadioButton radioSeason2;
	private JRadioButton rdSeasonSummner;
	private JTextPane txtPaneInformationExam;
	private JButton btnSaveExam;
	private JButton btnDeleteExam;
	private JTextPane txtpnDDD;
	private JButton btnXaCuHi ;
	private ArrayList<ChoiceQuestion> listChoice;
	private ArrayList<ChoiceQuestion> listChoiceExam;
	private ArrayList<QuizQuestion> listQuiz;
	private ArrayList<QuizQuestion> listQuizExam;
	
	private DefaultTableModel dtmQuestion;
	private DefaultTableModel dtmQuestionExam;
	private int indexDtmQuestion;
	private int indexExamQuestion;
	private Random rand; // Global variable
	
	

	public GuiEditExam() {
		init();
		addComps();
	}
	
	@Override
	public void init() {
		setSize(WIDTH_FRAME, HEIGHT_FRAME);
//		getContentPane().setBackground(Color.BLUE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

	}
	
	public int random(int min,int max) {
		Random r=new Random();
		int radomNum=r.nextInt(Math.abs(max - min)+1);
		if(min<max) radomNum +=min;
		else radomNum +=max;
		System.out.println(radomNum);
		return radomNum;
	}
	
	public boolean checkQuestion(ArrayList<ChoiceQuestion> listC,ArrayList<QuizQuestion> listQ,String content){
		boolean check=true;
		if(listC !=null){
			for(ChoiceQuestion q:listC){
				if(content.equals(q.getContent())) check=false;	
			}
		}
		if(listQ !=null){
			for(QuizQuestion q:listQ){
				if(content.equals(q.getContent())) check=false;
			}
		}
		if (check==true) return check;
		else{
			JOptionPane.showMessageDialog(null,"question exists in exam! Try again!");
			return false;
		}
		
	}
	
	public void loadListQuestion(ArrayList<ChoiceQuestion> listC,ArrayList<QuizQuestion> listQ, DefaultTableModel dtm){
		dtm.setRowCount(0);
		if(listC !=null){
			for(ChoiceQuestion q:listC){
			Vector<Object> vec=new Vector<Object>();
			vec.add(q.getContent());
			dtm.addRow(vec);
			}
		}
		if(listQ !=null){
			for(QuizQuestion q:listQ){
			Vector<Object> vec=new Vector<Object>();
			vec.add(q.getContent());
			dtm.addRow(vec);
			}
		}
	}
	
	public void loadContenQuestion(ChoiceQuestion questionC,QuizQuestion questionQ,JTextPane jtp){
		if(questionC !=null){
			jtp.setText(questionC.QuestionToString());
		}
		if(questionQ !=null){
			jtp.setText(questionQ.QuestionToString());
		}
	}
	
	public void loadContenExam(ArrayList<ChoiceQuestion> listC,ArrayList<QuizQuestion> listQ,JTextPane jtp){
		String s="";
		int k=1;
		if(listC !=null){
			for(int i=0;i<listC.size();i++){
				s +=k+". "+listC.get(i).getContent()+"\n";
				for(int j=0;j<listC.get(i).getChoices().size();j++){
					s += listC.get(i).getChoices().get(j)+"\n";
				}
				k++;
			}
		}
		if(listQ !=null){
			for(int i=0;i<listQ.size();i++){
				s+= k+". "+listQ.get(i).getContent()+"\n";
				k++;
			}
			
		}
		jtp.setText(s);
	}
	

	@Override
	public void addComps() {
		listChoice=new ArrayList<ChoiceQuestion>();
		listChoiceExam=new ArrayList<ChoiceQuestion>();
		listQuiz=new ArrayList<QuizQuestion>();
		listQuizExam=new ArrayList<QuizQuestion>();
		
		//create list question
		
		ChoiceQuestion choiceQuestion0 = new ChoiceQuestion( "Choise question 0", "IT101", 9, 8, null, null);
		choiceQuestion0.addChoices("hanoi");
		choiceQuestion0.addAnswers("hanoi");
		choiceQuestion0.addChoices("vietnam");
		ChoiceQuestion choiceQuestion1 = new ChoiceQuestion( "Choise question 1", "IT101", 8, 0, null, null);
		choiceQuestion1.addChoices("hanoi");
		choiceQuestion1.addAnswers("hanoi");
		choiceQuestion1.addChoices("vietnam");
		
		listChoice.add(choiceQuestion0);
		listChoice.add(choiceQuestion1);
		
		//create list question
		QuizQuestion question1 = new QuizQuestion( "QuizQuestion 0", "IT101", 2, 3, "suggestion0");
		QuizQuestion question2 = new QuizQuestion( "QuizQuestion 1", "IT101", 2, 3, "suggestion1");
		QuizQuestion question3 = new QuizQuestion( "QuizQuestion 2", "IT101", 2, 3, "suggestion2");
		 listQuiz.add(question1);
		 listQuiz.add(question2);
		 listQuiz.add(question3);
		 
		
		lblListQuestion = new JLabel("Danh sách câu hỏi");
		lblListQuestion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblListQuestion.setBounds(12, 13, 148, 22);
		getContentPane().add(lblListQuestion);
		
		lblPointQuestion = new JLabel("Điểm cho câu hỏi");
		lblPointQuestion.setBounds(433, 387, 116, 22);
		getContentPane().add(lblPointQuestion);
		
		lblTypeQuestion = new JLabel("Dạng câu hỏi");
		lblTypeQuestion.setBounds(22, 46, 116, 16);
		getContentPane().add(lblTypeQuestion);
		
		lblTime = new JLabel("Thời gian");
		lblTime.setBounds(12, 760, 83, 16);
		getContentPane().add(lblTime);
		
		lblYear = new JLabel("Năm học");
		lblYear.setBounds(12, 789, 83, 16);
		getContentPane().add(lblYear);
		
		lblSeason = new JLabel("Kỳ");
		lblSeason.setBounds(12, 825, 83, 16);
		getContentPane().add(lblSeason);
		
		lblMinutes = new JLabel("phút");
		lblMinutes.setBounds(211, 760, 83, 16);
		getContentPane().add(lblMinutes);
		
		lblMixQuestion = new JLabel("<html><u>Xáo trộn các câu hỏi</u></html>");
		lblMixQuestion.setForeground(Color.BLUE);
		lblMixQuestion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMixQuestion.setBounds(433, 807, 148, 22);
		getContentPane().add(lblMixQuestion);
		
		lblPrint = new JLabel("<html><u>In</u></html>");
		lblPrint.setForeground(Color.BLUE);
		lblPrint.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrint.setBounds(658, 807, 35, 22);
		getContentPane().add(lblPrint);
		
		lblExport = new JLabel("<html><u>Xuất ra file</u></html>");
		lblExport.setForeground(Color.BLUE);
		lblExport.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblExport.setBounds(767, 807, 83, 22);
		getContentPane().add(lblExport);
		
		txtTime = new JTextField();
		txtTime.setBackground(Color.WHITE);
		txtTime.setBounds(81, 757, 116, 22);
		getContentPane().add(txtTime);
		txtTime.setColumns(10);
		
		txtSeason = new JTextField();
		txtSeason.setBackground(Color.WHITE);
		txtSeason.setColumns(10);
		txtSeason.setBounds(81, 789, 116, 22);
		getContentPane().add(txtSeason);
		
		txtPointQuestion = new JTextField();
		txtPointQuestion.setBackground(Color.WHITE);
		txtPointQuestion.setBounds(549, 387, 57, 22);
		getContentPane().add(txtPointQuestion);
		txtPointQuestion.setColumns(10);
		
		
		txtPaneInformationExam = new JTextPane();
		txtPaneInformationExam.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtPaneInformationExam.setBounds(454, 440, 396, 257);
		getContentPane().add(txtPaneInformationExam);
		
		btnChooseRandomQuestion = new JButton("Chọn câu hỏi ngẫu nhiên");
		btnChooseRandomQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int sizeChoiec=listChoice.size();
				int sizeQuiz=listQuiz.size();
				
				if(radioMulti.isSelected()){
					indexDtmQuestion=random(0,sizeChoiec-1);
					if(checkQuestion(listChoiceExam, null, listChoice.get(indexDtmQuestion).getContent()))
						listChoiceExam.add(listChoice.get(indexDtmQuestion));
				}
				else if(radioEssay.isSelected()){
					indexDtmQuestion=random(0,sizeQuiz-1);
					if(checkQuestion(null, listQuizExam, listQuiz.get(indexDtmQuestion).getContent()))
						listQuizExam.add(listQuiz.get(indexDtmQuestion));
					
				}
				else if(radioAll.isSelected()){
					indexDtmQuestion=random(0,sizeQuiz+sizeChoiec-1);
					if(indexDtmQuestion<listChoice.size()){
						
						if(checkQuestion(listChoiceExam, null, listChoice.get(indexDtmQuestion).getContent()))
							listChoiceExam.add(listChoice.get(indexDtmQuestion));
					}
					else{
						int indexRealQuiz=indexDtmQuestion-listChoice.size();
						if(checkQuestion(null, listQuizExam, listQuiz.get(indexRealQuiz).getContent()))
							listQuizExam.add(listQuiz.get(indexRealQuiz));
					}
						
				}
				loadListQuestion(listChoiceExam, listQuizExam, dtmQuestionExam);
				loadContenExam(listChoiceExam, listQuizExam, txtPaneInformationExam);
				
				
			}
		});
		btnChooseRandomQuestion.setBounds(60, 361, 220, 25);
		getContentPane().add(btnChooseRandomQuestion);
		
		btnAddToExam = new JButton("Thêm vào đề thi");
		btnAddToExam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indexRealQuiz=indexDtmQuestion-listChoice.size();
				if(radioMulti.isSelected()){
					if(checkQuestion(listChoiceExam, null, listChoice.get(indexDtmQuestion).getContent()))
						listChoiceExam.add(listChoice.get(indexDtmQuestion));
				}
				else if(radioEssay.isSelected()){
					if(checkQuestion(null, listQuizExam, listQuiz.get(indexDtmQuestion).getContent()))
						listQuizExam.add(listQuiz.get(indexDtmQuestion));
				}
				else if(radioAll.isSelected()){
					if(indexDtmQuestion<listChoice.size()){
						if(checkQuestion(listChoiceExam, null, listChoice.get(indexDtmQuestion).getContent()))
							listChoiceExam.add(listChoice.get(indexDtmQuestion));
					}	
					else{
						if(checkQuestion(null, listQuizExam, listQuiz.get(indexRealQuiz).getContent()))
							listQuizExam.add(listQuiz.get(indexRealQuiz));
					}		
				}
				loadListQuestion(listChoiceExam, listQuizExam, dtmQuestionExam);
				loadContenExam(listChoiceExam, listQuizExam, txtPaneInformationExam);
			}
		});
		btnAddToExam.setBounds(684, 380, 148, 29);
		getContentPane().add(btnAddToExam);
		
		btnSaveExam = new JButton("Lưu đề thi");
		btnSaveExam.setBackground(Color.BLUE);
		btnSaveExam.setForeground(Color.WHITE);
		btnSaveExam.setBounds(218, 855, 121, 40);
		getContentPane().add(btnSaveExam);
		
		btnDeleteExam = new JButton("Xóa đề thi");
		btnDeleteExam.setBackground(Color.RED);
		btnDeleteExam.setForeground(Color.WHITE);
		btnDeleteExam.setBounds(460, 855, 121, 40);
		getContentPane().add(btnDeleteExam);
		
		radioAll = new JRadioButton("Tất cả");
		radioAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioMulti.setSelected(false);
				radioEssay.setSelected(false);
				loadListQuestion(listChoice, listQuiz, dtmQuestion);
			}
		});
		radioAll.setBounds(32, 70, 83, 25);
		getContentPane().add(radioAll);
		
		radioMulti = new JRadioButton("Trắc nghiệm");
		radioMulti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				radioAll.setSelected(false);
				radioEssay.setSelected(false);
				loadListQuestion(listChoice,null, dtmQuestion);
			}
		});
		radioMulti.setBounds(113, 69, 103, 25);
		getContentPane().add(radioMulti);
		
		
		radioEssay = new JRadioButton("Tự luận");
		radioEssay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioAll.setSelected(false);
				radioMulti.setSelected(false);
				loadListQuestion(null,listQuiz, dtmQuestion);
			}
		});
		radioEssay.setBounds(231, 70, 127, 25);
		getContentPane().add(radioEssay);
		
		radioSeason1 = new JRadioButton("1");
		radioSeason1.setBounds(79, 821, 57, 25);
		getContentPane().add(radioSeason1);
		
		radioSeason2 = new JRadioButton("2");
		radioSeason2.setBounds(138, 821, 57, 25);
		getContentPane().add(radioSeason2);
		
		rdSeasonSummner = new JRadioButton("Hè");
		rdSeasonSummner.setBounds(199, 821, 127, 25);
		getContentPane().add(rdSeasonSummner);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 118, 359, 226);
		getContentPane().add(scrollPane);
		
		dtmQuestion=new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"List Questions"
				}
			);
		tableListQuestion = new JTable();
		tableListQuestion.setModel(dtmQuestion);
		tableListQuestion.setForeground(Color.BLACK);
		scrollPane.setViewportView(tableListQuestion);
		
		tableListQuestion.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				indexDtmQuestion=tableListQuestion.getSelectedRow();
				if(radioMulti.isSelected()){
					loadContenQuestion(listChoice.get(indexDtmQuestion),null, txtpnDDD);
				}
				else if(radioEssay.isSelected()){
					loadContenQuestion(null,listQuiz.get(indexDtmQuestion),txtpnDDD);
				}
				else if(radioAll.isSelected()){
					int indexRealQuiz=indexDtmQuestion-listChoice.size();
					if(indexDtmQuestion<listChoice.size())
						loadContenQuestion(listChoice.get(indexDtmQuestion),null, txtpnDDD);
					else
						loadContenQuestion(null,listQuiz.get(indexRealQuiz),txtpnDDD);
						
				}
				
			}
			
		});
		
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(16, 440, 365, 172);
		getContentPane().add(scrollPane_1);
		
		dtmQuestionExam=new DefaultTableModel(
				new Object[][] {
					{null},
				},
				new String[] {
					"List Question in Exam"
				}
			);
		tableListQuestionInExam = new JTable();
		tableListQuestionInExam.setModel(dtmQuestionExam);
		scrollPane_1.setViewportView(tableListQuestionInExam);
		
		tableListQuestionInExam.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				indexExamQuestion=tableListQuestionInExam.getSelectedRow();					
				if(indexExamQuestion<listChoiceExam.size())
				{
					loadContenQuestion(listChoiceExam.get(indexExamQuestion),null, txtpnDDD);
					loadListQuestion(listChoice,null, dtmQuestion);
					radioAll.setSelected(false);
					radioEssay.setSelected(false);
					radioMulti.setSelected(true);
					
				}
				else
				{
					int indexRealQuiz=indexExamQuestion-listChoiceExam.size();
					loadContenQuestion(null,listQuizExam.get(indexRealQuiz),txtpnDDD);
					loadListQuestion(null,listQuiz, dtmQuestion);
					radioAll.setSelected(false);
					radioMulti.setSelected(false);
					radioEssay.setSelected(true);
				}
			}
		});
		
		JButton btnThayCuHi = new JButton("Thay câu hỏi");
		btnThayCuHi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String value=tableListQuestion.getValueAt(indexDtmQuestion,0).toString();
			
				if(indexExamQuestion<listChoiceExam.size())
				{
					
					loadContenQuestion(listChoice.get(indexDtmQuestion),null, txtpnDDD);

					if(checkQuestion(listChoiceExam,null, value)){
						int reply = JOptionPane.showConfirmDialog(null,"Do you really change?","", JOptionPane.YES_NO_OPTION);
						if (reply == JOptionPane.YES_OPTION) {
							listChoiceExam.remove(indexExamQuestion);
							listChoiceExam.add(listChoice.get(indexDtmQuestion));
							
				}	}	}
				else{
					loadContenQuestion(null,listQuiz.get(indexDtmQuestion),txtpnDDD);
					if(checkQuestion(null,listQuizExam, value)){
						int reply = JOptionPane.showConfirmDialog(null,"Do you really change?","", JOptionPane.YES_NO_OPTION);
						if (reply == JOptionPane.YES_OPTION) {
							listQuizExam.remove(indexExamQuestion-listChoiceExam.size());
							listQuizExam.add(listQuiz.get(indexDtmQuestion));
			}}	}
				loadListQuestion(listChoiceExam, listQuizExam, dtmQuestionExam);
				loadContenExam(listChoiceExam, listQuizExam, txtPaneInformationExam);
				
			}
		});
		btnThayCuHi.setBounds(66, 657, 116, 23);
		getContentPane().add(btnThayCuHi);
		
		btnXaCuHi = new JButton("Xóa câu hỏi");
		btnXaCuHi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(indexExamQuestion<listChoiceExam.size())
				{
					listChoiceExam.remove(indexExamQuestion);
					
				}
				else
				{
					int indexRealQuiz=indexExamQuestion-listChoiceExam.size();
					listQuizExam.remove(indexRealQuiz);
				}
				loadListQuestion(listChoiceExam, listQuizExam, dtmQuestionExam);
				loadContenExam(listChoiceExam, listQuizExam, txtPaneInformationExam);
			}
		});
		btnXaCuHi.setBounds(218, 657, 89, 23);
		getContentPane().add(btnXaCuHi);
		
		txtpnDDD = new JTextPane();
		txtpnDDD.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtpnDDD.setText("d\r\nd\r\nd\r\nd\r\nd\r\nd\r\nd\r\nd\r\nd\r\nd\r\nd\r\nd");
		txtpnDDD.setBounds(460, 118, 330, 226);
		getContentPane().add(txtpnDDD);
		
		
	}
}

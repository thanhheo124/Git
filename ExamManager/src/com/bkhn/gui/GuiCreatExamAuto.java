package com.bkhn.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import com.bkhn.interfacecommon.ICommonGui;
import com.bkhn.model.ChoiceQuestion;
import com.bkhn.model.QuizQuestion;
import com.bkhn.model.Subject;

@SuppressWarnings("serial")
public class GuiCreatExamAuto extends JFrame implements ICommonGui{

	
	private static final int WIDTH_FRAME = 908;
	private static final int HEIGHT_FRAME = 870;
	private JLabel lblTypeExam;
	private JRadioButton radioGeneral;
	private JRadioButton radioEssay;
	private JRadioButton radioAll;	
	private JLabel lblWay;
	private JRadioButton radioSpecific;
	private JLabel lblNumberQuestion;
	private JLabel lblChapter1;
	private Component lblChapter2;
	private JLabel lblChapter3;
	private JSpinner spinnerQuestionNumber;
	private JComboBox<String> cbbLevel;
	private JSpinner spinnerChapter2;
	private JSpinner spinnerChapter3;
	private JButton btnCreateExam;
	private JButton btnDelete;
	private JButton btnSave;
	private JLabel lblListQuestion;
	private JScrollPane scrollPane;
	private JTable tableListQuestion;
	private JLabel lblPrint;
	private JLabel lblExport;
	private JLabel lblTime;
	private JLabel lblInfomationExam;
	private JLabel lblMinute;
	private JLabel lblSeason;
	private JLabel lblYear;
	private JTextField txtYear;
	private JLabel lblExchangeQuestion;
	private JLabel lblDeleteQuestionInExam;
	private JRadioButton radioSeason1;
	private JRadioButton radioSeason2;
	private JRadioButton radionSummer;
	private JTextPane txtPaneExam;
	private JTextField txtMinutes;
	private DefaultTableModel dtm;
	
	
	private ArrayList<ArrayList<ChoiceQuestion>> list;
	private ArrayList<ChoiceQuestion> listChoice;
	private ArrayList<ChoiceQuestion> listChoiceExam;
	private ArrayList<QuizQuestion> listQuiz;
	private ArrayList<QuizQuestion> listQuizExam;
	private int soCau;
	private int doKho;
	private Subject subject;
	private int index;
	private int time;
	private int year;
	

	public GuiCreatExamAuto() {
		listChoice = new ArrayList<ChoiceQuestion>();
		listQuiz = new ArrayList<QuizQuestion>();
		subject = new Subject();
		subject.setNumChapter(1);
		init();
		addComps();
	}
	
	public int radomCauHoi(){
		int n=0;
		return n;
	}
	
	public ArrayList<ArrayList<ChoiceQuestion>> listC (ArrayList<ChoiceQuestion> list,Subject sub,int doKho){
		ArrayList<ArrayList<ChoiceQuestion>> listChoice = new ArrayList<>();
		
		int numChap=sub.getNumChapter();
		for(int i=1;i<= numChap;i++){
			ArrayList<ChoiceQuestion> listChoiceOfChap = new ArrayList<ChoiceQuestion>();
			for(int j=0;j<list.size();j++){
				ChoiceQuestion question=new ChoiceQuestion();
				if(question.getChapter()==i && doKho==question.getLevel()){
					listChoiceOfChap.add(question);
				}
				listChoice.add(listChoiceOfChap);
			}
		}
		
		return listChoice;
	}
	
	public int random(int min,int max) {
		Random r=new Random();
		int radomNum=r.nextInt(Math.abs(max - min)+1);
		if(min<max) radomNum +=min;
		else radomNum +=max;
		System.out.println(radomNum);
		return radomNum;
	}
	
	public boolean checkNum(ArrayList<Integer> listInt, int n){
		boolean check=true;
		for(int i=0;i<listInt.size();i++){
			if(n==listInt.get(i)) check= false;
			else check= true;
		}
		return check;
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
	public void init() {
		setTitle("Quản lý đề thi");
		setSize(WIDTH_FRAME, HEIGHT_FRAME);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
	}

	@Override
	public void addComps() {
		
		listQuiz=new ArrayList<>();
		listChoice=new ArrayList<ChoiceQuestion>();
		subject=new Subject();
		listChoiceExam=new ArrayList<>();
		listQuizExam=new ArrayList<>();
		// create list of list question group by chap
		//create list question	
		ChoiceQuestion choiceQuestion0 = new ChoiceQuestion( "Choise question 0", 1, 1, null,null);
		choiceQuestion0.addChoices("hanoi");
		choiceQuestion0.addAnswers("hanoi");
		choiceQuestion0.addChoices("vietnam");
		ChoiceQuestion choiceQuestion1 = new ChoiceQuestion( "Choise question 1", 1, 1, null, null);
		choiceQuestion1.addChoices("hanoi");
		choiceQuestion1.addAnswers("hanoi");
		choiceQuestion1.addChoices("vietnam");
		
		listChoice.add(choiceQuestion0);
		listChoice.add(choiceQuestion1);
		
		//create list question
		QuizQuestion question1 = new QuizQuestion( "QuizQuestion 0", 1, 1, "suggestion0");
		QuizQuestion question2 = new QuizQuestion( "QuizQuestion 1", 1, 1, "suggestion1");
		QuizQuestion question3 = new QuizQuestion( "QuizQuestion 2", 1, 1, "suggestion2");
		 listQuiz.add(question1);
		 listQuiz.add(question2);
		 listQuiz.add(question3);
		
		
	
		lblTypeExam = new JLabel("Dạng đề thi");
		lblTypeExam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTypeExam.setBounds(31, 13, 86, 25);
		getContentPane().add(lblTypeExam);
			
		lblWay = new JLabel("Hình thức");
		lblWay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWay.setBounds(31, 51, 86, 25);
		getContentPane().add(lblWay);
		
		lblNumberQuestion = new JLabel("Số câu");
		lblNumberQuestion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumberQuestion.setBounds(31, 100, 86, 25);
		getContentPane().add(lblNumberQuestion);

		lblListQuestion = new JLabel("Danh sách câu hỏi trong đề");
		lblListQuestion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblListQuestion.setBounds(31, 227, 210, 25);
		getContentPane().add(lblListQuestion);
		
		lblTime = new JLabel("Thời gian");
		lblTime.setBounds(31, 680, 75, 16);
		getContentPane().add(lblTime);
		
		lblInfomationExam = new JLabel("Thông tin về đề thi");
		lblInfomationExam.setBounds(31, 648, 161, 16);
		getContentPane().add(lblInfomationExam);
		
		lblMinute = new JLabel("phút");
		lblMinute.setBounds(242, 680, 83, 16);
		getContentPane().add(lblMinute);
		
		lblSeason = new JLabel("Kỳ");
		lblSeason.setBounds(31, 762, 83, 16);
		getContentPane().add(lblSeason);
		
		lblYear= new JLabel("Năm học");
		lblYear.setBounds(31, 726, 75, 16);
		getContentPane().add(lblYear);
		
		lblExport = new JLabel("<html><u>Xuất ra file</u></html>");
		lblExport.setForeground(Color.BLUE);
		lblExport.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblExport.setBounds(762, 661, 83, 22);
		getContentPane().add(lblExport);
		
		radioGeneral = new JRadioButton("Trắc nghiệm");
		radioGeneral.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radioGeneral.setBounds(137, 14, 127, 25);
		getContentPane().add(radioGeneral);
		
		radioEssay = new JRadioButton("Tự luận");
		radioEssay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radioEssay.setBounds(268, 14, 104, 25);
		getContentPane().add(radioEssay);
		
		radioAll = new JRadioButton("Cả trắc nghiệm và tự luận");
		radioAll.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radioAll.setBounds(386, 13, 211, 25);
		getContentPane().add(radioAll);
		
		radioGeneral = new JRadioButton("Trắc nghiệm và tự luận chung");
		radioGeneral.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radioGeneral.setBounds(137, 52, 235, 25);
		getContentPane().add(radioGeneral);
		
		radioSpecific = new JRadioButton("Trắc nghiệm và tự luận riêng");
		radioSpecific.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radioSpecific.setBounds(386, 52, 235, 25);
		getContentPane().add(radioSpecific);
		
		radioSeason1 = new JRadioButton("1");
		radioSeason1.setBounds(109, 758, 57, 25);
		getContentPane().add(radioSeason1);
		
		radioSeason2 = new JRadioButton("2");
		radioSeason2.setBounds(168, 758, 57, 25);
		getContentPane().add(radioSeason2);
		
		radionSummer = new JRadioButton("Hè");
		radionSummer.setBounds(232, 758, 127, 25);
		getContentPane().add(radionSummer);
		
		spinnerQuestionNumber = new JSpinner();
		spinnerQuestionNumber.setBounds(137, 102, 104, 22);
		getContentPane().add(spinnerQuestionNumber);
		
		
		cbbLevel = new JComboBox<>();
		cbbLevel.setBounds(137, 137, 104, 22);
		cbbLevel.addItem("1");
		cbbLevel.addItem("2");
		cbbLevel.addItem("3");
		cbbLevel.addItem("4");
		cbbLevel.addItem("5");
		getContentPane().add(cbbLevel);
		
		
		btnCreateExam = new JButton("Tạo đề thi");
		btnCreateExam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				time=Integer.parseInt(txtMinutes.getText());
				year=Integer.parseInt(txtYear.getText());
				doKho=Integer.parseInt(cbbLevel.getSelectedItem().toString());
				soCau=Integer.parseInt(spinnerQuestionNumber.getValue().toString());
				list= listC(listChoice, subject,doKho);		
				
				int soChap=1;	
				int soCauMoiChapExam=soCau/soChap;
				int soCauChapCuoi=soCau-soCauMoiChapExam*soChap;
				if(radioGeneral.isSelected())
				{
					radioEssay.setSelected(false);
					radioAll.setSelected(false);
					for(int i=1;i<=soChap;i++){
						ChoiceQuestion question=new ChoiceQuestion();
						ArrayList<Integer> listInt=new ArrayList<>();
						int soCauHoi=0;
						
						if(i==soChap) soCauHoi=soCauChapCuoi;
						else soCauHoi =soCauMoiChapExam;
						
						for(int j=0;j<soCauHoi;j++)
						{
							int radom=random(0,list.get(i-1).size()-1);
							if(listInt.size() !=0){
								if(checkNum(listInt, radom)){
									question=list.get(i-1).get(radom);
									listChoiceExam.add(question);
									listInt.add(radom);
								}
							}
							else{
								question=list.get(i-1).get(radom);
								listChoiceExam.add(question);
								listInt.add(radom);
								}
					}
				}
					
						loadListQuestion(listChoiceExam,null, dtm);
						loadContenExam(listChoiceExam, null, txtPaneExam);
					
					
				}
				else if(radioEssay.isSelected()){
					radioAll.setSelected(false);
					radioGeneral.setSelected(false);
					QuizQuestion question=new QuizQuestion();
					ArrayList<Integer> listInt=new ArrayList<>();
					for(int j=0;j<soCau;j++)
					{
						int radom=random(0,listQuiz.size()-1);
						if(listInt.size() !=0){
							if(checkNum(listInt, radom)){
								question=listQuiz.get(radom);
								listQuizExam.add(question);
								listInt.add(radom);
							}
						}
						else{
							question=listQuiz.get(radom);
							listQuizExam.add(question);
							listInt.add(radom);
							}
				}
					loadListQuestion(null,listQuizExam, dtm);
					loadContenExam(null,listQuizExam, txtPaneExam);
				}
				if(radioAll.isSelected()){
					radioEssay.setSelected(false);
					radioGeneral.setSelected(false);
					int soCauTN=(int) (soCau*0.8);
					int soCauMoiChapExamTN=soCauTN/soChap;
					int soCauChapCuoiTN=soCauTN-soCauMoiChapExamTN*soChap;
					int soCauTL=soCau-soCauTN;
					for(int i=1;i<=soChap;i++){
						ChoiceQuestion question=new ChoiceQuestion();
						ArrayList<Integer> listInt=new ArrayList<>();
						int soCauHoi=0;
						
						if(i==soChap) soCauHoi=soCauChapCuoiTN;
						else soCauHoi =soCauMoiChapExamTN;
						
						for(int j=0;j<soCauHoi;j++)
						{
							int radom=random(0,list.get(i).size()-1);
							if(listInt.size() !=0){
								if(checkNum(listInt, radom)){
									question=list.get(i).get(radom);
									listChoiceExam.add(question);
									listInt.add(radom);
								}
							}
							else{
								question=list.get(i).get(radom);
								listChoiceExam.add(question);
								listInt.add(radom);
								}
					}
				}
					
					QuizQuestion question=new QuizQuestion();
					ArrayList<Integer> listInt=new ArrayList<>();
					for(int j=0;j<soCauTL;j++)
					{
						int radom=random(0,list.size()-1);
						if(listInt.size() !=0){
							if(checkNum(listInt, radom)){
								question=listQuiz.get(radom);
								listQuizExam.add(question);
								listInt.add(radom);
							}
						}
						else{
							question=listQuiz.get(radom);
							listQuizExam.add(question);
							listInt.add(radom);
							}
				}
					
					loadListQuestion(listChoiceExam, listQuizExam, dtm);
					loadContenExam(listChoiceExam,listQuizExam, txtPaneExam);
					
				}
				
			}
			});
		btnCreateExam.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCreateExam.setBounds(613, 227, 127, 33);
		getContentPane().add(btnCreateExam);
		
		btnDelete = new JButton("Xóa đề thi");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(Color.RED);
		btnDelete.setBounds(687, 710, 121, 40);
		getContentPane().add(btnDelete);
		
		btnSave = new JButton("Lưu đề thi");
		btnSave.setForeground(Color.WHITE);
		btnSave.setBackground(Color.BLUE);
		btnSave.setBounds(445, 710, 121, 40);
		getContentPane().add(btnSave);
	
		
		
		txtMinutes = new JTextField();
		txtMinutes.setColumns(10);
		txtMinutes.setBackground(Color.WHITE);
		txtMinutes.setBounds(109, 677, 116, 22);
		txtMinutes.setText("45");
		getContentPane().add(txtMinutes);
		
		
		txtYear = new JTextField();
		txtYear.setColumns(10);
		txtYear.setBackground(Color.WHITE);
		txtYear.setBounds(109, 727, 116, 22);
		txtYear.setText("2017");
		getContentPane().add(txtYear);
		
		txtPaneExam = new JTextPane();
		txtPaneExam.setText("adsa\r\ndsa\r\nd\r\nd\r\nd\r\nd\r\nd\r\nd\r\nd\r\nd\r\nd\r\nd\r\nd\r\nd\r\nd\r\nd\r\nd\r\nd\r\nd\r\nd\r\nd\r\nd\r\nd\r\nd\r\nđ\r\nd\r\n\r\nđ\r\nd\r\nd\r\nd\r\nd\r\nd\r\nd\r\n\r\nd\r\nđ\r\nd\r\nd\r\nd\r\nd\r\nd\r\nd\r\nd\r\nd");
		txtPaneExam.setBounds(417, 273, 417, 367);
		getContentPane().add(txtPaneExam); 
		// chỗ này adđ scrooll pane vào rồi mà??
		scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 275, 314, 254);
		getContentPane().add(scrollPane);
		
		tableListQuestion = new JTable();
		tableListQuestion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				index=tableListQuestion.getSelectedRow();
				
				
			}
		});
		dtm=new DefaultTableModel(
				new Object[][] {
					{null},
				},
				new String[] {
					"New column"
				}
			);
		tableListQuestion.setModel(dtm);
		scrollPane.setViewportView(tableListQuestion);
		
		JButton btnThayTh = new JButton("Thay thế");
		btnThayTh.setForeground(Color.WHITE);
		btnThayTh.setBackground(Color.BLUE);
		btnThayTh.setBounds(28, 542, 116, 40);
		getContentPane().add(btnThayTh);
		
		JButton btnXaCuHi = new JButton("Xóa câu hỏi");
		btnXaCuHi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(radioGeneral.isSelected()){
					listChoiceExam.remove(index);
					loadListQuestion(listChoiceExam,null, dtm);
					loadContenExam(listChoiceExam, null, txtPaneExam);
				}
				else if(radioEssay.isSelected()){
					listQuizExam.remove(index);
					loadListQuestion(null,listQuizExam, dtm);
					loadContenExam(null,listQuizExam, txtPaneExam);
				}
				else if(radioAll.isSelected()){
					if(index<listChoiceExam.size()){
						listChoiceExam.remove(index);
					}
					else{
						int indexQ=index-listChoiceExam.size();
						listQuizExam.remove(indexQ);
					}
					loadListQuestion(listChoiceExam, listQuizExam, dtm);
					loadContenExam(listChoiceExam,listQuizExam, txtPaneExam);
				}
			}
		});
		btnXaCuHi.setForeground(Color.WHITE);
		btnXaCuHi.setBackground(Color.RED);
		btnXaCuHi.setBounds(224, 542, 121, 40);
		getContentPane().add(btnXaCuHi);
		
		JLabel lblKh = new JLabel("Độ khó");
		lblKh.setBounds(31, 141, 46, 14);
		getContentPane().add(lblKh);
		
		
	}
}


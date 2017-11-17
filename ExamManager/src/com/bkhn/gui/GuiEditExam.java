package com.bkhn.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import com.bkhn.interfacecommon.ICommonGui;


public class GuiEditExam extends JFrame implements ICommonGui{

	private static final int WIDTH_FRAME = 908;
	private static final int HEIGHT_FRAME = 970;
	private JLabel lblListQuestion;
	private JScrollPane scrollPane;
	private JTable tableListQuestion;
	private JTextPane txtPaneInformationQuestion;
	private JButton btnChooseRandomQuestion;
	private JLabel lblPointQuestion;
	private JTextField txtPointQuestion;
	private JButton btnAddToExam;
	private JLabel lblTypeQuestion;
	private JRadioButton radioAll;
	private JRadioButton radioMulti;
	private JRadioButton radioEssay;
	private JLabel lblListQuestionInExam;
	private JScrollPane scrollPane_1;
	private JTable tableListQuestionInExam;
	private JLabel lblInformationExam;
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
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	private JButton btnThayCuHi;
	private JButton btnXaCuHi;

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

	@Override
	public void addComps() {
		lblListQuestion = new JLabel("Danh sách câu hỏi");
		lblListQuestion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblListQuestion.setBounds(12, 13, 148, 22);
		getContentPane().add(lblListQuestion);
		
		lblPointQuestion = new JLabel("Điểm cho câu hỏi");
		lblPointQuestion.setBounds(433, 387, 116, 22);
		getContentPane().add(lblPointQuestion);
		
		lblTypeQuestion = new JLabel("Dạng câu hỏi");
		lblTypeQuestion.setBounds(22, 390, 116, 16);
		getContentPane().add(lblTypeQuestion);
		
		lblListQuestionInExam = new JLabel("Danh sách câu hỏi trong đề");
		lblListQuestionInExam.setBounds(22, 449, 194, 16);
		getContentPane().add(lblListQuestionInExam);
		
		lblInformationExam = new JLabel("Thông tin về đề thi");
		lblInformationExam.setBounds(12, 731, 161, 16);
		getContentPane().add(lblInformationExam);
		
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
		
		btnChooseRandomQuestion = new JButton("Chọn câu hỏi ngẫu nhiên");
		btnChooseRandomQuestion.setBounds(161, 343, 220, 25);
		getContentPane().add(btnChooseRandomQuestion);
		
		btnAddToExam = new JButton("Thêm vào đề thi");
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
		radioAll.setBounds(12, 415, 83, 25);
		getContentPane().add(radioAll);
		
		radioMulti = new JRadioButton("Trắc nghiệm");
		radioMulti.setBounds(100, 415, 116, 25);
		getContentPane().add(radioMulti);
		
		radioEssay = new JRadioButton("Tự luận");
		radioEssay.setBounds(220, 415, 127, 25);
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
		scrollPane.setBounds(22, 64, 359, 266);
		getContentPane().add(scrollPane);
		
		tableListQuestion = new JTable();
		tableListQuestion.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column"
			}
		));
		tableListQuestion.setForeground(Color.WHITE);
		scrollPane.setViewportView(tableListQuestion);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(16, 490, 365, 172);
		getContentPane().add(scrollPane_1);
		
		tableListQuestionInExam = new JTable();
		tableListQuestionInExam.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
			},
			new String[] {
				"New column"
			}
		));
		scrollPane_1.setViewportView(tableListQuestionInExam);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(433, 33, 440, 340);
		getContentPane().add(scrollPane_2);
		
		txtPaneInformationQuestion = new JTextPane();
		scrollPane_2.setViewportView(txtPaneInformationQuestion);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(444, 484, 427, 321);
		getContentPane().add(scrollPane_3);
		
		txtPaneInformationExam = new JTextPane();
		scrollPane_3.setViewportView(txtPaneInformationExam);
		
		btnThayCuHi = new JButton("Thay câu hỏi");
		btnThayCuHi.setForeground(Color.WHITE);
		btnThayCuHi.setBackground(Color.BLUE);
		btnThayCuHi.setBounds(17, 678, 121, 40);
		getContentPane().add(btnThayCuHi);
		
		btnXaCuHi = new JButton("Xóa câu hỏi");
		btnXaCuHi.setForeground(Color.WHITE);
		btnXaCuHi.setBackground(Color.RED);
		btnXaCuHi.setBounds(260, 675, 121, 40);
		getContentPane().add(btnXaCuHi);
		
	}

}

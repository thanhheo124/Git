package com.bkhn.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import com.bkhn.gui.interfacecommon.ICommonGui;

@SuppressWarnings("serial")
public class GuiCreatExamAuto extends JFrame implements ICommonGui{

	
	private static final int WIDTH_FRAME = 908;
	private static final int HEIGHT_FRAME = 870;
	private JLabel lblTypeExam;
	private JRadioButton radioGeneral;
	private JRadioButton radioEssay;
	private JComponent radioAll;
	private JLabel lblWay;
	private JRadioButton radioSpecific;
	private JLabel lblNumberQuestion;
	private JLabel lblChapter1;
	private Component lblChapter2;
	private JLabel lblChapter3;
	private JSpinner spinnerQuestionNumber;
	private JComboBox<String> cbbLevel;
	private JCheckBox checkLevel;
	private JCheckBox checkNumberQuesOfChapter;
	private JSpinner spinnerChapter1;
	private JSpinner spinnerChapter2;
	private JSpinner spinnerChapter3;
	private JButton btnCreateExam;
	private JButton btnDelete;
	private JButton btnSave;
	private JLabel lblListQuestion;
	private JScrollPane scrollPane;
	private JTable tableListQuestion;
	private JLabel lblMixQuestion;
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

	public GuiCreatExamAuto() {
		init();
		addComps();
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
		lblTypeExam = new JLabel("Dạng đề thi");
		lblTypeExam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTypeExam.setBounds(31, 13, 86, 25);
		add(lblTypeExam);
		
		lblWay = new JLabel("Hình thức");
		lblWay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWay.setBounds(31, 51, 86, 25);
		add(lblWay);
		
		lblNumberQuestion = new JLabel("Số câu");
		lblNumberQuestion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumberQuestion.setBounds(31, 100, 86, 25);
		add(lblNumberQuestion);
		
		lblChapter1 = new JLabel("Chương 1");
		lblChapter1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblChapter1.setBounds(578, 100, 86, 25);
		add(lblChapter1);
		
		lblChapter2 = new JLabel("Chương 2");
		lblChapter2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblChapter2.setBounds(578, 138, 86, 25);
		add(lblChapter2);
		
		lblChapter3 = new JLabel("Chương 3");
		lblChapter3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblChapter3.setBounds(578, 176, 86, 25);
		add(lblChapter3);

		lblListQuestion = new JLabel("Danh sách câu hỏi trong đề");
		lblListQuestion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblListQuestion.setBounds(31, 227, 210, 25);
		add(lblListQuestion);
		
		lblTime = new JLabel("Thời gian");
		lblTime.setBounds(31, 680, 75, 16);
		add(lblTime);
		
		lblInfomationExam = new JLabel("Thông tin về đề thi");
		lblInfomationExam.setBounds(31, 648, 161, 16);
		add(lblInfomationExam);
		
		lblMinute = new JLabel("phút");
		lblMinute.setBounds(242, 680, 83, 16);
		add(lblMinute);
		
		lblSeason = new JLabel("Kỳ");
		lblSeason.setBounds(31, 762, 83, 16);
		add(lblSeason);
		
		lblYear= new JLabel("Năm học");
		lblYear.setBounds(31, 726, 75, 16);
		add(lblYear);
		
		lblExchangeQuestion = new JLabel("<html><u>Thay thế bằng câu hỏi tương đương</u></html>");
		lblExchangeQuestion.setForeground(Color.BLUE);
		lblExchangeQuestion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblExchangeQuestion.setBounds(109, 542, 238, 22);
		add(lblExchangeQuestion);
		
		lblDeleteQuestionInExam = new JLabel("<html><u>Xóa câu hỏi khỏi đề thi</u></html>");
		lblDeleteQuestionInExam.setForeground(Color.RED);
		lblDeleteQuestionInExam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDeleteQuestionInExam.setBounds(197, 577, 148, 22);
		add(lblDeleteQuestionInExam);
		
		lblMixQuestion = new JLabel("<html><u>Xáo trộn các câu hỏi</u></html>");
		lblMixQuestion.setForeground(Color.BLUE);
		lblMixQuestion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMixQuestion.setBounds(428, 661, 148, 22);
		add(lblMixQuestion);
		
		lblPrint = new JLabel("<html><u>In</u></html>");
		lblPrint.setForeground(Color.BLUE);
		lblPrint.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrint.setBounds(653, 661, 35, 22);
		add(lblPrint);
		
		lblExport = new JLabel("<html><u>Xuất ra file</u></html>");
		lblExport.setForeground(Color.BLUE);
		lblExport.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblExport.setBounds(762, 661, 83, 22);
		add(lblExport);
		
		radioGeneral = new JRadioButton("Trắc nghiệm");
		radioGeneral.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radioGeneral.setBounds(137, 14, 127, 25);
		add(radioGeneral);
		
		radioEssay = new JRadioButton("Tự luận");
		radioEssay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radioEssay.setBounds(268, 14, 104, 25);
		add(radioEssay);
		
		radioAll = new JRadioButton("Cả trắc nghiệm và tự luận");
		radioAll.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radioAll.setBounds(386, 13, 211, 25);
		add(radioAll);
		
		radioGeneral = new JRadioButton("Trắc nghiệm và tự luận chung");
		radioGeneral.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radioGeneral.setBounds(137, 52, 235, 25);
		add(radioGeneral);
		
		radioSpecific = new JRadioButton("Trắc nghiệm và tự luận riêng");
		radioSpecific.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radioSpecific.setBounds(386, 52, 235, 25);
		add(radioSpecific);
		
		radioSeason1 = new JRadioButton("1");
		radioSeason1.setBounds(109, 758, 57, 25);
		add(radioSeason1);
		
		radioSeason2 = new JRadioButton("2");
		radioSeason2.setBounds(168, 758, 57, 25);
		add(radioSeason2);
		
		radionSummer = new JRadioButton("Hè");
		radionSummer.setBounds(232, 758, 127, 25);
		add(radionSummer);
		
		spinnerQuestionNumber = new JSpinner();
		spinnerQuestionNumber.setBounds(137, 102, 104, 22);
		add(spinnerQuestionNumber);
		

		spinnerChapter1 = new JSpinner();
		spinnerChapter1.setBounds(676, 102, 64, 22);
		add(spinnerChapter1);
		
		spinnerChapter2 = new JSpinner();
		spinnerChapter2.setBounds(676, 137, 64, 22);
		add(spinnerChapter2);
		
		spinnerChapter3 = new JSpinner();
		spinnerChapter3.setBounds(676, 178, 64, 22);
		add(spinnerChapter3);
		
		
		cbbLevel = new JComboBox<>();
		cbbLevel.setBounds(137, 137, 104, 22);
		add(cbbLevel);
		
		checkLevel = new JCheckBox("Độ khó");
		checkLevel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		checkLevel.setBounds(31, 136, 100, 25);
		add(checkLevel);
		
		checkNumberQuesOfChapter = new JCheckBox("Số lượng câu hỏi mỗi chương");
		checkNumberQuesOfChapter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		checkNumberQuesOfChapter.setBounds(342, 100, 228, 25);
		add(checkNumberQuesOfChapter);
		
		
		btnCreateExam = new JButton("Tạo đề thi");
		btnCreateExam.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCreateExam.setBounds(613, 227, 127, 33);
		add(btnCreateExam);
		
		btnDelete = new JButton("Xóa đề thi");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(Color.RED);
		btnDelete.setBounds(687, 710, 121, 40);
		add(btnDelete);
		
		btnSave = new JButton("Lưu đề thi");
		btnSave.setForeground(Color.WHITE);
		btnSave.setBackground(Color.BLUE);
		btnSave.setBounds(445, 710, 121, 40);
		add(btnSave);
	
		
		
		txtMinutes = new JTextField();
		txtMinutes.setColumns(10);
		txtMinutes.setBackground(Color.WHITE);
		txtMinutes.setBounds(109, 677, 116, 22);
		add(txtMinutes);
		
		
		txtYear = new JTextField();
		txtYear.setColumns(10);
		txtYear.setBackground(Color.WHITE);
		txtYear.setBounds(109, 727, 116, 22);
		add(txtYear);
		
		txtPaneExam = new JTextPane();
		txtPaneExam.setBounds(428, 273, 417, 367);
		add(txtPaneExam);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 275, 314, 254);
		add(scrollPane);
		
		tableListQuestion = new JTable();
		tableListQuestion.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
			},
			new String[] {
				"New column"
			}
		));
		scrollPane.setViewportView(tableListQuestion);
		
		
		
		
		
		
	}
	
}

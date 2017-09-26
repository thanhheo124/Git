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
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import com.bkhn.gui.interfacecommon.ICommonGui;

public class GuiEditQuestion extends JFrame implements ICommonGui{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int WIDTH_FRAME = 800;
	private static final int HEIGHT_FRAME = 700;
	private JLabel lblListQuestion;
	private JLabel lblAddQuestion;
	private JLabel lblTypeQuestion;
	private JLabel lblContentQuestion;
	private JRadioButton rdMultipleChoice;
	private JRadioButton rdEssay;
	private JScrollPane scrollPane_1;
	private JTextPane txPaneContentQues;
	private JLabel lblChoiceAnswer;
	private JScrollPane scrollPane_2;
	private JTable tableLisQuestion;
	private JLabel lblAdd;
	private JComponent lblEdit;
	private JLabel lblDelete;
	private JLabel lblLevel;
	private JLabel lblChapter;
	private JScrollPane scrollPane_3;
	private JTable tableAnswer;
	private JButton btnOk;
	private JButton btnCancel;
	private JButton btnDelete;
	private JButton btnSave;
	private JButton btnChangeQuestion;
	private JComboBox<String> cbbChapter;
	private JComboBox<String> cbbLevel;
	private JComponent lblQuestionSame;
	private Component checkCanMixQuestion;

	public GuiEditQuestion() {
		init();
		addComps();
	}
	
	@Override
	public void init() {
		setTitle("Chọn môn học");
		setSize(WIDTH_FRAME, HEIGHT_FRAME);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
	}

	@Override
	public void addComps() {
		lblListQuestion = new JLabel("Danh sách câu hỏi");
		lblListQuestion.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblListQuestion.setBounds(56, 29, 138, 26);
		add(lblListQuestion);
		
		lblAddQuestion = new JLabel("<html><u>Thêm câu hỏi</u><html>");
		lblAddQuestion.setForeground(Color.BLUE);
		lblAddQuestion.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddQuestion.setBounds(56, 455, 114, 26);
		add(lblAddQuestion);
		
		lblTypeQuestion = new JLabel("Dạng câu hỏi");
		lblTypeQuestion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTypeQuestion.setBounds(338, 68, 104, 17);
		add(lblTypeQuestion);
		
		lblContentQuestion = new JLabel("Đề bài");
		lblContentQuestion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContentQuestion.setBounds(338, 114, 104, 17);
		add(lblContentQuestion);
		
		lblChoiceAnswer = new JLabel("Các lựa chọn đáp án");
		lblChoiceAnswer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChoiceAnswer.setBounds(338, 264, 162, 17);
		add(lblChoiceAnswer);
		
		lblAdd = new JLabel("<html><u>Thêm</u><html>");
		lblAdd.setForeground(Color.BLUE);
		lblAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAdd.setBounds(410, 455, 114, 26);
		add(lblAdd);
		
		lblEdit = new JLabel("<html><u>Chỉnh sửa</u><html>");
		lblEdit.setForeground(Color.BLUE);
		lblEdit.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEdit.setBounds(516, 455, 114, 26);
		add(lblEdit);
		
		lblDelete = new JLabel("<html><u>Xóa</u><html>");
		lblDelete.setForeground(Color.RED);
		lblDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDelete.setBounds(656, 455, 114, 26);
		add(lblDelete);
		
		lblLevel = new JLabel("Độ khó");
		lblLevel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLevel.setBounds(33, 494, 84, 26);
		add(lblLevel);

		lblChapter = new JLabel("Chương");
		lblChapter.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblChapter.setBounds(409, 494, 84, 26);
		add(lblChapter);
		
		lblQuestionSame = new JLabel("Câu hỏi tương đương");
		lblQuestionSame.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQuestionSame.setBounds(409, 534, 148, 26);
		add(lblQuestionSame);
		
		rdEssay = new JRadioButton("Tự luận");
		rdEssay.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdEssay.setBounds(590, 65, 127, 25);
		add(rdEssay);
		
		rdMultipleChoice = new JRadioButton("Trắc nghiệm");
		rdMultipleChoice.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdMultipleChoice.setBounds(459, 65, 127, 25);
		add(rdMultipleChoice);
		
		
		checkCanMixQuestion = new JCheckBox("Có thể xáo trộn được");
		checkCanMixQuestion.setForeground(Color.BLUE);
		checkCanMixQuestion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		checkCanMixQuestion.setBounds(500, 261, 182, 25);
		add(checkCanMixQuestion);
		
		
		cbbLevel = new JComboBox<>();
		cbbLevel.setBounds(156, 497, 156, 22);
		add(cbbLevel);
		
		
		cbbChapter = new JComboBox<>();
		cbbChapter.setBounds(595, 494, 156, 22);
		add(cbbChapter);
		
		btnChangeQuestion = new JButton("......");
		btnChangeQuestion.setBounds(592, 533, 38, 31);
		add(btnChangeQuestion);
		
		btnSave = new JButton("Lưu\r\n");
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSave.setBounds(43, 577, 97, 31);
		add(btnSave);
		
		btnCancel = new JButton("Hủy");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancel.setBounds(232, 577, 97, 31);
		add(btnCancel);
		
		btnDelete = new JButton("Xóa");
		btnDelete.setBackground(Color.RED);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBounds(416, 577, 97, 31);
		add(btnDelete);
		
		btnOk = new JButton("OK");
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnOk.setBounds(585, 577, 97, 31);
		add(btnOk);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(409, 123, 344, 128);
		add(scrollPane_1);
		
		txPaneContentQues = new JTextPane();
		txPaneContentQues.setText("dsa\r\nấdsddddđ\r\nAaaaaaaaaaaaaaaaaaa\r\nddddddddd\r\nDddddddddd\r\ndddddddddddd\r\ndddddđ\r\nddddddddddddd\r\ndddddddddddđ\r\nDdddddddddddddđ\r\ndddddddddddddddđ\r\ndddddd");
		scrollPane_1.setViewportView(txPaneContentQues);
		
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(409, 294, 342, 146);
		add(scrollPane_2);
		
		tableLisQuestion = new JTable();
		tableLisQuestion.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
				{null},
				{null},
			},
			new String[] {
				"New column"
			}
		));
		scrollPane_2.setColumnHeaderView(tableLisQuestion);
		
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(33, 68, 279, 346);
		add(scrollPane_3);
		
		tableAnswer = new JTable();
		tableAnswer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableAnswer.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
			},
			new String[] {
				"New column"
			}
		));
		scrollPane_3.setColumnHeaderView(tableAnswer);
	}
	
}

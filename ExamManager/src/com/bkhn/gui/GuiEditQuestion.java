package com.bkhn.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.bkhn.common.Common;
import com.bkhn.interfacecommon.ICommonGui;
import com.bkhn.interfacecommon.IManagerQuestion;
import com.bkhn.model.ChoiceQuestion;
import com.bkhn.model.Question;
import com.bkhn.model.QuizQuestion;

public class GuiEditQuestion extends JFrame implements ICommonGui, ActionListener {

	/**
	 * 
	 */
	private ArrayList<QuizQuestion> listQuizQuestion;
	private ArrayList<ChoiceQuestion> listChoiceQuestion;
	private static final long serialVersionUID = 1L;
	private static final int WIDTH_FRAME = 800;
	private static final int HEIGHT_FRAME = 700;
	private static final String ESSAY = "Essay";
	private static final String MULTICHOICE = "Multichoice";
	private static final int TABLEQUESTION_SOCOT = 1;
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
	private JTable tableAnswer;
	private JLabel lblAdd;
	private JComponent lblEdit;
	private JLabel lblDelete;
	private JLabel lblLevel;
	private JLabel lblChapter;
	private JScrollPane scrollPane_3;
	private JTable tableQuestion;
	private JButton btnOk;
	private JButton btnCancel;
	private JButton btnDelete;
	private JButton btnSave;
	private JButton btnChangeQuestion;
	private JComboBox<String> cbbChapter;
	private JComboBox<String> cbbLevel;
	private JComponent lblQuestionSame;
	private Component checkCanMixQuestion;
	private JTextPane txPaneAnswerQuiz;

	private IManagerQuestion m_ownerQuetion;

	private int id_CH = 0;
	private String nameSubject = "";

	public GuiEditQuestion() {
		init();
		addComps();
		showcbbLevel();
		showcbbChapter();
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
		getContentPane().add(lblListQuestion);

		lblAddQuestion = new JLabel("<html><u>Thêm câu hỏi</u><html>");
		lblAddQuestion.setForeground(Color.BLUE);
		lblAddQuestion.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddQuestion.setBounds(56, 455, 114, 26);
		getContentPane().add(lblAddQuestion);

		lblTypeQuestion = new JLabel("Dạng câu hỏi");
		lblTypeQuestion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTypeQuestion.setBounds(338, 68, 104, 17);
		getContentPane().add(lblTypeQuestion);

		lblContentQuestion = new JLabel("Đề bài");
		lblContentQuestion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContentQuestion.setBounds(338, 114, 104, 17);
		getContentPane().add(lblContentQuestion);

		lblChoiceAnswer = new JLabel("Các lựa chọn đáp án");
		lblChoiceAnswer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChoiceAnswer.setBounds(338, 264, 162, 17);
		getContentPane().add(lblChoiceAnswer);

		lblAdd = new JLabel("<html><u>Thêm</u><html>");
		lblAdd.setForeground(Color.BLUE);
		lblAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAdd.setBounds(410, 455, 114, 26);
		getContentPane().add(lblAdd);

		lblEdit = new JLabel("<html><u>Chỉnh sửa</u><html>");
		lblEdit.setForeground(Color.BLUE);
		lblEdit.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEdit.setBounds(516, 455, 114, 26);
		getContentPane().add(lblEdit);

		lblDelete = new JLabel("<html><u>Xóa</u><html>");
		lblDelete.setForeground(Color.RED);
		lblDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDelete.setBounds(656, 455, 114, 26);
		getContentPane().add(lblDelete);

		lblLevel = new JLabel("Độ khó");
		lblLevel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLevel.setBounds(33, 494, 84, 26);
		getContentPane().add(lblLevel);

		lblChapter = new JLabel("Chương");
		lblChapter.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblChapter.setBounds(409, 494, 84, 26);
		getContentPane().add(lblChapter);

		lblQuestionSame = new JLabel("Câu hỏi tương đương");
		lblQuestionSame.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQuestionSame.setBounds(409, 534, 148, 26);
		getContentPane().add(lblQuestionSame);

		rdEssay = new JRadioButton("Tự luận");
		rdEssay.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdEssay.setBounds(590, 65, 127, 25);
		getContentPane().add(rdEssay);
		rdEssay.setActionCommand(ESSAY);
		rdEssay.addActionListener(this);

		rdMultipleChoice = new JRadioButton("Trắc nghiệm");
		rdMultipleChoice.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdMultipleChoice.setBounds(459, 65, 127, 25);
		getContentPane().add(rdMultipleChoice);
		rdMultipleChoice.setActionCommand(MULTICHOICE);
		rdMultipleChoice.addActionListener(this);

		checkCanMixQuestion = new JCheckBox("Có thể xáo trộn được");
		checkCanMixQuestion.setForeground(Color.BLUE);
		checkCanMixQuestion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		checkCanMixQuestion.setBounds(500, 261, 182, 25);
		getContentPane().add(checkCanMixQuestion);

		cbbLevel = new JComboBox<>();
		cbbLevel.setBounds(156, 497, 156, 22);
		getContentPane().add(cbbLevel);

		cbbChapter = new JComboBox<>();
		cbbChapter.setBounds(595, 494, 156, 22);
		getContentPane().add(cbbChapter);

		btnChangeQuestion = new JButton("......");
		btnChangeQuestion.setBounds(592, 533, 38, 31);
		getContentPane().add(btnChangeQuestion);

		btnSave = new JButton("Lưu\r\n");
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSave.setBounds(43, 577, 97, 31);
		getContentPane().add(btnSave);

		btnCancel = new JButton("Hủy");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancel.setBounds(232, 577, 97, 31);
		getContentPane().add(btnCancel);

		btnDelete = new JButton("Xóa");
		btnDelete.setBackground(Color.RED);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBounds(416, 577, 97, 31);
		getContentPane().add(btnDelete);

		btnOk = new JButton("OK");
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnOk.setBounds(585, 577, 97, 31);
		getContentPane().add(btnOk);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(409, 123, 344, 128);
		getContentPane().add(scrollPane_1);

		txPaneContentQues = new JTextPane();
		scrollPane_1.setViewportView(txPaneContentQues);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(409, 294, 342, 146);
		getContentPane().add(scrollPane_2);

		tableAnswer = new JTable();
		tableAnswer.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "List Answer" }));
		txPaneAnswerQuiz = new JTextPane();

		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(33, 68, 279, 346);
		getContentPane().add(scrollPane_3);

		tableQuestion = new JTable();
		tableQuestion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableQuestion.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "New column" }));
		scrollPane_3.setViewportView(tableQuestion);
		tableQuestion.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see java.awt.event.MouseAdapter#mouseClicked(java.awt.event.
			 * MouseEvent)
			 */
			@Override
			public void mouseClicked(MouseEvent event) {
				TableMouseClicked(event);
			}
		});
	}

	/**
	 * When click a row in table => show infor question in diferent component
	 * 
	 * @param event
	 */
	protected void TableMouseClicked(MouseEvent event) {
		int i = tableQuestion.getSelectedRow();
		TableModel model = tableQuestion.getModel();
		txPaneContentQues.setText(model.getValueAt(i, 0).toString());
		if (rdEssay.isSelected()) {
			for (int j = 0; j < listQuizQuestion.size(); j++) {
				id_CH = listQuizQuestion.get(i).getId();
				nameSubject = listQuizQuestion.get(i).getSubject();
				// Set data to form
				txPaneAnswerQuiz.setText(listQuizQuestion.get(j).getSuggestion());
				cbbLevel.setSelectedItem((listQuizQuestion.get(j).getLevel() + "").toString());
				cbbChapter.setSelectedItem((listQuizQuestion.get(i).getChapter() + "").toString());

				updateQuizQuestion();
				deleteQuestionQuiz();
			}
		} else {
			for (int j = 0; j < listChoiceQuestion.size(); j++) {
				DefaultTableModel modelTableAnswer = (DefaultTableModel) tableAnswer.getModel();
				modelTableAnswer.setRowCount(0);
				showTableAnswer(listChoiceQuestion.get(j));

				id_CH = listChoiceQuestion.get(i).getId();
				nameSubject = listChoiceQuestion.get(i).getSubject();

				// Set data to form
				cbbLevel.setSelectedItem((listChoiceQuestion.get(j).getLevel() + "").toString());
				cbbChapter.setSelectedItem((listChoiceQuestion.get(i).getChapter() + "").toString());

				deleteQuestionChoice();
			}
		}
	}

	/**
	 * 
	 */
	private void deleteQuestionChoice() {
		btnDelete.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see java.awt.event.MouseAdapter#mouseClicked(java.awt.event.
			 * MouseEvent)
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				ChoiceQuestion choiceQuestion = new ChoiceQuestion(id_CH, txPaneContentQues.getText(), nameSubject,
						Common.partInt((String) cbbChapter.getSelectedItem()),
						Common.partInt((String) cbbLevel.getSelectedItem()), null, null);

				if (m_ownerQuetion.deleteChoiceQuestion(choiceQuestion)) {
					JOptionPane.showMessageDialog(null, "Delete succes");
				}
			}
		});
	}

	/**
	 * @param choiceQuestion
	 */
	private void showTableAnswer(ChoiceQuestion choiceQuestion) {
		DefaultTableModel model = (DefaultTableModel) tableAnswer.getModel();
		Object[] row = new Object[TABLEQUESTION_SOCOT];
		for (int i = 0; i < choiceQuestion.getChoices().size(); i++) {
			row[0] = choiceQuestion.getChoices().get(i).toString();
			model.addRow(row);
		}
	}

	/**
	 * 
	 */
	private void deleteQuestionQuiz() {
		btnDelete.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see java.awt.event.MouseAdapter#mouseClicked(java.awt.
			 * event.MouseEvent)
			 */
			@Override
			public void mouseClicked(MouseEvent event) {
				QuizQuestion quizQuestion = new QuizQuestion(id_CH, txPaneContentQues.getText(), nameSubject,
						Common.partInt((String) cbbChapter.getSelectedItem()),
						Common.partInt((String) cbbLevel.getSelectedItem()), txPaneAnswerQuiz.getText());
				if (m_ownerQuetion.deleteQuizQuestion(quizQuestion)) {
					JOptionPane.showMessageDialog(null, "Delete Succes");
				}

			}
		});
	}

	/**
	 * 
	 */
	private void updateQuizQuestion() {
		lblEdit.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see java.awt.event.MouseAdapter#mouseClicked(java.awt.
			 * event.MouseEvent)
			 */
			@Override
			public void mouseClicked(MouseEvent event) {
				if (!conditionInsertQuestion()) {
					QuizQuestion quizQuestion = new QuizQuestion(id_CH, txPaneContentQues.getText(), nameSubject,
							Common.partInt((String) cbbChapter.getSelectedItem()),
							Common.partInt((String) cbbLevel.getSelectedItem()), txPaneAnswerQuiz.getText());
					if (m_ownerQuetion.upDateQuizQuestion(quizQuestion)) {
						JOptionPane.showMessageDialog(null, "Delete Thành công");
					}
				}

			}
		});
	}

	/**
	 * @param event
	 * @return
	 */
	protected boolean conditionInsertQuestion() {
		String textQues = txPaneContentQues.getText();
		if ("".equals(txPaneAnswerQuiz.getText()) || "".equals(txPaneContentQues.getText())) {
			JOptionPane.showMessageDialog(null, "Please insert data to form");
			return false;
		} else if (checkExistQuestiontoInsert(textQues)) {
			return false;
		}
		return true;
	}

	/**
	 * @param textQues
	 * @param textAnswer
	 * @return
	 */
	private boolean checkExistQuestiontoInsert(String textQues) {
		for (int i = 0; i < listQuizQuestion.size(); i++) {
			if (listChoiceQuestion.get(i).getContent().equals(textQues)) {
				JOptionPane.showMessageDialog(null, "question has existed in database");
				return true;
			}
		}
		return false;
	}

	/**
	 * @param event
	 */
	protected boolean conditionEditQuestion() {
		if ("".equals(txPaneAnswerQuiz.getText()) || "".equals(txPaneContentQues.getText())) {
			JOptionPane.showMessageDialog(null, "Please insert data to form");
			return false;
		} else if (checkExistQuestion(txPaneContentQues.getText(), txPaneAnswerQuiz.getText())) {
			return false;
		}
		return true;
	}

	/**
	 * @param text
	 * @return
	 */
	private boolean checkExistQuestion(String text, String textAnswer) {
		for (int i = 0; i < listQuizQuestion.size(); i++) {
			if (text.equals(listQuizQuestion.get(i).getContent().toString())) {
				if (textAnswer.equals(listQuizQuestion.get(i).getSuggestion().toString())) {
					JOptionPane.showMessageDialog(null, "Please change content suggestion data to form");
					return true;
				}
			} else {
				return true;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		String actionString = event.getActionCommand();

		switch (actionString) {
		case ESSAY: {
			scrollPane_2.setViewportView((txPaneAnswerQuiz));
			changeEventMulti("disable");
			checkCanMixQuestion.setVisible(false);
			rdEssay.setSelected(true);
			rdMultipleChoice.setSelected(false);
			DefaultTableModel model = (DefaultTableModel) tableQuestion.getModel();
			model.setRowCount(0);
			loadDataQuizQuestion(listQuizQuestion);
			insertQuestion();
		}
			break;

		case MULTICHOICE:
			scrollPane_2.setViewportView((tableAnswer));
			changeEventMulti("enable");
			lblAdd.setVisible(true);
			rdEssay.setSelected(false);
			rdMultipleChoice.setSelected(true);
			DefaultTableModel model = (DefaultTableModel) tableQuestion.getModel();
			model.setRowCount(0);
			loadDataChoiceQuestion(listChoiceQuestion);
			break;
		default:
			break;
		}
	}

	/**
	 * 
	 */
	private void insertQuestion() {
		lblAddQuestion.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see java.awt.event.MouseAdapter#mouseClicked(java.awt.event.
			 * MouseEvent)
			 */
			@Override
			public void mouseClicked(MouseEvent event) {
				QuizQuestion quizQuestion = new QuizQuestion(0, txPaneContentQues.getText(), nameSubject,
						Common.partInt((String) cbbChapter.getSelectedItem()),
						Common.partInt((String) cbbLevel.getSelectedItem()), txPaneAnswerQuiz.getText());
				if (m_ownerQuetion.insertQuizQuestion(quizQuestion)) {
					JOptionPane.showMessageDialog(null, "Insert success");
				}
			}
		});
	}

	/**
	 * @param string
	 */
	private void changeEventMulti(String event) {
		if (event.equals("enable")) {
			lblAdd.setVisible(true);
			lblDelete.setEnabled(true);
		} else {
			lblAdd.setVisible(false);
			lblDelete.setEnabled(false);
		}
	}

	/**
	 * @param listQuizQuestion2
	 */
	private void showcbbChapter() {
		cbbChapter.addItem(1 + "");
		cbbChapter.addItem(2 + "");
		cbbChapter.addItem(3 + "");
		cbbChapter.addItem(4 + "");
	}

	/**
	 * @param listQuizQuestion2
	 */
	private void showcbbLevel() {
		cbbLevel.addItem(1 + "");
		cbbLevel.addItem(2 + "");
		cbbLevel.addItem(3 + "");
		cbbLevel.addItem(4 + "");
	}

	/**
	 * to load data QuestionChoice to table Question
	 * 
	 * @param listChoiceQ
	 *            : list choiceQuestion
	 */
	private void loadDataChoiceQuestion(ArrayList<ChoiceQuestion> listChoiceQ) {
		DefaultTableModel model = (DefaultTableModel) tableQuestion.getModel();
		Object[] row = new Object[TABLEQUESTION_SOCOT];
		for (int i = 0; i < listChoiceQ.size(); i++) {
			row[0] = listChoiceQ.get(i).getContent();
			model.addRow(row);
		}
	}

	/**
	 * to load data QuestionChoice to table Question
	 * 
	 * @param listQuizQ
	 *            : list quiz Question
	 */
	private void loadDataQuizQuestion(ArrayList<QuizQuestion> listQuizQ) {
		DefaultTableModel model = (DefaultTableModel) tableQuestion.getModel();
		Object[] row = new Object[TABLEQUESTION_SOCOT];
		for (int i = 0; i < listQuizQ.size(); i++) {
			row[0] = listQuizQ.get(i).getContent();
			model.addRow(row);
		}
	}

	public ArrayList<QuizQuestion> getListQuizQuestion() {
		return listQuizQuestion;
	}

	public void setListQuizQuestion(ArrayList<QuizQuestion> listQuizQuestion) {
		this.listQuizQuestion = listQuizQuestion;
	}

	public ArrayList<ChoiceQuestion> getListChoiceQuestion() {
		return listChoiceQuestion;
	}

	public void setListChoiceQuestion(ArrayList<ChoiceQuestion> listChoiceQuestion) {
		this.listChoiceQuestion = listChoiceQuestion;
	}
}

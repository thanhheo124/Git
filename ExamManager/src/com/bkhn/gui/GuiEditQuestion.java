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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.bkhn.common.Common;
import com.bkhn.interfacecommon.ICommonGui;
import com.bkhn.interfacecommon.IEditChoice;
import com.bkhn.interfacecommon.IEditQuestion;
import com.bkhn.model.ChoiceQuestion;
import com.bkhn.model.QuizQuestion;

public class GuiEditQuestion extends JFrame implements ICommonGui, ActionListener, IEditChoice {

	/**
	 * 
	 */
	private ArrayList<QuizQuestion> listQuizQuestion;
	private ArrayList<ChoiceQuestion> listChoiceQuestion;
	ArrayList<String> listChoice = new ArrayList<>();
	private static final long serialVersionUID = 1L;
	private static final int WIDTH_FRAME = 800;
	private static final int HEIGHT_FRAME = 700;
	private static final String ESSAY = "Essay";
	private static final String MULTICHOICE = "Multichoice";
	private static final int TABLEQUESTION_SOCOT = 1;
	private static final String XOA = "Xoa";
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
	private ArrayList<String> currentChoices;
	private ArrayList<String> currentAnsews;
	private JTable tableQuestionQuiz;
	private JTable tableQuestionChoose;
	private EditChoice editChoice;

	private int posQuizQues = 0;
	private int posChoiceQues = 0;
	private IEditQuestion owner;
	
	public void setOwner(IEditQuestion owner) {
		this.owner = owner;
	}

	public GuiEditQuestion() {
		init();
		addComps();
		showcbbLevel();
		showcbbChapter();
		listChoiceQuestion = new ArrayList<ChoiceQuestion>();
		listQuizQuestion = new ArrayList<QuizQuestion>();
		currentChoices = new ArrayList<String>();
		currentAnsews = new ArrayList<String>();
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
		lblAddQuestion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				System.out.println("insertQuestionQuiz");
				QuizQuestion quizQuestion = new QuizQuestion(txPaneContentQues.getText(),
						Common.partInt((String) cbbChapter.getSelectedItem()),
						Common.partInt((String) cbbLevel.getSelectedItem()), txPaneAnswerQuiz.getText());
				listQuizQuestion.add(quizQuestion);
				loadDataQuizQuestionToGui();
				actionTableQuizQuestion();
				if(rdMultipleChoice.isSelected()) {//dang la mode cau hoi trac nghiem
					AddChoiceQuestionToList();
				}
			}
		});
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
		lblAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShowEditChoice(true);
				
			}
		});
		getContentPane().add(lblAdd);

		lblEdit = new JLabel("<html><u>Chỉnh sửa</u><html>");
		lblEdit.setForeground(Color.BLUE);
		lblEdit.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEdit.setBounds(516, 455, 114, 26);
		lblEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShowEditChoice(false);
				int i = tableAnswer.getSelectedRow();
				if(i>=0) {
					System.out.println(""+ currentChoices.get(i));
					editChoice.setStringChoice(currentChoices.get(i));
					for(int j=0; j<currentAnsews.size(); j++) {
						if(currentChoices.get(i).equals(currentAnsews.get(j))) {
							editChoice.setIsAnser(true);
							break;
						}
					}
				}
				editChoice.setIndex(i);
				editChoice.updateView();
			}
		});
		getContentPane().add(lblEdit);

		lblDelete = new JLabel("<html><u>Xóa</u><html>");
		lblDelete.setForeground(Color.RED);
		lblDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDelete.setBounds(656, 455, 114, 26);
		lblDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tableAnswer.getSelectedRow();
				System.out.println(i + " ps");
				if (i < currentChoices.size() && i >=0)
					currentChoices.remove(i);
				showTableAnswer(currentChoices);
			}
		});
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
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(owner != null)
					owner.onSaveQuestions();
				
			}
		});
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
		btnDelete.setActionCommand(XOA);
		btnDelete.addActionListener(this);

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

		tableQuestionQuiz = new JTable();
		tableQuestionQuiz.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableQuestionQuiz.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "New column" }));

		tableQuestionChoose = new JTable();
		tableQuestionChoose.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableQuestionChoose.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "New column" }));
	}

	/**
	 * 
	 */
	private void deleteQuestionChoice(ArrayList<ChoiceQuestion> liChoiceQuestions, int posChoiceQuestion) {
		liChoiceQuestions.remove(posChoiceQuestion);
		loadDataChoiceQuestion();
		actionTableChoiceQuestion();
		// done delete QuestionChoice
		// if
		// (m_ownerQuetion.deleteChoiceQuestion(liChoiceQuestions.get(posChoiceQuestion)))
		// {
		// JOptionPane.showMessageDialog(null, "Delete succes");
		// }
	}

	/**
	 * @param choiceQuestion
	 */
	private void showTableAnswer(ArrayList<String> choiceQuestion) {
		DefaultTableModel model = (DefaultTableModel) tableAnswer.getModel();
		model.setRowCount(0);
		Object[] row = new Object[TABLEQUESTION_SOCOT];
		for (int i = 0; i < choiceQuestion.size(); i++) {
			row[0] = choiceQuestion.get(i).toString();
			model.addRow(row);
		}
	}

	/**
	 * 
	 */
	private void updateQuizQuestion() {
		lblEdit.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see java.awt.event.MouseAdapter#mouseClicked(java.awt. event.MouseEvent)
			 */
			@Override
			public void mouseClicked(MouseEvent event) {
				QuizQuestion quizQuestion = new QuizQuestion();
				quizQuestion.setChapter(Common.partInt((String) cbbChapter.getSelectedItem()));
				quizQuestion.setContent(txPaneContentQues.getText());
				quizQuestion.setSuggestion(txPaneAnswerQuiz.getText());
				quizQuestion.setLevel(Common.partInt((String) cbbLevel.getSelectedItem()));

				listQuizQuestion.set(posQuizQues, quizQuestion);
				loadDataQuizQuestionToGui();
				actionTableQuizQuestion();
				// done edit

				// if (m_ownerQuetion.upDateQuizQuestion(quizQuestion)) {
				// JOptionPane.showMessageDialog(null, "Delete Thành công");
				// }

			}
		});
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
			scrollPane_3.setViewportView(tableQuestionQuiz);
			scrollPane_2.setViewportView((txPaneAnswerQuiz));
			changeEventMulti("disable");
			checkCanMixQuestion.setVisible(false);
			rdEssay.setSelected(true);
			rdMultipleChoice.setSelected(false);
			loadDataQuizQuestionToGui();
			actionTableQuizQuestion();
		}
			break;

		case MULTICHOICE: {
			scrollPane_3.setViewportView(tableQuestionChoose);
			scrollPane_2.setViewportView((tableAnswer));
			changeEventMulti("enable");
			lblAdd.setVisible(true);
			rdEssay.setSelected(false);
			rdMultipleChoice.setSelected(true);
			loadDataChoiceQuestion();
			actionTableChoiceQuestion();
		}
			break;

		case XOA:
			if (rdEssay.isSelected()) {
				deleteQuestionQuiz(listQuizQuestion, posQuizQues);
			} else {
				deleteQuestionChoice(listChoiceQuestion, posChoiceQues);
			}
		default:
			break;
		}
	}

	/**
	 * 
	 */
	private void actionTableChoiceQuestion() {
		tableQuestionChoose.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see java.awt.event.MouseAdapter#mouseClicked(java.awt.event. MouseEvent)
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tableQuestionChoose.getSelectedRow();
				currentChoices = listChoiceQuestion.get(i).getChoices();
				currentAnsews = listChoiceQuestion.get(i).getAnswers();
				TableModel model = tableQuestionChoose.getModel();
				txPaneContentQues.setText(model.getValueAt(i, 0).toString());
				showTableAnswer(currentChoices);
				cbbLevel.setSelectedItem((listChoiceQuestion.get(i).getLevel() + "").toString());
				cbbChapter.setSelectedItem((listChoiceQuestion.get(i).getChapter() + "").toString());
				posChoiceQues = i;
				updateChoiceQuestion();
				insertChoiseQuestion();

			}
		});

	}

	/**
	 * 
	 */
	protected void insertChoiseQuestion() {
		// liên quan đến giao điện khác chưa xử lý
	}

	/**
	 * 
	 */
	protected void updateChoiceQuestion() {
		// liên quan đến giao điện khác chưa xuwr lý
	}

	/**
	 * 
	 */
	private void loadDataChoiceQuestion() {
		DefaultTableModel model = (DefaultTableModel) tableQuestionChoose.getModel();
		model.setRowCount(0);
		loadDataChoiceQuestion(listChoiceQuestion);
	}

	/**
	 * 
	 */
	private void deleteQuestionQuiz(ArrayList<QuizQuestion> listQuizQuestion, int posQuizQues) {
		listQuizQuestion.remove(posQuizQues);
		loadDataQuizQuestionToGui();
		actionTableQuizQuestion();
		// done delete
	}

	/**
	 * 
	 */
	private void actionTableQuizQuestion() {
		tableQuestionQuiz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tableQuestionQuiz.getSelectedRow();
				TableModel model = tableQuestionQuiz.getModel();
				txPaneContentQues.setText(model.getValueAt(i, 0).toString());
				// // Set data to form
				txPaneAnswerQuiz.setText(listQuizQuestion.get(i).getSuggestion());
				cbbLevel.setSelectedItem((listQuizQuestion.get(i).getLevel() + "").toString());
				cbbChapter.setSelectedItem((listQuizQuestion.get(i).getChapter() + "").toString());
				posQuizQues = i;
				updateQuizQuestion();

			}
		});

	}

	/**
	 * 
	 */
	private void loadDataQuizQuestionToGui() {
		DefaultTableModel model = (DefaultTableModel) tableQuestionQuiz.getModel();
		model.setRowCount(0);
		loadDataQuizQuestion(listQuizQuestion);
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
		if(listChoiceQ.size() == 0)
			return;
		DefaultTableModel model = (DefaultTableModel) tableQuestionChoose.getModel();
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
		if(listQuizQ.size() == 0)
			return;
		DefaultTableModel model = (DefaultTableModel) tableQuestionQuiz.getModel();
		Object[] row = new Object[TABLEQUESTION_SOCOT];
		for (int i = 0; i < listQuizQ.size(); i++) {
			row[0] = listQuizQ.get(i).getContent();
			System.out.println(row[0]);
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
	
	private void ShowEditChoice(boolean isAdd)
	{
		editChoice = new EditChoice();
		editChoice.setVisible(true);
		editChoice.setOwner(this);
		editChoice.setModeEdit(isAdd);
	}

	@Override
	public void onUpdateEditChoice(String choice, boolean isAnwer, int index) {
		currentChoices.set(index, choice);
		int pos = -1;
		for(int i=0; i< currentAnsews.size(); i++) {
			if(currentAnsews.get(i).equals(choice)){
				pos = i;
				break;
			}
		}
		if(isAnwer) {
			if(pos == -1)
				currentAnsews.add(choice);
		}
		else
		{
			if(pos > -1)
				currentAnsews.remove(pos);
		}
		showTableAnswer(currentChoices);
	}

	@Override
	public void onAddEditChoices(String choice, boolean isAnwer) {
		currentChoices.add(choice);
		if(isAnwer)
			currentAnsews.add(choice);
		showTableAnswer(currentChoices);
	}
	
	public void AddChoiceQuestionToList() {
		ChoiceQuestion choiceQuestion = new ChoiceQuestion();
		choiceQuestion.setContent(txPaneContentQues.getText());
		choiceQuestion.setChapter(Common.partInt((String) cbbChapter.getSelectedItem()));
		choiceQuestion.setLevel(Common.partInt((String) cbbLevel.getSelectedItem()));
		listChoiceQuestion.add(choiceQuestion);
		loadDataChoiceQuestion();
		actionTableChoiceQuestion();
	}
	
}

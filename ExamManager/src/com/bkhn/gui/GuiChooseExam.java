package com.bkhn.gui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.bkhn.interfacecommon.ICommonGui;


@SuppressWarnings("serial")
public class GuiChooseExam extends JFrame implements ICommonGui{

	private static final int WIDTH_FRAME = 400;
	private static final int HEIGHT_FRAME = 200;
	private JButton btnChooseQuestion;
	private JButton btnCreateExamAuto;

	public GuiChooseExam() {
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
		btnChooseQuestion = new JButton("Chọn câu hỏi để đưa vào đề thi");
		btnChooseQuestion.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnChooseQuestion.setBounds(73, 13, 269, 41);
		add(btnChooseQuestion);
		
		btnCreateExamAuto = new JButton("Sinh đề tự động");
		btnCreateExamAuto.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCreateExamAuto.setBounds(73, 80, 269, 41);
		add(btnCreateExamAuto);
	}
	
}

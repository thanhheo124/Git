package com.bkhn.gui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.bkhn.interfacecommon.ICommonGui;


public class GuiCorrectAnswer extends JFrame implements ICommonGui{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private static final int WIDTH_FRAME = 450;
	private static final int HEIGHT_FRAME = 300;
	private JLabel lblResult;
	private JScrollPane scrollPane;
	private JTextArea txtAAnswer;
	private JCheckBox checkExact;
	private JButton btnOK;

	public GuiCorrectAnswer() {
		init();
		addComps();
	}
	
	@Override
	public void init() {
		setTitle("Câu trả lời");
		setSize(WIDTH_FRAME, HEIGHT_FRAME);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
	}

	@Override
	public void addComps() {
		lblResult = new JLabel("Đáp án");
		lblResult.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblResult.setBounds(42, 26, 100, 24);
		add(lblResult);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 79, 305, 71);
		add(scrollPane);
		
		txtAAnswer = new JTextArea();
		txtAAnswer.setText("ddddddddddddddddddddddddddddddddddddddddddd\r\ndsadsa\r\ndsa\r\ndsa\r\ndsa\r\nds\r\ndsa\r\ndsa\r\ndsa\r\ndsa\r\ndsa\r\ndsa\r\ndsa\r\n");
		scrollPane.setViewportView(txtAAnswer);
		
		checkExact = new JCheckBox("Đáp án đúng");
		checkExact.setFont(new Font("Tahoma", Font.PLAIN, 15));
		checkExact.setBounds(210, 172, 113, 25);
		add(checkExact);
		
		btnOK = new JButton("OK\r\n");
		btnOK.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnOK.setBounds(162, 206, 67, 34);
		add(btnOK);
	}
	
}

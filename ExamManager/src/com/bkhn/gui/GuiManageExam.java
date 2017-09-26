package com.bkhn.gui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import com.bkhn.gui.interfacecommon.ICommonGui;

public class GuiManageExam extends JFrame implements ICommonGui{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int WIDTH_FRAME = 700;
	private static final int HEIGHT_FRAME = 500;
	private JLabel lblManageExam;
	private JLabel lblOpenExam;
	private JScrollPane scrollPane;
	private JTextPane txtPane;
	private JButton btnOK;

	
	public GuiManageExam() {
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
		lblManageExam = new JLabel("Quản lý đề thi");
		lblManageExam.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblManageExam.setBounds(33, 24, 131, 33);
		add(lblManageExam);
		
		lblOpenExam = new JLabel("Mở đề thi có sẵn");
		lblOpenExam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOpenExam.setBounds(33, 71, 138, 33);
		add(lblOpenExam);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 117, 617, 235);
		add(scrollPane);
		
		txtPane = new JTextPane();
		txtPane.setText("không biết set chỗ này ra sao.");
		scrollPane.setViewportView(txtPane);
		
		btnOK = new JButton("OK");
		btnOK.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnOK.setBounds(466, 376, 58, 43);
		add(btnOK);
	}
		
	
}

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
	private JScrollPane scrollPane;
	private JTextPane txtPane;
	private JButton btnUpdate;

	
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
		lblManageExam = new JLabel("Danh sách đề thi có sẵn");
		lblManageExam.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblManageExam.setBounds(216, 27, 220, 33);
		getContentPane().add(lblManageExam);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 71, 617, 235);
		getContentPane().add(scrollPane);
		
		btnUpdate = new JButton("Chỉnh sửa đề thi");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnUpdate.setBounds(90, 335, 143, 33);
		getContentPane().add(btnUpdate);
		
		txtPane = new JTextPane();
		txtPane.setBounds(33, 71, 615, 233);
		getContentPane().add(txtPane);
		txtPane.setText("không biết set chỗ này ra sao.");
		
		JButton btnCustom = new JButton("Đề thi tùy chỉnh");
		btnCustom.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCustom.setBounds(268, 335, 135, 33);
		getContentPane().add(btnCustom);
		
		JButton btnAuto = new JButton("Tạo đề thi tự động");
		btnAuto.setFont(new Font("Dialog", Font.BOLD, 13));
		btnAuto.setBounds(438, 335, 149, 33);
		getContentPane().add(btnAuto);
	}
}

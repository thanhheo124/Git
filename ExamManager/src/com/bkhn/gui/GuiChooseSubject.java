package com.bkhn.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.bkhn.interfacecommon.ICommonGui;


@SuppressWarnings("serial")
public class GuiChooseSubject extends JFrame implements ICommonGui, ActionListener{

	private static final int WIDTH_FRAME = 400;
	private static final int HEIGHT_FRAME = 300;
	private JLabel lbChooseSubject;
	private JLabel lbListSubject;
	private JComboBox<String> cbbSubject;
	private JLabel lbManageSubject;
	private JButton btnOK;
	private JButton btnCancel;

	public GuiChooseSubject() {
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
		lbChooseSubject = new JLabel("Chọn môn học : ");
		lbChooseSubject.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbChooseSubject.setBounds(57, 15, 127, 29);
		add(lbChooseSubject);
		
		lbListSubject = new JLabel("Danh sách môn học");
		lbListSubject.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbListSubject.setBounds(57, 57, 138, 29);
		add(lbListSubject);
		
		cbbSubject = new JComboBox<>();
		cbbSubject.setBounds(55, 106, 270, 37);
		add(cbbSubject);
		
		lbManageSubject = new JLabel("<html><u>Quản lý môn học</u></html>");
		lbManageSubject.setForeground(Color.BLUE);
		lbManageSubject.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbManageSubject.setBounds(211, 156, 127, 29);
		add(lbManageSubject);
		
		btnOK = new JButton("OK");
		btnOK.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnOK.setBounds(139, 198, 84, 42);
		add(btnOK);
		btnOK.addActionListener(this);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancel.setBounds(254, 198, 84, 42);
		add(btnCancel);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

package com.bkhn.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.bkhn.gui.interfacecommon.ICommonGui;

public  class GuiManageObject extends JFrame implements ICommonGui,ActionListener, MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int WIDTH_FRAME = 700;
	private static final int HEIGHT_FRAME = 400;
	private static final String ACTION_ADDSUBJECT = "Thêm môn học";
	private JLabel lblList;
	private JLabel lblAddSubject;
	private JLabel lblSubjectName;
	private JLabel lblSubject_Id;
	private JLabel lblChapterNumber;
	private JLabel lblIntroduce;
	private JTextArea txAIntroduce;
	private JComponent txFSubjectName;
	private JTextField txFSubject_Id;
	private JSpinner spinnerChapterNumber;
	private JButton btnSave;
	private JButton btnCancel;
	private JButton btnDelete;
	private JButton btnOk;
	private JScrollPane scrollPane;
	private JTable tableListSubject;

	public GuiManageObject() {
		init();
		addComps();
	}
	
	@Override
	public void init() {
		setTitle("Quản lý môn học");
		setSize(WIDTH_FRAME, HEIGHT_FRAME);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
	}

	@Override
	public void addComps() {
		lblList = new JLabel("Danh sách môn học");
		lblList.setBounds(24, 0, 190, 28);
		lblList.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblList);
		
		lblAddSubject = new JLabel("<html><u>Thêm môn họcxxx</u></html>");
		lblAddSubject.setForeground(Color.BLUE);
		lblAddSubject.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAddSubject.setBounds(24, 236, 136, 28);
		add(lblAddSubject);
		lblAddSubject.setName(ACTION_ADDSUBJECT);
		lblAddSubject.addMouseListener(this);
		
		
		lblSubjectName = new JLabel("Tên môn học:");
		lblSubjectName.setBounds(278, 43, 91, 28);
		add(lblSubjectName);
		
		lblSubject_Id = new JLabel("Mã học phần:");
		lblSubject_Id.setBounds(278, 84, 91, 28);
		add(lblSubject_Id);
		
		lblChapterNumber = new JLabel("Số chương:");
		lblChapterNumber.setBounds(278, 125, 91, 28);
		add(lblChapterNumber);
		
		lblIntroduce = new JLabel("Giới thiệu:");
		lblIntroduce.setBounds(278, 170, 91, 28);
		add(lblIntroduce);
		
		txAIntroduce = new JTextArea();
		txAIntroduce.setBounds(381, 173, 272, 74);
		add(txAIntroduce);
		
		txFSubjectName = new JTextField();
		txFSubjectName.setBackground(Color.WHITE);
		txFSubjectName.setBounds(381, 44, 272, 27);
		add(txFSubjectName);

		
		txFSubject_Id = new JTextField();
		txFSubject_Id.setColumns(10);
		txFSubject_Id.setBackground(Color.WHITE);
		txFSubject_Id.setBounds(381, 87, 272, 27);
		add(txFSubject_Id);
		
		spinnerChapterNumber = new JSpinner();
		spinnerChapterNumber.setBounds(381, 125, 46, 28);
		add(spinnerChapterNumber);
		
		btnSave = new JButton("Lưu");
		btnSave.setBounds(24, 290, 104, 36);
		add(btnSave);
		
		btnCancel = new JButton("Hủy");
		btnCancel.setBounds(186, 290, 104, 36);
		add(btnCancel);
		
		
		btnDelete = new JButton("Xóa môn học");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDelete.setBackground(Color.RED);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBounds(351, 290, 120, 38);
		add(btnDelete);
		
		btnOk = new JButton("OK");
		btnOk.setBounds(529, 290, 115, 36);
		add(btnOk);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 41, 221, 182);
		add(scrollPane);
		
		tableListSubject = new JTable();
		tableListSubject.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableListSubject.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"T\u00EAn m\u00F4n h\u1ECDc"
			}
		));
		scrollPane.setViewportView(tableListSubject);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getSource().toString());
		if(!(e.getSource() instanceof JLabel))
			return;
		
		switch (((JLabel)e.getSource()).getName()) {
		case ACTION_ADDSUBJECT:
			JOptionPane.showMessageDialog(null, "Được rồi thầy ạ");
			break;

		default:
			break;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(!(e.getSource() instanceof JLabel))
			return;
		
		switch (((JLabel)e.getSource()).getName()) {
		case ACTION_ADDSUBJECT:
			JOptionPane.showMessageDialog(null, "Được rồi thầy ạ");
			break;

		default:
			break;
		}
	}
	
	
	// Nothing todo
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	

	

	
}

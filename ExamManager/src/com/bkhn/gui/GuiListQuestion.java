package com.bkhn.gui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.bkhn.interfacecommon.ICommonGui;


public class GuiListQuestion extends JFrame implements ICommonGui{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int WIDTH_FRAME = 400;
	private static final int HEIGHT_FRAME = 400;
	private JScrollPane scrollPane;
	private JTable tableListQuestion;

	public GuiListQuestion() {
		init();
		addComps();
	}
	
	@Override
	public void init() {
		setTitle("Các môn học đã chọn");
		setSize(WIDTH_FRAME, HEIGHT_FRAME);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
	}

	@Override
	public void addComps() {

		scrollPane = new JScrollPane();
		scrollPane.setBounds(63, 62, 269, 294);
		add(scrollPane);
		
		tableListQuestion = new JTable();
		tableListQuestion.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
			},
			new String[] {
				"Danh s\u00E1ch m\u00F4n h\u1ECDc"
			}
		));
		scrollPane.setViewportView(tableListQuestion);
	}
	
}

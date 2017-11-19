package com.bkhn.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

import com.bkhn.interfacecommon.ICommonGui;
import com.bkhn.interfacecommon.IGuiManageExam;

import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JPanel;

public class GuiManageExam extends JFrame implements ICommonGui {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int WIDTH_FRAME = 700;
	private static final int HEIGHT_FRAME = 500;
	private JLabel lblManageExam;
	private JButton btnUpdate;
	private JTable table;
	private JScrollPane scrollPane;
	private IGuiManageExam owner;

	public void setOwner(IGuiManageExam owner) {
		this.owner = owner;
	}

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

		btnUpdate = new JButton("Chỉnh sửa đề thi");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnUpdate.setBounds(90, 335, 143, 33);
		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (owner != null)
					owner.onEditExam();
			}
		});
		getContentPane().add(btnUpdate);

		JButton btnCustom = new JButton("Đề thi tùy chỉnh");
		btnCustom.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCustom.setBounds(268, 335, 135, 33);
		btnCustom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (owner != null)
					owner.onCreatExamByHand();
			}
		});
		getContentPane().add(btnCustom);

		JButton btnAuto = new JButton("Tạo đề thi tự động");
		btnAuto.setFont(new Font("Dialog", Font.BOLD, 13));
		btnAuto.setBounds(438, 335, 149, 33);
		btnAuto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (owner != null)
					owner.onCreatExamAuto();
			}
		});
		getContentPane().add(btnAuto);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(90, 93, 497, 202);
		getContentPane().add(scrollPane);

		table = new JTable();
		Object columns[] = { "name" };
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		scrollPane.setViewportView(table);
	}
}

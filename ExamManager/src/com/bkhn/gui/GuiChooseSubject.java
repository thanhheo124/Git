package com.bkhn.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.bkhn.interfacecommon.IChooseSubject;
import com.bkhn.interfacecommon.ICommonGui;
import com.bkhn.model.Subject;

@SuppressWarnings("serial")
public class GuiChooseSubject extends JFrame implements ICommonGui, ActionListener {

	private static final int WIDTH_FRAME = 400;
	private static final int HEIGHT_FRAME = 300;
	private JLabel lbChooseSubject;
	private JLabel lbListSubject;
	private JComboBox<String> cbbSubject;
	private JLabel lbManageSubject;
	private JButton btnOK;
	private JButton btnCancel;
	private ArrayList<Subject> subjects;
	private IChooseSubject owner;

	public GuiChooseSubject() {
		subjects = new ArrayList<Subject>();
		init();
		addComps();
	}

	public void updateView() {
		if(subjects.size() == 0)
			return;
		cbbSubject.removeAll();
		for (int i = 0; i < subjects.size(); i++) {
			cbbSubject.addItem(subjects.get(i).getName());
		}
		cbbSubject.setSelectedIndex(0);
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
		cbbSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				int index = cbbSubject.getSelectedIndex();
//				if(owner != null)
//					owner.onChooseSubject(subjects.get(index).getId());
			}
		});
		add(cbbSubject);

		lbManageSubject = new JLabel("<html><u>Quản lý môn học</u></html>");
		lbManageSubject.setForeground(Color.BLUE);
		lbManageSubject.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbManageSubject.setBounds(211, 156, 127, 29);
		lbManageSubject.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (owner != null)
					owner.onManagerSubject();
			}
		});
		add(lbManageSubject);

		btnOK = new JButton("OK");
		btnOK.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnOK.setBounds(139, 198, 84, 42);
		btnOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = cbbSubject.getSelectedIndex();
				if(owner != null)
					owner.onChooseSubject(subjects.get(index).getId());
			}
		});
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

	public void setOwner(IChooseSubject owner) {
		this.owner = owner;
	}

	public void setSubjects(ArrayList<Subject> subjects) {
		this.subjects = subjects;
	}

}

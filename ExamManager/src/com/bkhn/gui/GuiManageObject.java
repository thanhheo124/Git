package com.bkhn.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.bkhn.interfacecommon.ICommonGui;
import com.bkhn.interfacecommon.IManagerObject;
import com.bkhn.model.Subject;


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
	private JTextField txFSubjectName;
	private JTextField txFSubject_Id;
	private JSpinner spinnerChapterNumber;
	private JButton btnSave;
	private JButton btnCancel;
	private JButton btnDelete;
	private JButton btnOk;
	private JScrollPane scrollPane;
	private JTable tableListSubject;
	private ArrayList<Subject> listSub;
	private IManagerObject owner;
	private DefaultTableModel dtmTable;
	private int index;

	public GuiManageObject() {
		listSub = new ArrayList<Subject>();
		owner = null;
		init();
		addComps();
	}
	
	@Override
	public void init() {
		setTitle("Manage Subject");
		setSize(WIDTH_FRAME, HEIGHT_FRAME);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
	}
	
	public void setOwner(IManagerObject owner) {
		this.owner = owner;
	}
	
	public void setArrayListSubject(ArrayList<Subject> subjects) {
		listSub = subjects;
		loadListSub(listSub, dtmTable);
	}
	
	public void loadListSub(ArrayList<Subject> list, DefaultTableModel dtmTable){
		dtmTable.setRowCount(0);
		for(Subject dg:list){
			Vector<Object> vec=new Vector<Object>();
			vec.add(dg.getName());
			dtmTable.addRow(vec);
		}
	}
	
	public void LoadInfoSub(Subject sb){
		txFSubjectName.setText(sb.getName());
		txFSubject_Id.setText(sb.getId());
		spinnerChapterNumber.setValue(sb.getNumChapter());
		txAIntroduce.setText(sb.getIntroduction());
	}
	
	public Subject GetSubject(){
		String name=txFSubjectName.getText();
		String id=txFSubject_Id.getText();
		int numChap=Integer.parseInt(spinnerChapterNumber.getValue().toString());
		String introduce=txAIntroduce.getText();
		
		Subject sb=new Subject(name, id, numChap, introduce);
		return sb;
		
	}
	
	public void SaveSub(Subject sb,int index){
		
		listSub.set(index, sb);
	}
	
	public void DeleteSub(ArrayList<Subject> listSub, int index){
		listSub.remove(index);
	}

	@Override
	public void addComps() {
		
 		//Create list Subject
		listSub=new ArrayList<Subject>();
		Subject sb1=new Subject("Lập trình hướng đối tượng","001",5,"Đây là môn học HDT");
		Subject sb2=new Subject("Nhập môn CNTT","002",3,"Đây là môn học CNTT");
		Subject sb3=new Subject("Thiết kế và lập trình web","003",7,"Đây là môn học thiết kế website");
		listSub.add(sb1);
		listSub.add(sb2);
		listSub.add(sb3);
		
		lblList = new JLabel("List Subject");
		lblList.setBounds(24, 0, 190, 28);
		lblList.setFont(new Font("Tahoma", Font.BOLD, 16));
		getContentPane().add(lblList);
		
		lblAddSubject = new JLabel("<html><u>Add a subject</u></html>");
		lblAddSubject.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txAIntroduce.setText("");
				txFSubject_Id.setText("");
				txFSubjectName.setText("");
				spinnerChapterNumber.setValue(0);
			}
		});
		lblAddSubject.setForeground(Color.BLUE);
		lblAddSubject.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAddSubject.setBounds(24, 236, 136, 28);
		getContentPane().add(lblAddSubject);
		
		
		
		lblSubjectName = new JLabel("Name of subject:");
		lblSubjectName.setBounds(278, 43, 91, 28);
		getContentPane().add(lblSubjectName);
		
		lblSubject_Id = new JLabel("ID of subject:");
		lblSubject_Id.setBounds(278, 84, 91, 28);
		getContentPane().add(lblSubject_Id);
		
		lblChapterNumber = new JLabel("Number chapter:");
		lblChapterNumber.setBounds(278, 125, 91, 28);
		getContentPane().add(lblChapterNumber);
		
		lblIntroduce = new JLabel("Introduces:");
		lblIntroduce.setBounds(278, 170, 91, 28);
		getContentPane().add(lblIntroduce);
		
		txAIntroduce = new JTextArea();
		txAIntroduce.setBounds(381, 173, 272, 74);
		getContentPane().add(txAIntroduce);
		
		txFSubjectName = new JTextField();
		txFSubjectName.setBackground(Color.WHITE);
		txFSubjectName.setBounds(381, 44, 272, 27);
		getContentPane().add(txFSubjectName);

		
		txFSubject_Id = new JTextField();
		txFSubject_Id.setColumns(10);
		txFSubject_Id.setBackground(Color.WHITE);
		txFSubject_Id.setBounds(381, 87, 272, 27);
		getContentPane().add(txFSubject_Id);
		
		spinnerChapterNumber = new JSpinner();
		spinnerChapterNumber.setBounds(381, 125, 46, 28);
		getContentPane().add(spinnerChapterNumber);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Subject sb=GetSubject();
				SaveSub(sb, index);
				
			}
		});
		btnSave.setBounds(24, 290, 104, 36);
		getContentPane().add(btnSave);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				LoadInfoSub(listSub.get(index));
			}
		});
		btnCancel.setBounds(186, 290, 104, 36);
		getContentPane().add(btnCancel);
		
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteSub(listSub, index);
				loadListSub(listSub, dtmTable);
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDelete.setBackground(Color.RED);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBounds(351, 290, 120, 38);
		getContentPane().add(btnDelete);
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Subject sb=GetSubject();
				listSub.add(sb);
				loadListSub(listSub, dtmTable);
			}
		});
		btnOk.setBounds(529, 290, 115, 36);
		getContentPane().add(btnOk);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 41, 221, 182);
		getContentPane().add(scrollPane);
		
		tableListSubject = new JTable();
		tableListSubject.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dtmTable=new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"T\u00EAn m\u00F4n h\u1ECDc"
				}
			);
		tableListSubject.setModel(dtmTable);
		//load list Subject
		loadListSub(listSub, dtmTable);
		scrollPane.setViewportView(tableListSubject);
		
		//load info subject
		tableListSubject.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				index=tableListSubject.getSelectedRow();
				LoadInfoSub(listSub.get(index));
			}
			
		});
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/*@Override
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
		
	}*/	
}

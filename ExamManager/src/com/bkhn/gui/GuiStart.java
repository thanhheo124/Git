package com.bkhn.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.bkhn.interfacecommon.ICommonGui;
import com.bkhn.interfacecommon.IStart;

@SuppressWarnings("serial")
public class GuiStart extends JFrame implements ICommonGui {

	private static final int WIDTH_FRAME = 500;
	private static final int HEIGHT_FRAME = 500;
	private JButton btnCompileQues;
	private JButton btnCreateQuest;
	private JComponent btnTest;
	private JButton btnEvaluteResult;
	private JButton btnExit;
	private JLabel lbSetup;
	private IStart owner;

	public GuiStart() {
		init();
		addComps();
	}

	@Override
	public void init() {
		setTitle("Quản Lý Đề Thi");
		setSize(WIDTH_FRAME, HEIGHT_FRAME);
		// getContentPane().setBackground(Color.BLUE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
	}

	@Override
	public void addComps() {
		btnCompileQues = new JButton("Soạn câu hỏi");
		btnCompileQues.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCompileQues.setBackground(new Color(189, 183, 107));
		btnCompileQues.setBounds(88, 23, 296, 36);
		btnCompileQues.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(owner !=null)
					owner.questionsContruction();
			}
		});
		add(btnCompileQues);

		btnCreateQuest = new JButton("Xây dựng đề thi");
		btnCreateQuest.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCreateQuest.setBackground(new Color(189, 183, 107));
		btnCreateQuest.setBounds(88, 84, 296, 36);
		btnCreateQuest.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(owner !=null)
					owner.examContruction();
			}
		});
		add(btnCreateQuest);

		btnTest = new JButton("Làm bài thi");
		btnTest.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTest.setBackground(new Color(189, 183, 107));
		btnTest.setBounds(88, 152, 296, 36);
		add(btnTest);

		btnEvaluteResult = new JButton("Đánh giá kết quả");
		btnEvaluteResult.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEvaluteResult.setBackground(new Color(189, 183, 107));
		btnEvaluteResult.setBounds(88, 220, 296, 36);
		add(btnEvaluteResult);

		btnExit = new JButton("Thoát");
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExit.setBackground(new Color(189, 183, 107));
		btnExit.setBounds(266, 300, 118, 36);
		add(btnExit);

		lbSetup = new JLabel("<html><u>Thiết lập</u></html>");
		lbSetup.setForeground(Color.BLUE);
		lbSetup.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbSetup.setBounds(96, 295, 107, 37);
		add(lbSetup);
		clickSetup();

	}

	public void clickSetup() {
		lbSetup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Ban da click thanh cong");
			}
		});
	}

	public void setOwner(IStart owner) {
		this.owner = owner;
	}
	
	
}

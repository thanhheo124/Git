package com.bkhn.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.bkhn.interfacecommon.IEditChoice;

import javax.swing.JCheckBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class EditChoice extends JFrame{
	private JTextField textField;
	JCheckBox chckbxNewCheckBox;
	private IEditChoice owner;
	private boolean isAddChoice;
	private String choice;
	private boolean isanwer;
	private int index;
	
	public void setModeEdit(boolean isAddChoice) {
		this.isAddChoice = isAddChoice;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	
	public EditChoice() {
		getContentPane().setLayout(null);
		setSize(250, 200);
		setLocationRelativeTo(null);
		setResizable(false);
		textField = new JTextField();
		textField.setBounds(24, 27, 180, 29);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		chckbxNewCheckBox = new JCheckBox("Is Answer");
		chckbxNewCheckBox.setBounds(24, 59, 97, 23);
		getContentPane().add(chckbxNewCheckBox);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(60, 99, 113, 29);
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isAddChoice) {
					owner.onAddEditChoices(textField.getText(), chckbxNewCheckBox.isSelected());
				}
				else
				{
					owner.onUpdateEditChoice(textField.getText(), chckbxNewCheckBox.isSelected(), index);
				}
			}
		});
		getContentPane().add(btnOk);
	}

	public void setOwner(IEditChoice owner) {
		this.owner = owner;
	}
	
	public void setStringChoice(String choice) {
		this.choice = choice;
	}
	
	public void setIsAnser(boolean answer) {
		this.isanwer = answer;
	}
	
	public void updateView()
	{
		this.textField.setText(choice);
		this.chckbxNewCheckBox.setSelected(isanwer);
	}
}

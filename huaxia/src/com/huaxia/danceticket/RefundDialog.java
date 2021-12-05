package com.huaxia.danceticket;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RefundDialog extends JDialog implements ActionListener{
	private static final long serialVersionUID = 1L;
	private MainFrame parent;
	private JTextField idTxt, nameTxt, earlyBirdTxt, doorPriceTxt;
	private Student student;
	
	RefundDialog(MainFrame parent){
		this.parent = parent;
		setSize(380, 150);
		setResizable(false);
		this.setLocationRelativeTo(parent);
		setTitle("Student Refund");
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		JLabel idLbl = new JLabel("Student ID: ");
		idTxt = new JTextField(10);
		JButton findBtn = new JButton("Find");
		findBtn.addActionListener(this);
		JLabel nameLbl = new JLabel("Student Name: ");
		nameTxt = new JTextField(10);
		nameTxt.setEditable(false);
		JLabel earlyBirdLbl = new JLabel("Early Bird: ");
		earlyBirdTxt = new JTextField(10);
		JLabel doorPriceLbl = new JLabel("Door Price: ");
		doorPriceTxt = new JTextField(10);
		JButton updateBtn = new JButton("Refund");
		updateBtn.addActionListener(this);

		add(idLbl, gbc);
		gbc.gridx = 1;
		add(idTxt, gbc);
		gbc.gridx = 2;
		add(findBtn, gbc);
		gbc.gridy = 1;
		gbc.gridx = 1;
		add(nameTxt, gbc);
		gbc.gridx = 0;
		add(nameLbl, gbc);
		gbc.gridy = 2;
		add(earlyBirdLbl, gbc);
		gbc.gridx = 1;
		add(earlyBirdTxt, gbc);
		gbc.gridy = 3;
		add(doorPriceTxt, gbc);
		gbc.gridx = 0;
		add(doorPriceLbl, gbc);
		gbc.gridx=2;
		add(updateBtn, gbc);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		switch(cmd) {
		case "Find":
			findStudent();
			break;
		case "Refund":
			refund();
			break;
		}
		
	}
	
	private void refund() {
		Student.students.remove(student);
		Student.saveAll();
		parent.setStatus("the student (id=" + student.getId() + ") has been removed.");
	}

	private void findStudent() {
		Student.loadAll();
		parent.setStatus("");
		String idString = idTxt.getText();
		if (idString != null && !idString.isEmpty()) {
			int id = Integer.parseInt(idString);
			student = Student.students.find(id);
			if (student == null) {
				parent.setStatus("Student does NOT exist.");
			}
			displayDetail(student);
		}

	}
	
	private void displayDetail(Student student) {
		nameTxt.setText(student.getName());
		earlyBirdTxt.setText("" + student.getEarlyBirdTickets());
		doorPriceTxt.setText("" + student.getDoorTickets());
	}

}

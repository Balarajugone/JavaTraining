package com.javatraining.assignment9;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

class AddLibrarian extends JFrame {

	JLabel namelabel;
	JLabel passwordlabel;
	JTextField name;
	JTextField password;
	JButton submit;
	Library library;
	Librarian librarian = Librarian.getInstance();

	/**
	 * Add the New Librarians
	 */
	public AddLibrarian() {
		name = new JTextField(40);
		namelabel = new JLabel("Name");
		passwordlabel = new JLabel("Password");
		password = new JTextField(40);

		submit = new JButton("Submit");

		submit.addActionListener(e -> {
			addlib();
			dispose();
		});

		add(namelabel);
		add(name);
		add(passwordlabel);
		add(password);
		add(submit);

		setVisible(true);
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

	}

	/**
	 * Add the Librarians to the Map, UserName as Key and Password as Value
	 */
	public void addlib() {
		library = new Library(name.getText(), password.getText());
		librarian.addLibrarian(library.getName(), library);
	}

}

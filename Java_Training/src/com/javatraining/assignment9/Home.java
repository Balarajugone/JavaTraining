package com.javatraining.assignment9;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class Home extends JFrame {
	JButton addLib;
	JButton login;

	public static void main(String[] args) {
		new Home();
	}
	/**
	 * Home Page
	 */
	public Home() {
		addLib = new JButton("Add Librarian");
		login = new JButton("Login");

		add(addLib);
		add(login);

		setVisible(true);
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		/**
		 * Add Librarians Button which opens the page to add the Librarians
		 */
		addLib.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddLibrarian();
			}
		});

		/**
		 * Login Button which Verifies the user and login into the Main Page
		 */
		login.addActionListener(e -> {
			new Librarian_Login();
			dispose();
		});
	}
}
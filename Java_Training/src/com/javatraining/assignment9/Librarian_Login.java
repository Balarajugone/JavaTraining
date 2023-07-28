package com.javatraining.assignment9;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map.Entry;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

public class Librarian_Login extends JFrame {
	public static void main(String[] args) {
		new Librarian_Login();
	}

	JButton librarianLogin;
	JLabel jl;
	JTextField name;
	JPasswordField password;
	JLabel namelabel;
	JLabel passwordlabel;
	JLabel lblAdminLoginForm;
	JButton back;
	Librarian librarians = Librarian.getInstance();

	JPanel contentPanel;
	GroupLayout gl_contentPanel;

	/**
	 * Opens the Login Form, Logins into the Account if User is authorized
	 */
	public Librarian_Login() {

		setTitle("Library Management System");

		name = new JTextField();
		namelabel = new JLabel("Name");
		passwordlabel = new JLabel("Password");
		lblAdminLoginForm = new JLabel("Librarian Login");
		password = new JPasswordField();
		librarianLogin = new JButton("Login");
		back = new JButton("Back");
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		gl_contentPanel = new GroupLayout(contentPanel);

		password.setColumns(10);

		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGroup(gl_contentPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(200).addComponent(lblAdminLoginForm))
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(100)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addComponent(namelabel)
										.addComponent(passwordlabel))
								.addGap(47)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(password)
										.addComponent(name, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))))
						.addContainerGap(107, Short.MAX_VALUE))
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap(100, Short.MAX_VALUE)
						.addComponent(librarianLogin, GroupLayout.DEFAULT_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addGap(300))

				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap(100, Short.MAX_VALUE)
						.addComponent(back, GroupLayout.DEFAULT_SIZE, 80, GroupLayout.PREFERRED_SIZE).addGap(100))

		);

		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPanel
				.createSequentialGroup().addComponent(lblAdminLoginForm).addGap(50)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(namelabel).addComponent(
						name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(28)
				.addGroup(gl_contentPanel
						.createParallelGroup(Alignment.BASELINE).addComponent(passwordlabel).addComponent(password,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(50)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(librarianLogin, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(back, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE).addGap(90))));

		setVisible(true);
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		contentPanel.setLayout(gl_contentPanel);

		/**
		 * Login Button, Verifies and open the menu page on clock
		 */
		librarianLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (librarians.getLibrarian().isEmpty()) {
					jl = new JLabel("Users are not added yet, Please add the Users");
					lable();
				} else if (userAuthentication() != null) {
					new Main_Menu();
					dispose();
				} else {
					jl = new JLabel("UserName or Password is incorrect...");
					lable();
				}
				name.setText("");
				password.setText("");
			}
		});

		/**
		 * Back Button, Return to Home on click
		 */
		back.addActionListener(e -> {
			new Home();
			dispose();
		});

	}

	/**
	 * Displays the Error Message
	 */
	public void lable() {
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap(187, Short.MAX_VALUE)
						.addComponent(jl, GroupLayout.DEFAULT_SIZE, 80, GroupLayout.PREFERRED_SIZE).addGap(190)));

		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(120).addContainerGap(187, Short.MAX_VALUE)
						.addComponent(jl, GroupLayout.DEFAULT_SIZE, 80, GroupLayout.PREFERRED_SIZE).addGap(190)));
	}

	/**
	 * Authenticate the user
	 * 
	 * @return
	 */
	public Entry<String, Library> userAuthentication() {
		for (Entry<String, Library> librarian : librarians.getLibrarian().entrySet()) {

			if (name.getText().equals(librarian.getKey())
					&& password.getText().equals(librarian.getValue().getPassword())) {

				return librarian;
			}
		}
		return null;
	}

}

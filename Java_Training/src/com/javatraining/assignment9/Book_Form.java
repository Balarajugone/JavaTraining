package com.javatraining.assignment9;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class Book_Form extends JFrame {

	public static void main(String[] args) {
		new Book_Form();
	}

	JLabel namelab;
	JTextField name;
	JLabel authorlab;
	JLabel result;
	JTextField author;
	JLabel costlab;
	JTextField cost;
	JButton submit;
	JButton btnBack;
	private JPanel contentPanel;
	GroupLayout gl_contentPanel;

	/**
	 * Book Form
	 */
	public Book_Form() {
		namelab = new JLabel("Name");
		authorlab = new JLabel("Author");
		result = new JLabel();
		costlab = new JLabel("Cost");
		submit = new JButton("Submit");
		btnBack = new JButton("Back");

		name = new JTextField();
		name.setColumns(10);
		author = new JTextField();
		author.setColumns(10);
		cost = new JTextField();
		cost.setColumns(10);

		setVisible(true);
		setBounds(100, 100, 450, 371);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(20)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(namelab, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.DEFAULT_SIZE)
								.addComponent(authorlab, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(costlab, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addGap(58)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(cost, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
								.addComponent(author, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
								.addComponent(name, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
						.addContainerGap(107, Short.MAX_VALUE))
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap(151, Short.MAX_VALUE)
						.addComponent(submit).addGap(190))
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap(20, Short.MAX_VALUE)
						.addComponent(btnBack).addGap(195)));

		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPanel
				.createSequentialGroup()
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(namelab).addComponent(
						name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(authorlab).addComponent(
						author, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(costlab).addComponent(
						cost, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(submit,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(10).addComponent(btnBack, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))

		);
		contentPanel.setLayout(gl_contentPanel);

		/**
		 * Submit Button, Stores the given data into the file
		 */
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				File f;
				try {
					if (!(name.getText().isEmpty()) && !(author.getText().isEmpty()) && !(cost.getText().isEmpty())) {
						f = new File("C:\\Balaraju\\Java\\Training_Workspace\\JavaTrainingExamples\\src\\com\\javatraining\\assignment9\\Books.txt");

						if (!f.exists()) {
							f.createNewFile();
						}

						FileInputStream fis = new FileInputStream(f);
						InputStreamReader isr = new InputStreamReader(fis);
						BufferedReader br = new BufferedReader(isr);
						String existingtxt = new String();
						String line = "";
						while ((line = br.readLine()) != null) {
							existingtxt += line + "\n";
						}
						FileWriter fw = new FileWriter(f);
						fw.write(existingtxt + name.getText() + "," + author.getText() + "," + cost.getText());
						result.setText("");
						result = new JLabel("Book Added Successfully");
						result();
						fw.close();
					} else {
						result = new JLabel("Please Fill all the fields");
						result();
					}

					

				} catch (Exception e1) {
					System.out.println(e1);
				} finally {
					name.setText("");
					author.setText("");
					cost.setText("");

				}

			}
		});

		/**
		 * Back button, return to the menu page on click
		 */
		btnBack.addActionListener(e -> {
			new Main_Menu();
			dispose();
		});

	}

	/**
	 * Displays the error message
	 */
	public void result() {
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap(187, Short.MAX_VALUE)
						.addComponent(result, GroupLayout.DEFAULT_SIZE, 80, GroupLayout.PREFERRED_SIZE).addGap(190)));

		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap(100, Short.MAX_VALUE)
						.addComponent(result, GroupLayout.DEFAULT_SIZE, 80, GroupLayout.PREFERRED_SIZE).addGap(60)));
	}

}

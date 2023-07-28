package com.javatraining.assignment9;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class View_Books extends JFrame {

	private JPanel contentPane;
	private JTable table;

	private JPanel contentPanel;
	GroupLayout gl_contentPanel;

	JLabel result;
	JButton back;

	/**
	 * View Books Displays the available books in the tabular format
	 * 
	 * @param books
	 * @param splitline
	 */
	public View_Books(Books books, String[] splitline) {

		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		table = new JTable();
		String data[][] = null;
		String[] head = { "NAME", "AUTHOR", "COST" };

		if (splitline != null) {
			data = new String[books.getBooks().size()][splitline.length];
			for (int i = 0; i < books.getBooks().size(); i++) {
				for (int j = 0; j < splitline.length; j++) {
					if (j == 0)
						data[i][j] = books.getBooks().get(i).getbName();
					else if (j == 1)
						data[i][j] = books.getBooks().get(i).getbAuthor();
					else
						data[i][j] = String.valueOf(books.getBooks().get(i).getbCost());
				}
			}
			table = new JTable(data, head);
			JScrollPane sp = new JScrollPane(table);
			contentPane.add(sp, BorderLayout.CENTER);

		} else {
			result = new JLabel("No Books");
			back = new JButton("Back");
			result();
		}

	}

	/**
	 * Display message if books are not available
	 */
	public void result() {
		setVisible(true);
		setBounds(100, 100, 450, 371);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		gl_contentPanel = new GroupLayout(contentPanel);

		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap(187, Short.MAX_VALUE)
						.addComponent(result, GroupLayout.DEFAULT_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(back, GroupLayout.DEFAULT_SIZE, 80, GroupLayout.PREFERRED_SIZE).addGap(190)));

		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap(100, Short.MAX_VALUE)
						.addComponent(result, GroupLayout.DEFAULT_SIZE, 80, GroupLayout.PREFERRED_SIZE))
				.addGap(60).addComponent(back, GroupLayout.DEFAULT_SIZE, 80, GroupLayout.PREFERRED_SIZE).addGap(60));

		/**
		 * Back Button, Return to the menu on click
		 */
		back.addActionListener(e -> {
			new Main_Menu();
			dispose();
		});
	}

}

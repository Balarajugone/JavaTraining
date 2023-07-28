package com.javatraining.assignment9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Main_Menu extends JFrame {

	public static void main(String[] args) {
		new Main_Menu();
	}

	JButton add;
	JButton view;
	JButton update;
	JButton delete;
	JButton logout;
	JLabel jl;

	Scanner sc;
	String[] splitline = null;
	String data[][] = null;
	String[] head = { "NAME", "AUTHOR", "COST" };
	Books books = Books.getInstance();

	/**
	 * Menu Page
	 */
	public Main_Menu() {
		add = new JButton("Add Book");
		view = new JButton("View Book");
		update = new JButton("Update Book");
		delete = new JButton("delete Book");
		logout = new JButton("Logout");
		jl = new JLabel("Books");

		setVisible(true);
		setBounds(100, 100, 450, 371);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);

		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap(150, Short.MAX_VALUE).addGap(123))
				.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup().addGap(134)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(add, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.DEFAULT_SIZE)
								.addComponent(view, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.DEFAULT_SIZE)
								.addComponent(update, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.DEFAULT_SIZE)
								.addComponent(delete, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.DEFAULT_SIZE)
								.addComponent(logout, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.DEFAULT_SIZE))
						.addContainerGap(109, Short.MAX_VALUE)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addComponent(add, GroupLayout.DEFAULT_SIZE, 49, GroupLayout.DEFAULT_SIZE).addGap(30)
						.addComponent(view, GroupLayout.DEFAULT_SIZE, 49, GroupLayout.DEFAULT_SIZE).addGap(30)
						.addComponent(update, GroupLayout.DEFAULT_SIZE, 49, GroupLayout.DEFAULT_SIZE).addGap(30)
						.addComponent(delete, GroupLayout.DEFAULT_SIZE, 49, GroupLayout.DEFAULT_SIZE).addGap(30)
						.addComponent(logout, GroupLayout.DEFAULT_SIZE, 49, GroupLayout.DEFAULT_SIZE)
						.addContainerGap(21, Short.MAX_VALUE)));
		contentPanel.setLayout(gl_contentPanel);

		// Add books button
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Book_Form();
				dispose();
			}
		});

		File f ;
		try {
			f= new File(
					"C:\\Balaraju\\Java\\Training_Workspace\\JavaTrainingExamples\\src\\com\\javatraining\\assignment9\\Books.txt");

			if (!f.exists()) {
				try {
					f.createNewFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			FileReader fr = new FileReader(f);
			sc = new Scanner(fr);

			while (sc.hasNextLine()) {
				splitline = sc.nextLine().split(",");
				// String cos = splitline[2];
				// if (!(cos.isEmpty())) {
				Book book = new Book(splitline[0], splitline[1], Double.parseDouble(splitline[2]));
				if (books.getBooks().isEmpty()) {
					books.addBooks(book);
				} else {
					Book currentbook = books.bookAuthorise(book);
					if (currentbook == null)
						books.addBooks(book);
				}
				// } else {
				// System.out.println("no Books");
				// }
			}

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (NumberFormatException e1) {
			System.out.println("number format exception");
		}

		// View Books button
		view.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (books.getBooks().isEmpty()) {
					new View_Books(books, splitline);
					dispose();
				} else {
					new View_Books(books, splitline);
				}
			}
		});

		// Update books button
		update.addActionListener(e -> {
			new Update_Book();
			dispose();
		});

		// Delete books button
		delete.addActionListener(e -> {
			new Delete_Book();
			dispose();
		});

		// Logout books button
		logout.addActionListener(e -> {
			new Home();
			dispose();
		});

	}
}

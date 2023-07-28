package com.javatraining.assignment9;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

public class Delete_Book extends JFrame {
	public static void main(String[] args) {
		new Delete_Book();
	}

	Books books = Books.getInstance();
	JLabel namelab;
	JTextField name;
	JButton search;
	JButton back;
	JLabel result;
//	JLabel bresult;
	private JPanel contentPanel;
	GroupLayout gl_contentPanel;

	JLabel bnamelab;
	JTextField bname;
	JLabel bauthorlab;
	JTextField bauthor;
	JLabel bcostlab;
	JTextField bcost;

	JButton bback;
	JButton delete;

	/**
	 * Delete book delete the given book from the list if it is available
	 */
	public Delete_Book() {
		namelab = new JLabel("Name");
		name = new JTextField();
		search = new JButton("Search");
		back = new JButton("Back");
		result = new JLabel();

		setVisible(true);
		setBounds(100, 100, 450, 371);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.CENTER)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(20)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false).addComponent(namelab,
								GroupLayout.PREFERRED_SIZE, 100, GroupLayout.DEFAULT_SIZE))

						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false).addComponent(name,
								GroupLayout.PREFERRED_SIZE, 190, Short.MAX_VALUE))
						.addGap(10))
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false).addComponent(search,
						GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap(100, Short.MAX_VALUE)
						.addComponent(back, GroupLayout.DEFAULT_SIZE, 20, GroupLayout.PREFERRED_SIZE).addGap(100)));

		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPanel
				.createSequentialGroup().addGap(20)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(namelab).addComponent(
						name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(30)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(search, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(back, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(90)));
		contentPanel.setLayout(gl_contentPanel);

		/**
		 * Search button search for the given book, if book is available displays the
		 * details
		 */
		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Book book = getbook();
				if (book != null) {
					display();
				} else {
					result = new JLabel("Book not available");
					result();
				}
			}

		});

		/**
		 * Return to the menu on click
		 */
		back.addActionListener(e -> {
			new Main_Menu();
			dispose();
		});

	}

	/**
	 * Display the message
	 */
	public void result() {
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap(187, Short.MAX_VALUE)
						.addComponent(result, GroupLayout.DEFAULT_SIZE, 80, GroupLayout.PREFERRED_SIZE).addGap(190)));

		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap(100, Short.MAX_VALUE)
						.addComponent(result, GroupLayout.DEFAULT_SIZE, 80, GroupLayout.PREFERRED_SIZE).addGap(60)));
	}

	/**
	 * Display the book details if the book is available
	 */
	public void display() {
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
								.addComponent(bnamelab, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.DEFAULT_SIZE)
								.addComponent(bauthorlab, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(bcostlab, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addGap(58)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(bcost, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
								.addComponent(bauthor, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
								.addComponent(bname, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)))
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false).addComponent(bback,
						GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addComponent(delete, GroupLayout.DEFAULT_SIZE, 20, GroupLayout.PREFERRED_SIZE).addGap(100))

		);

		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPanel
				.createSequentialGroup()
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(bnamelab).addComponent(
						bname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(bauthorlab).addComponent(
						bauthor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(bcostlab).addComponent(
						bcost, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(delete, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(bback, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(90)));

		contentPanel.setLayout(gl_contentPanel);

		/**
		 * Delete button delete the book from the list
		 */
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (Book book : books.getBooks()) {
					if (book.getbName().equals(name.getText())) {
						books.removeBooks(book);
						break;
					}
				}
				try {
					File f = new File(
							"C:\\Balaraju\\Java\\Training_Workspace\\JavaTrainingExamples\\src\\com\\javatraining\\assignment9\\Books.txt");

					if (f.exists()) {
						f.delete();
						f.createNewFile();
					}
					FileWriter fw = new FileWriter(f);
					for (Book book : books.getBooks()) {
						if (book != null) {
							fw.write(book.getbName() + "," + book.getbAuthor() + "," + book.getbCost());
						}

					}

					result = new JLabel("Book Deleted Successfully");
					result();

					fw.close();

				} catch (Exception e1) {
					System.out.println(e1);
				} finally {
					bname.setText("");
					bauthor.setText("");
					bcost.setText("");

				}

			}
		});

		/**
		 * return to search page on click
		 */
		bback.addActionListener(e -> {
			new Delete_Book();
			dispose();
		});
	}

	/**
	 * Verify whether the given book is available or not
	 * @return
	 * return the book if available else return null
	 */
	public Book getbook() {
		for (Book book : books.getBooks()) {
			if (book.getbName().equals(name.getText())) {
				bname = new JTextField(book.getbName());
				bname.setColumns(10);
				bauthor = new JTextField(book.getbAuthor());
				bauthor.setColumns(10);
				bcost = new JTextField(String.valueOf(book.getbCost()));
				bcost.setColumns(10);

				bnamelab = new JLabel("Name");
				bauthorlab = new JLabel("Author");
				bcostlab = new JLabel("Cost");

				delete = new JButton("Delete");
				bback = new JButton("Back");
				return book;
			}
		}
		return null;
	}
}

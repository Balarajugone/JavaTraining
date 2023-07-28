package com.javatraining.assignment9;

import java.util.*;

public class Librarian {

	private final HashMap<String, Library> librarian;

	private static Librarian instance;

	private Librarian() {
		librarian = new HashMap<>();
	}

	/**
	 * getInstance Method return the Instance of the class
	 * 
	 * @return
	 */
	public static Librarian getInstance() {
		if (instance == null) {
			instance = new Librarian();
		}
		return instance;
	}

	/**
	 * Add the Librarians to the Map, UserName as Key and Password as Value
	 */
	public void addLibrarian(String name, Library libraria) {
		librarian.put(name, libraria);
	}

	/**
	 * Return the collection of librarian
	 * 
	 * @return
	 */
	public HashMap<String, Library> getLibrarian() {
		return librarian;
	}
}

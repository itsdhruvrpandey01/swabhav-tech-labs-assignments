package com.aurionpro.book.model;

import java.util.Comparator;

public class BookAuthorComparator implements Comparator<Book>{

	@Override
	public int compare(Book book1, Book book2) {
		return book1.getAuthorName().compareTo(book2.getAuthorName());
	}

}

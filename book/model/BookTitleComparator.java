package com.aurionpro.book.model;

import java.util.Comparator;

public class BookTitleComparator implements Comparator<Book>{

	@Override
	public int compare(Book book1, Book book2) {
		return -1*book1.getBookTitle().compareTo(book2.getBookTitle());
	}
}

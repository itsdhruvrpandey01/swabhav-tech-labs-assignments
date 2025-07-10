package com.aurionpro.book.model;

public class Book {
	private Integer bookId;
	private String bookTitle;
	private String authorName;
	private boolean isBookIssued;
	private Double bookPrice;
	
	public String getBookTitle() {
		return bookTitle;
	}


	public String getAuthorName() {
		return authorName;
	}


	public boolean isBookIssued() {
		return isBookIssued;
	}

	public void setBookIssued(boolean isBookIssued) {
		this.isBookIssued = isBookIssued;
	}

	public Integer getBookId() {
		return bookId;
	}


	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}


	public Book(Integer bookId, String bookTitle, String authorName, boolean isBookIssued, Double bookPrice) {
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.authorName = authorName;
		this.isBookIssued = isBookIssued;
		this.bookPrice = bookPrice;
	}


	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookTitle=" + bookTitle + ", authorName=" + authorName + ", isBookIssued="
				+ isBookIssued + ", bookPrice=" + bookPrice + "]";
	}
	
	
}

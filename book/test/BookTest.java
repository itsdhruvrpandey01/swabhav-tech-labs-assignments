package com.aurionpro.book.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.aurionpro.book.model.Book;
import com.aurionpro.book.model.BookAuthorComparator;
import com.aurionpro.book.model.BookTitleComparator;

public class BookTest {

	public static void main(String[] args) {
		System.out.println("Welcome to Book Store...!");
		System.out.println("1. for dashboard \n 2. to exit");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		List<Book> books = new ArrayList<>();
		while(choice!=2) {
			startBookApp(scanner,books);
			System.out.println("Enter Any Number to continue\n Enter 2. to exit");
			choice = scanner.nextInt();
		}
	}

	private static void startBookApp(Scanner scanner,List<Book> books) {
		displayOptions();
		int userChoice = scanner.nextInt();
		if(userChoice == 1) {
			insertBook(scanner,books);
			return;
		}
		if(userChoice == 2) {
			doBorrowBook(books,scanner);
			return;
		}
		if(userChoice == 3) {
			displayAvailableBooks(books,scanner);
			return;
		}
		if(userChoice == 4) {
			displayIssuedBooks(books);
			return;
		}
		if(userChoice == 5) {
			doReturnBook(books, scanner);
			return;
		}
	}

	private static void displayAvailableBooks(List<Book> books,Scanner scanner) {
		System.out.println("Type 1 for Asending order of Authors");
		System.out.println("Type 2 for Descending order of Title");
		int choice = scanner.nextInt();
		if(choice == 1) {
			Collections.sort(books, new BookAuthorComparator());
			displayAvailbleBooks(books);
			return;
		}
		if(choice == 2) {
			Collections.sort(books, new BookTitleComparator());
			displayAvailbleBooks(books);
			return;
		}
	}

	private static void doBorrowBook(List<Book> books,Scanner scanner) {
		displayAvailbleBooks(books);
		System.out.println("Enter the Id of book you want to borrow");
		int id = scanner.nextInt();
		for(Book book:books) {
			if(book.getBookId() == id) {
				book.setBookIssued(true);
				System.out.println("Book Issued successfully...!");
				return;
			}
		}
		System.out.println("Can't find the bookId");
	}
	private static void doReturnBook(List<Book> books,Scanner scanner) {
		displayIssuedBooks(books);
		System.out.println("Enter the Id of book you want to Return");
		int id = scanner.nextInt();
		for(Book book:books) {
			if(book.getBookId() == id) {
				book.setBookIssued(false);
				System.out.println("Book Returned successfully...!");
				return;
			}
		}
		System.out.println("Can't find the bookId");
	}

	private static void displayAvailbleBooks(List<Book> books) {
		for(Book book:books) {
			if(!book.isBookIssued()) System.out.println(book);
		}
	}
	private static void displayIssuedBooks(List<Book> books) {
		for(Book book:books) {
			if(book.isBookIssued()) System.out.println(book);
		}
	}

	private static void displayOptions() {
		System.out.println("Please Enter the options from below");
		System.out.println("1. Add a new book.");
		System.out.println("2. Borrow a book.");
		System.out.println("3. Display All Available books.");
		System.out.println("4. Display All issued books.");
		System.out.println("5. Return A Book.");
	}
	private static void insertBook(Scanner scanner,List<Book> books) {
		System.out.println("Welcome Please Enter the Details of book");
		System.out.println("Enter Book Title");
		String bookTitle = scanner.next();
		System.out.println("Enter Author Name");
		String authorName = scanner.next();
		boolean isBookIssued = false;
		System.out.println("Enter the price of book");
		Double bookPrice = scanner.nextDouble();
		books.add(new Book(books.size(), bookTitle, authorName, isBookIssued, bookPrice));
	}

}

package controller;

import services.BookService;

public class BookDeleteController {
	public static void main(String[] args) {
		BookService bookService = new BookService();
		boolean b = bookService.deleteBookById(2);
		System.out.println(b);
	}

}

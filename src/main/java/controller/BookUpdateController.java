package controller;

import services.BookService;

public class BookUpdateController {
	public static void main(String[] args) {
		BookService bookService = new BookService();
		boolean b = bookService.updateBookById(2, "Psychology of Money","Morgan Housel");
		System.out.println(b);
	}

}

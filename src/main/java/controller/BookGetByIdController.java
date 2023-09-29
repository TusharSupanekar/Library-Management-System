package controller;

import dto.BookDto;
import services.BookService;

public class BookGetByIdController {
	public static void main(String[] args) {
		BookService bookService = new BookService();
		BookDto b = bookService.getBookById(1);
		System.out.println(b);
	}

}

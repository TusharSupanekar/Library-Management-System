package controller;

import services.LibrarianService;

public class ReturnBookController {
	public static void main(String[] args) {
		LibrarianService librarianService = new LibrarianService();
		librarianService.returnBookById(1);
	}
}

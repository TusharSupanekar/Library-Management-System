package controller;

import services.LibrarianService;

public class LibrarianDeleteController {
	public static void main(String[] args) {
		LibrarianService librarianService = new LibrarianService();
		boolean librarian = librarianService.deleteLibrarianById(1);
		System.out.println(librarian);
	}

}

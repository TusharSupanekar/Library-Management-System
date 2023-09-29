package controller;

import services.LibrarianService;

public class LibrarianUpdateController {
	public static void main(String[] args) {
		LibrarianService librarianService = new LibrarianService();
		boolean librarian = librarianService.updateLibrarian(2, "Librarian123@mail.com");
		System.out.println(librarian);
	}

}

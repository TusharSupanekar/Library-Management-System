package controller;

import dto.LibrarianDto;
import services.LibrarianService;

public class LibrarianGetByIdController {
	public static void main(String[] args) {
		LibrarianService librarianService = new LibrarianService();
		LibrarianDto librarian = librarianService.getLibrarianById(2);
		System.out.println(librarian);
	}

}

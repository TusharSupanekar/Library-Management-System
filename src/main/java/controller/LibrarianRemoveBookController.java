package controller;

import services.LibrarianService;

public class LibrarianRemoveBookController {
	public static void main(String[] args) {
		LibrarianService librarianService=new LibrarianService();
		librarianService.removeBookById(1);
	}
}

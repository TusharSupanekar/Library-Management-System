package controller;

import services.LibrarianService;

public class StudentRequestBookController {
	public static void main(String[] args) {
		LibrarianService librarianService= new LibrarianService();
		librarianService.requestBook(3, 3, 3);
	}

}

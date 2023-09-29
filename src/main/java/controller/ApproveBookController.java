package controller;

import services.LibrarianService;

public class ApproveBookController {
	public static void main(String[] args) {
		LibrarianService librarianService = new LibrarianService();
		librarianService.issueBookById(3, 3, 3);
	}

}

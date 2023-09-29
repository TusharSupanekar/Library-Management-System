package controller;

import services.LibrarianService;

public class LibrarianLoginController {
	public static void main(String[] args) {
		LibrarianService librarianService = new LibrarianService();
		boolean a = librarianService.loginLibrarian (2, "Librarian123@mail.com", "12341234","Unauthorized");
		System.out.println(a);
	}

}

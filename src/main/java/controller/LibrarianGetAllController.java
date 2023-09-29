package controller;

import java.util.List;

import dto.LibrarianDto;
import services.LibrarianService;

public class LibrarianGetAllController {
	public static void main(String[] args) {
		LibrarianService librarianService = new LibrarianService();
		List<LibrarianDto> a = librarianService.getAllLibrarianDto();
		for (LibrarianDto librarian : a) {
			System.out.println(librarian.getId() + " " + librarian.getUser_name() + " " + librarian.getPassword()+ " "+ librarian.getStatus());
			System.out.println("================");

		}
	}

}

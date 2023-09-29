package controller;

import dto.LibrarianDto;
import services.LibrarianService;

public class LibrarianSaveController {
	public static void main(String[] args) {
		LibrarianDto librarianDto = new LibrarianDto();
		librarianDto.setUser_name("lib_5@mail.com");
		librarianDto.setPassword("12341234");
		librarianDto.setStatus("Authorized");

		LibrarianService librarianService = new LibrarianService();
		LibrarianDto librarian = librarianService.saveLibrarian(librarianDto);
		if (librarian != null) {
			System.out.println(librarian.getId() + " ");
		}
	}

}

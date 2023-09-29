package controller;

import dto.BookDto;
import services.LibrarianService;

public class IssueBookController {
	public static void main(String[] args) {
		LibrarianService librarianService = new LibrarianService();
		BookDto bookDto = new BookDto();
		bookDto.setStatus("Issued");
		boolean res = librarianService.issueBookById(3, 3, 3);

		System.out.println(res);
	}
}

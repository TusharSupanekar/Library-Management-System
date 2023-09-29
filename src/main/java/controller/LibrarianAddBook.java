package controller;

import dto.BookDto;
import services.BookService;

public class LibrarianAddBook {
	public static void main(String[] args) {
		BookService bookService = new BookService();
		BookDto bookDto = new BookDto();
		bookDto.setTitle("Ikigai");
		bookDto.setAuthor_name("Francesc Miralles and Hector Garcia");
		bookService.saveBook(bookDto);
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

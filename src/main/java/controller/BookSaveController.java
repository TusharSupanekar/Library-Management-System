package controller;

import dto.BookDto;
import services.BookService;

public class BookSaveController {
	public static void main(String[] args) {
		BookService bookService = new BookService();
		BookDto bookDto = new BookDto();
		bookDto.setTitle("The Time Machine");
		bookDto.setAuthor_name("H.G Wells");
		bookDto.setStatus("issued");

		BookDto book = bookService.saveBook(bookDto);
		if (book != null) {
			System.out.println(book.getId() + " ");
		}
	}

}

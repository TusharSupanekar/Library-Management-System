package controller;

import java.util.List;

import dto.BookDto;
import services.BookService;

public class BookGetAllController {
	public static void main(String[] args) {
		BookService bookService = new BookService();
		List<BookDto> b = bookService.getAllBook();
		for (BookDto bookDto : b) {
			System.out.println(bookDto.getId() + " " + bookDto.getTitle() + " " + bookDto.getAuthor_name());
			System.out.println("====================");
		}
	}
}

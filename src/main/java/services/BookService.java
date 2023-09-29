package services;

import java.util.List;

import dao.BookDao;
import dto.BookDto;

public class BookService {
	BookDao bookDao = new BookDao();

	public BookDto saveBook(BookDto bookDto) {
		bookDto.setStatus("Available");
		BookDto s = bookDao.saveBook(bookDto);
		return s;
	}

	public boolean updateBookById(int id, String title,String author_name) {
		boolean s = bookDao.updateBookById(id, title, author_name);
		return s;
	}

	public boolean deleteBookById(int id) {
		boolean s = bookDao.deleteBookById(id);
		return s;
	}

	public BookDto getBookById(int id) {
		BookDto s = bookDao.getBookById(id);
		return s;
	}

	public List<BookDto> getAllBook() {
		List<BookDto> s = bookDao.getAllBook();
		return s;
	}
	
	public boolean updateLibrarianId(int librarian_id,int book_id) {
		BookDao bookDao=new BookDao();
		boolean res =bookDao.updateLibrarianId(librarian_id, book_id);
		System.out.println(res);
		return res;
	}
	
	public boolean addBook(String title, String author,int id) {
		BookDao bookDao=new BookDao();
		boolean res = bookDao.addBook(title, author, id);
		return res;
	}




	

}

package services;

import java.util.List;

import dao.BookDao;
import dao.LibrarianDao;
import dao.StudentDao;
import dto.BookDto;
import dto.LibrarianDto;
import dto.StudentDto;

public class LibrarianService {
	LibrarianDao librarianDao = new LibrarianDao();

	// save librarian
	public LibrarianDto saveLibrarian(LibrarianDto librarianDto) {
		librarianDto.setStatus("Unauthorized");
		LibrarianDto e = librarianDao.saveLibrarian(librarianDto);
		return e;
	}

	// get librarian by id
	public boolean deleteLibrarianById(int id) {
		LibrarianDao librarianDao = new LibrarianDao();
		boolean e = librarianDao.deleteLibrarianById(id);
		return e;
	}

	public LibrarianDto getLibrarianById(int id) {
		LibrarianDao librarianDao = new LibrarianDao();
		LibrarianDto e = librarianDao.getLibrarianById(id);
		return e;
	}

	// update librarian
	public boolean updateLibrarian(int id, String User_name) {
		LibrarianDao librarianDao = new LibrarianDao();
		boolean e = librarianDao.updateLibrarian(id, User_name);
		return e;
	}

	// get all librarian
	public List<LibrarianDto> getAllLibrarianDto() {
		LibrarianDao librarianDao = new LibrarianDao();
		List<LibrarianDto> e = librarianDao.getAllLibrarianDto();
		return e;
	}

	// Login method
	public boolean loginLibrarian(int id, String User_name, String Password, String status) {
		LibrarianDto a = librarianDao.getLibrarianLoginById(id);
		if (a != null && a.getUser_name().equals(User_name) && a.getPassword().equals(Password)
				&& a.getStatus().equals(status)) {
			return true;
		} else {
			return false;
		}
	}

	// to update admin id
	public boolean updateAdminId(int librarian_id, int admin_id) {
		LibrarianDao librarianDao = new LibrarianDao();
		boolean res = librarianDao.updateAdminId(librarian_id, admin_id);
		return res;
	}

	// to set status
	public boolean setLibrarianStatus(int librarian_id, String status) {
		LibrarianDao librarianDao = new LibrarianDao();
		boolean res = librarianDao.setLibrarianStatus(librarian_id, status);
		return res;
	}

	// librarian add book
	public Boolean addBook(BookDto bookDto) {
		BookDao bookDao = new BookDao();
		bookDao.saveBook(bookDto);
		return true;
	}

	// librarian remove book
	public Boolean removeBookById(int bookid) {
		BookDao bookDao = new BookDao();
		bookDao.deleteBookById(bookid);
		return true;
	}

	// Issue book
	BookDto bookDto = new BookDto();
	public boolean issueBookById(int bookid, int librarian_id, int student_id) {
		BookDao bookDao = new BookDao();
		StudentDao studentDao = new StudentDao();
		BookDto bookDto = bookDao.getBookById(bookid);
		StudentDto studentDto = studentDao.getStudentById(student_id);
		LibrarianDto librarianDto = librarianDao.getLibrarianById(librarian_id);
		if (librarianDto != null && bookDto != null && studentDto != null) {
			if(bookDto.getStatus().equalsIgnoreCase("Available") || bookDto.getStatus().equalsIgnoreCase("Requested")) {
				if(librarianDto.getStatus().equalsIgnoreCase("Authorized")) {
			bookDto.setStatus("Issued");
			bookDto.setStudentDto(studentDto);
			bookDto.setLibrarianDto(librarianDto);
			return bookDao.issue(bookDto);
		}
		}
		}		
		return false;
	}

	// return book
	public boolean returnBookById(int bookid) {
		BookDao bookDao = new BookDao();
		BookDto bookDto = bookDao.getBookById(bookid);
		if (bookDto != null && bookDto.getStatus().equals("Issued")) {
			StudentDto studentDto = bookDto.getStudentDto();
			LibrarianDto librarianDto = bookDto.getLibrarianDto();

			if (studentDto != null && librarianDto != null) {
				bookDto.setStatus("Available");
				bookDto.setStudentDto(null);
				bookDto.setLibrarianDto(null);
				return bookDao.returnBook(bookDto);
			}
		}
		return false;
	}

	// request book
	public boolean requestBook(int book_id, int librarian_id, int student_id) {
		BookDao bookDao = new BookDao();
		StudentDao studentDao = new StudentDao();
		BookDto bookDto = bookDao.getBookById(book_id);
		StudentDto studentDto=studentDao.getStudentById(student_id);
		LibrarianDto librarianDto = librarianDao.getLibrarianById(librarian_id);

		if (librarianDto != null && bookDto != null && studentDto != null) {
			if(bookDto.getStatus().equalsIgnoreCase("Available")) {
			bookDto.setStatus("Requested");
			bookDto.setStudentDto(studentDto);
			bookDto.setLibrarianDto(librarianDto);
			return bookDao.requestBook(bookDto);
		}else {
			System.out.println("This Book is Un-available");
		}
		}
		return false;
	}

}

package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.BookDto;
import dto.LibrarianDto;

public class BookDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tushar");

	EntityManager entityManager = entityManagerFactory.createEntityManager();

	EntityTransaction entityTransaction = entityManager.getTransaction();

	// to save Book
	public BookDto saveBook(BookDto bookDto) {
		entityTransaction.begin();
		entityManager.persist(bookDto);
		entityTransaction.commit();
		return bookDto;
	}

	public boolean updateBookById(int id, String title, String author_name) {
		BookDto bookDto = entityManager.find(BookDto.class, id);
		bookDto.setTitle(title);
		bookDto.setAuthor_name(author_name);
		entityTransaction.begin();
		entityManager.merge(bookDto);
		entityTransaction.commit();
		if (id > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteBookById(int id) {
		BookDto bookDto = entityManager.find(BookDto.class, id);
		if (bookDto != null) {
			entityTransaction.begin();
			entityManager.merge(bookDto);
			entityTransaction.commit();
		} else {
			System.out.println("Not Deleted");
		}
		if (id > 0) {
			return true;
		} else {
			return false;
		}
	}

	public BookDto getBookById(int id) {
		BookDto bookDto = entityManager.find(BookDto.class, id);
		return bookDto;
	}

	public List<BookDto> getAllBook() {
		String sql = "SELECT e FROM BookDto e";
		Query query = entityManager.createQuery(sql);
		List<BookDto> bookDto = query.getResultList();
		return bookDto;
	}
	
	//to add librarian id
			public boolean updateLibrarianId(int librarian_id,int book_id) {
				LibrarianDto librarianDto = entityManager.find(LibrarianDto.class, librarian_id);
				BookDto bookDto=entityManager.find(BookDto.class, book_id);
				bookDto.setLibrarianDto(librarianDto);
				entityTransaction.begin();
				entityManager.merge(bookDto);
				entityManager.merge(librarianDto);
				entityTransaction.commit();
				LibrarianDto l = entityManager.find(LibrarianDto.class, librarian_id);
				if(l.getBookDto()!=null) {
					return true;
				}else {
					return false;
				}
			}

//			// librarian add book
			public boolean addBook(String title, String author,int librarian_id) {
				LibrarianDto librarianDto=entityManager.find(LibrarianDto.class, librarian_id);
				BookDto bookDto = new BookDto();
				librarianDto.setBookDto(bookDto);
				bookDto.setTitle(title);
				bookDto.setAuthor_name(author);
				entityTransaction.begin();
				entityManager.merge(bookDto);
				entityTransaction.commit();

				if (bookDto.getTitle() != null) {
					return true;
				} else {
					return false;
				}
			}
			
			public boolean issue(BookDto bookDto) {
				entityTransaction.begin();
				entityManager.merge(bookDto);
				entityTransaction.commit();
				return true;

			}

			public boolean returnBook(BookDto bookDto) {
				entityTransaction.begin();
				entityManager.merge(bookDto);
				entityTransaction.commit();
				return true;
			}
			
			public boolean requestBook(BookDto bookDto) {
				entityTransaction.begin();
				entityManager.merge(bookDto);
				entityTransaction.commit();
				return true;
				
			}

	
}

package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.AdminDto;
import dto.LibrarianDto;

public class LibrarianDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tushar");

	EntityManager entityManager = entityManagerFactory.createEntityManager();

	EntityTransaction entityTransaction = entityManager.getTransaction();

	// To save librarian
	public LibrarianDto saveLibrarian(LibrarianDto librarianDto) {

		entityTransaction.begin();
		entityManager.persist(librarianDto);
		entityTransaction.commit();
		return librarianDto;
	}

	// To delete librarianById
	public boolean deleteLibrarianById(int id) {
		LibrarianDto librarianDto = entityManager.find(LibrarianDto.class, id);
		if (librarianDto != null) {
			entityTransaction.begin();
			entityManager.remove(librarianDto);
			entityTransaction.commit();
		} else {
			System.out.println("Not deleted");
		}
		if (id > 0) {
			return true;
		} else {
			return false;
		}

	}

	// to update librarian by id
	public boolean updateLibrarian(int id, String User_name) {
		LibrarianDto librarianDto = entityManager.find(LibrarianDto.class, id);
		librarianDto.setUser_name(User_name);
		entityTransaction.begin();
		entityManager.merge(librarianDto);
		entityTransaction.commit();
		if (id > 0) {
			return true;
		} else {
			return false;
		}
	}

	// to get librarian by id
	public LibrarianDto getLibrarianById(int id) {
		LibrarianDto librarianDto = entityManager.find(LibrarianDto.class, id);
		return librarianDto;
	}

	// to get all librarian
	public List<LibrarianDto> getAllLibrarianDto() {
		String sql = "SELECT e FROM LibrarianDto e";
		Query query = entityManager.createQuery(sql);
		List<LibrarianDto> librarianDto = query.getResultList();
		return librarianDto;
	}

	// librarian login by id
	public LibrarianDto getLibrarianLoginById(int id) {
		LibrarianDto librarianDto = entityManager.find(LibrarianDto.class, id);
		return entityManager.find(LibrarianDto.class, id);
	}

	// to update admin id
	public boolean updateAdminId(int librarian_id, int admin_id) {
		LibrarianDto librarianDto = entityManager.find(LibrarianDto.class, librarian_id);
		AdminDto adminDto = entityManager.find(AdminDto.class, admin_id);
		librarianDto.setAdminDto(adminDto);
		entityTransaction.begin();
		entityManager.merge(librarianDto);
		entityTransaction.commit();
		LibrarianDto l = entityManager.find(LibrarianDto.class, librarian_id);

		if (l.getAdminDto() != null) {
			return true;
		} else {
			return false;
		}
	}

	// to update status
	public boolean setLibrarianStatus(int librarian_id, String status) {
		LibrarianDto librarianDto = entityManager.find(LibrarianDto.class, librarian_id);
		librarianDto.setStatus(status);
		entityTransaction.begin();
		entityManager.merge(librarianDto);
		entityTransaction.commit();
		LibrarianDto l = entityManager.find(LibrarianDto.class, librarian_id);
		if (l.getStatus() == status) {
			return true;
		} else {
			return false;
		}
	}

	public boolean approveReject(LibrarianDto librarianDto) {
		entityTransaction.begin();
		entityManager.merge(librarianDto);
		entityTransaction.commit();
		return true;
	}

}

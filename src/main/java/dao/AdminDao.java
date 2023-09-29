package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import dto.AdminDto;
import dto.LibrarianDto;

public class AdminDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tushar");

	EntityManager entityManager = entityManagerFactory.createEntityManager();

	EntityTransaction entityTransaction = entityManager.getTransaction();

	// To save admin
	public AdminDto saveAdmin(AdminDto adminDto) {

		entityTransaction.begin();
		entityManager.persist(adminDto);
		entityTransaction.commit();
		return adminDto;
	}

	// To delete adminById
	public boolean deleteAdminById(int id) {
		AdminDto adminDto = entityManager.find(AdminDto.class, id);
		if (adminDto != null) {
			entityTransaction.begin();
			entityManager.remove(adminDto);
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

	// to update admin by id
	public boolean updateAdmin(int id, String User_name) {
		AdminDto adminDto = entityManager.find(AdminDto.class, id);
		adminDto.setUser_name(User_name);
		entityTransaction.begin();
		entityManager.merge(adminDto);
		entityTransaction.commit();
		if (id > 0) {
			return true;
		} else {
			return false;
		}
	}

	// to get admin by id
	public boolean getAdminById(int id) {
		AdminDto adminDto = entityManager.find(AdminDto.class, id);
		System.out.println(adminDto.getId());
		System.out.println(adminDto.getUser_name());
		System.out.println(adminDto.getPassword());
		if (id > 0) {
			return true;
		} else {
			return false;
		}
	}

	// to get all admin
	public List<AdminDto> getAllAdminDto() {
		String sql = "SELECT e FROM AdminDto e";
		Query query = entityManager.createQuery(sql);
		List<AdminDto> adminDto = query.getResultList();
		return adminDto;
	}

	// adminlogin by id
	public AdminDto getAdminLoginById(int id) {
		AdminDto adminDto = entityManager.find(AdminDto.class, id);
		System.out.println(adminDto.getId());
		System.out.println(adminDto.getUser_name());
		System.out.println(adminDto.getPassword());
		return entityManager.find(AdminDto.class, id);
	}

	// get librarian data
	public void getLibrarianData(int id, String User_name, String Status) {
		LibrarianDao librarianDao = new LibrarianDao();
		librarianDao.getAllLibrarianDto();
	}

	// authorize librarian
	public boolean authorizeLibrarian(int id, String status) {
		LibrarianDto l = entityManager.find(LibrarianDto.class, id);
		l.setStatus(status);
		if (l != null) {
			entityTransaction.begin();
			entityManager.merge(l);
			entityTransaction.commit();

		}
		return false;
	}

}

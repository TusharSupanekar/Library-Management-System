package services;

import java.util.List;
import dao.AdminDao;
import dao.LibrarianDao;
import dto.AdminDto;
import dto.LibrarianDto;

public class AdminService {
	AdminDao adminDao = new AdminDao();

	public AdminDto saveAdmin(AdminDto adminDto) {
		AdminDto e = adminDao.saveAdmin(adminDto);
		return e;
	}

	public boolean deleteAdminById(int id) {
		AdminDao adminDao = new AdminDao();
		boolean e = adminDao.deleteAdminById(id);
		return e;
	}

	public boolean getAdminById(int id) {
		AdminDao adminDao = new AdminDao();
		boolean e = adminDao.getAdminById(id);
		return e;
	}

	public boolean updateAdmin(int id, String User_name) {
		AdminDao adminDao = new AdminDao();
		boolean e = adminDao.updateAdmin(id, User_name);
		return e;
	}

	public List<AdminDto> getAllAdminDto() {
		AdminDao adminDao = new AdminDao();
		List<AdminDto> e = adminDao.getAllAdminDto();
		return e;
	}
	
	//Login method
	public boolean loginAdmin(int id,String User_name,String Password) {
		AdminDto a=adminDao.getAdminLoginById(id);
		if(a!=null && a.getUser_name().equals(User_name) && a.getPassword().equals(Password)) {
			return true;
		}else {
			return false;
		}

	}
	
	public void getLibrarianData() {
		LibrarianDao librarianDao=new LibrarianDao();
		List<LibrarianDto> l=librarianDao.getAllLibrarianDto();
		for (LibrarianDto librarian : l) {
			if(librarian.getStatus().equals("Unauthorized")) {
				System.out.println(librarian.getId() + " " + librarian.getUser_name() + " " + librarian.getPassword()+ " "+ librarian.getStatus());
				System.out.println("================");
			}		
		}
	}


	public boolean authorizeLibrarian(int id,String status,int admin_id) {
		AdminDao adminDao=new AdminDao();
		LibrarianService librarianService =new LibrarianService();
		librarianService.updateAdminId(id, admin_id);
		librarianService.setLibrarianStatus(id, status);
		return adminDao.authorizeLibrarian(id, status);
	}


}

package controller;

import services.AdminService;

public class AdminAuthorizeLibrarianController {
	public static void main(String[] args) {
		AdminService adminService=new AdminService();
		adminService.authorizeLibrarian(2, "Authorized", 2);	
	}
}

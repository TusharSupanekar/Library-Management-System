package controller;


import services.AdminService;

public class AdminGetLibrarianController {
	public static void main(String[] args) {
		AdminService adminService=new AdminService();
		adminService.getLibrarianData();
	}

}

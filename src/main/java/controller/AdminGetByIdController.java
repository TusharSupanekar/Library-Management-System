package controller;

import services.AdminService;

public class AdminGetByIdController {
	public static void main(String[] args) {
		AdminService adminService = new AdminService();
		boolean admin = adminService.getAdminById(2);
		System.out.println(admin);
	}

}

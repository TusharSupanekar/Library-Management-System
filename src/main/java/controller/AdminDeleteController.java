package controller;

import services.AdminService;

public class AdminDeleteController {
	public static void main(String[] args) {
		AdminService adminService = new AdminService();
		boolean admin = adminService.deleteAdminById(1);
		System.out.println(admin);
	}

}

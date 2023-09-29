package controller;

import services.AdminService;

public class AdminUpdateController {
	public static void main(String[] args) {
		AdminService adminService = new AdminService();
		boolean admin = adminService.updateAdmin(2, "Admin123@mail.com");
		System.out.println(admin);
	}

}

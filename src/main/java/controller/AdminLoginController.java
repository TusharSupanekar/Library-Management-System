package controller;

import services.AdminService;

public class AdminLoginController {
	public static void main(String[] args) {
		AdminService adminService=new AdminService();
		boolean a=adminService.loginAdmin(2, "admin_2@mail.com", "43214321");
		System.out.println(a);
	}

}

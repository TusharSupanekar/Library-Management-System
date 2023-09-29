package controller;

import dto.AdminDto;
import services.AdminService;

public class AdminSaveController {
	public static void main(String[] args) {
		AdminDto adminDto = new AdminDto();
		adminDto.setUser_name("admin_2@mail.com");
		adminDto.setPassword("43214321");

		AdminService adminService = new AdminService();
		AdminDto admin = adminService.saveAdmin(adminDto);
		if (admin != null) {
			System.out.println(admin.getId() + " ");
		}
	}

}

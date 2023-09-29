package controller;

import java.util.List;
import dto.AdminDto;
import services.AdminService;

public class AdminGetAllController {
	public static void main(String[] args) {
		AdminService adminService = new AdminService();
		List<AdminDto> a = adminService.getAllAdminDto();
		for (AdminDto admin : a) {
			System.out.println(admin.getId() + " " + admin.getUser_name() + " " + admin.getPassword());
			System.out.println("================");

		}

	}

}

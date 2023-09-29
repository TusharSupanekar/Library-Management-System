package controller;

import services.StudentService;

public class StudentUpdateController {
	public static void main(String[] args) {
		StudentService studentService = new StudentService();
		boolean s = studentService.updateStudentById(1, "tushar@mail.com");
		System.out.println(s);
	}

}

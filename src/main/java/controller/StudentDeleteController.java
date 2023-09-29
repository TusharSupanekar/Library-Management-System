package controller;

import services.StudentService;

public class StudentDeleteController {
	public static void main(String[] args) {
		StudentService studentService=new StudentService();
		boolean s =studentService.deleteStudentById(2);
		System.out.println(s);
	}

}

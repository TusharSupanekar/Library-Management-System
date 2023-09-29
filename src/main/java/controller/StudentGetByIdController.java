package controller;

import dto.StudentDto;
import services.StudentService;

public class StudentGetByIdController {
	public static void main(String[] args) {
		StudentService studentService =new StudentService();
		StudentDto s=studentService.getStudentById(1);
		System.out.println(s);
	}

}

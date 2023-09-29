package controller;

import java.util.List;

import dto.StudentDto;
import services.StudentService;

public class StudentGetAllController {
	public static void main(String[] args) {
		StudentService studentService = new StudentService();
		List<StudentDto> s = studentService.getAllStudent();
		for (StudentDto studentDto : s) {
			System.out.println(studentDto.getId() + " " + studentDto.getEmail() + " " + studentDto.getCno());
			System.out.println("====================");
		}
	}

}

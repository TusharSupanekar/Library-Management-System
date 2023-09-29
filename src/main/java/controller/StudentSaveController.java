package controller;

import dto.StudentDto;
import services.StudentService;

public class StudentSaveController {
	public static void main(String[] args) {
		StudentService studentService=new StudentService();
		StudentDto studentDto=new StudentDto();
		studentDto.setEmail("Student_3@mail.com");
		studentDto.setCno(9876543210l);
		
		StudentDto stu=studentService.saveStudent(studentDto);
		if(stu !=null) {
			System.out.println(stu.getId()+" ");
		}
	}

}

package services;

import java.util.List;

import dao.StudentDao;
import dto.StudentDto;

public class StudentService {

	StudentDao studentDao = new StudentDao();

	public StudentDto saveStudent(StudentDto studentDto) {
		StudentDto s = studentDao.saveStudent(studentDto);
		return s;
	}

	public boolean updateStudentById(int id, String Email) {
		boolean s = studentDao.updateStudentById(id, Email);
		return s;
	}

	public boolean deleteStudentById(int id) {
		boolean s = studentDao.deleteStudentById(id);
		return s;
	}

	public StudentDto getStudentById(int id) {
		StudentDto s = studentDao.getStudentById(id);
		return s;
	}

	public List<StudentDto> getAllStudent() {
		List<StudentDto> s = studentDao.getAllStudent();
		return s;
	}

}

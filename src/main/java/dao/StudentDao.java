package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.StudentDto;

public class StudentDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tushar");

	EntityManager entityManager = entityManagerFactory.createEntityManager();

	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	//to save Student
	public StudentDto saveStudent(StudentDto studentDto) {
		entityTransaction.begin();
		entityManager.persist(studentDto);
		entityTransaction.commit();
		return studentDto;
	}
	
	public boolean updateStudentById(int id,String Email) {
		StudentDto studentDto=entityManager.find(StudentDto.class,id);
		studentDto.setEmail(Email);
		entityTransaction.begin();
		entityManager.merge(studentDto);
		entityTransaction.commit();
		if(id>0) {
			return true;	
		}else {
			return false;
		}
	}
	
	public boolean deleteStudentById(int id) {
		StudentDto studentDto=entityManager.find(StudentDto.class, id);
		if(studentDto!=null) {
			entityTransaction.begin();
			entityManager.merge(studentDto);
			entityTransaction.commit();
		}else {
			System.out.println("Not Deleted");
		}
		if (id > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public StudentDto getStudentById(int id) {
		StudentDto studentDto=entityManager.find(StudentDto.class, id);
		return studentDto;
		
	}
	
	public List<StudentDto> getAllStudent() {
		String sql = "SELECT e FROM StudentDto e";
		Query query = entityManager.createQuery(sql);
		List<StudentDto> studentDto=query.getResultList();
		return studentDto;
	}
}

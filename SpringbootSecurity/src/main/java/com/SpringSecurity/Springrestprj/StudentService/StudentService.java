package com.SpringSecurity.Springrestprj.StudentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.SpringSecurity.Springrestprj.StudentRepository.StudentRepository;
import com.SpringSecurity.Springrestprj.model.Student;


@Component
public class StudentService {
	@Autowired
	private StudentRepository studentRepo;
	
	public Student saveStudent( Student student) {
		return studentRepo.save(student);
	}
	
	public Student updateStudent(Student std, long id) {
		std.setId(id); // Ensure this correctly sets the ID
	    studentRepo.save(std); // This saves the updated employee
	    System.out.println("Student with id : " + id + " is updated successfully..");
	    return std;
	}

	public List<Student> getAllStudentList(){
		return studentRepo.findAll();
	}
	public Student getStudent(int id) {
		return studentRepo.getById(id);
	}
	public void deleteStudent(int id) {
		studentRepo.deleteById(id);
	}
}
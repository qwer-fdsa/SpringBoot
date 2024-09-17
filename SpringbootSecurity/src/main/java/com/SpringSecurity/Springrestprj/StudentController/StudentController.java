package com.SpringSecurity.Springrestprj.StudentController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringSecurity.Springrestprj.StudentService.StudentService;
import com.SpringSecurity.Springrestprj.model.Student;

@RestController
@RequestMapping("/clg")
public class StudentController {
	@Autowired
	private StudentService studentService;
	@GetMapping("/student")
	public List<Student> getAllStudents() {
		return studentService.getAllStudentList();
	}

	@PostMapping("/studentpost")
	public Student save(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}

	@PutMapping("/update/{id}")
	public Student update(@PathVariable("id") int roll, @RequestBody Student student) {
		return studentService.updateStudent(student, roll);
	}

		@DeleteMapping("/studentdel/{id}")
		public String deleteStudent(@PathVariable int id) {
			this.studentService.deleteStudent(id);
			return "Student with ID " + id + " has been deleted";
		}
}/
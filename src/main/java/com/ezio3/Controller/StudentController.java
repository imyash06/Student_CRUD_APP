package com.ezio3.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ezio3.Model.Student;
import com.ezio3.Service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService service;

	public StudentController(StudentService service) {
		super();
		this.service = service;
	}

	@PostMapping("/addstudent")
	public ResponseEntity<Student> createNewStudent(@RequestBody Student student) {

		//System.err.println("  check save value   " + student);
		Student s1 = service.createStudent(student);
		return new ResponseEntity<Student>(s1, HttpStatus.CREATED);
	}

	@GetMapping("/readstudent")
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> s3 = new ArrayList<>();
		s3 = service.getAll();
		return new ResponseEntity<List<Student>>(s3, HttpStatus.OK);
	}

	@GetMapping("/read/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Long studentid) {
		Student s4 = service.getStudentById(studentid);
		return new ResponseEntity<>(s4, HttpStatus.OK);
	}

	@DeleteMapping("/deletestudent/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") Long studentid) {
		service.Studentid(studentid);
		return new ResponseEntity<>("Student successfully deleted!", HttpStatus.OK);
	} 

	@PostMapping("/updatestudent/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") Long studentid, @RequestBody Student s5) {
		s5.setId(studentid); 
		Student updateStudent = service.createStudent(s5);
		return new ResponseEntity<>(updateStudent, HttpStatus.OK);// we can access this status code from server and
																	// updateSt
	}

}

package com.ezio3.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezio3.Model.Student;
import com.ezio3.Repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository repo;

	public Student createStudent(Student student) { // save
		return repo.save(student);
	}

	public List<Student> getAll() {
		List<Student> student = (List<Student>) repo.findAll(); // getAll
		return student;
	}

	public Student getStudentById(Long studentid) {
		return repo.findById(studentid).get(); // getById
	}
	

	public void Studentid(Long studentid) {
		repo.deleteById(studentid);// it will delete particular id.
	}

}

package com.ezio3.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ezio3.Model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long >{

}

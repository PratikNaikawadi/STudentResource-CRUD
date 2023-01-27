package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.StudentRepository;
import com.example.student.Student;

@Service
public class StudentService {
 
	@Autowired
	private StudentRepository studentRepository;

	public Iterable<Student> getStudents() {
	return this.studentRepository.findAll();
	}
	
	public Student addStudent(Student student) {
	return this.studentRepository.save(student);
	}

	public Student updateStudent(Integer id, Student student) {
		student.setId(id);
		return this.studentRepository.save(student);
	}
	
	public String deleteStudent(Integer id) {
		if(this.getStudent(id)== null) {
			return null;
		}else {
			this.studentRepository.deleteById(id);
			return "user object deleted";
		}
	}
	
	public Student getStudent(Integer id) {
		return this.studentRepository.findById(id).orElse(null);
	}


}

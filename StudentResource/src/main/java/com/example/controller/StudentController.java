package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.StudentService;
import com.example.student.Student;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	@GetMapping("/student")
	public Iterable<Student> getStudent() {
		return this.studentService.getStudents();
	}
	
	
	@PostMapping("/student")
	public Student addStudent(@RequestBody Student student) {
		return this.studentService.addStudent(student); 
	} 
	
	
	@PutMapping("/student/{id}")
	public ResponseEntity<?> updateStudent(@RequestBody Student student, @PathVariable Integer id){
		Student found = this.studentService.getStudent(id);
		if(found == null) {
			return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(this.studentService.updateStudent(id, student),HttpStatus.OK);
		}
	}
	
	
	@DeleteMapping("/student/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable Integer id){
		String message = this.studentService.deleteStudent(id);
		if(message == null) {
			return new ResponseEntity<>("user not found", HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(message , HttpStatus.OK);
		}
	}

	
	
}






























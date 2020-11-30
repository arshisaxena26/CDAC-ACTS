package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Student;
import com.app.service.IStudentService;

@RestController
@CrossOrigin("http://localhost:4200")
public class StudentController {

	@Autowired
	private IStudentService studentService;

	@PostMapping("/create")
	public ResponseEntity<?> createNewStudentRecord(@RequestBody Student s) {
		try {
			return new ResponseEntity<>(studentService.createNewStudentRecord(s), HttpStatus.CREATED);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/students")
	public ResponseEntity<?> getAllStudents() {
		List<Student> studentList = studentService.getAllStudents();
		if (studentList.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(studentList, HttpStatus.OK);
	}

	@GetMapping("/student/{studentId}")
	public ResponseEntity<?> getStudentById(@PathVariable int studentId) {
		Student student = studentService.getStudentById(studentId);
		if (student == null)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
}

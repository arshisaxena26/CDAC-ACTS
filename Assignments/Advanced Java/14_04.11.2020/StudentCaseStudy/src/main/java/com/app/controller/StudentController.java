package com.app.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Student;
import com.app.service.IStudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private IStudentService studentService;

	@GetMapping
	public ResponseEntity<?> getAllStudents() {
		List<Student> studentList = studentService.getAllStudents();
		if (studentList.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(studentList, HttpStatus.OK);
	}

	@GetMapping("/{specified_date}")
	public ResponseEntity<?> getStudentsByDob(
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate specified_date) {
		List<Student> studentList = studentService.getStudentsByDob(specified_date);
		if (studentList.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(studentList, HttpStatus.OK);
	}

	@GetMapping("/last_name/{prefix}")
	public ResponseEntity<?> getStudentsWithSameLastnamePrefix(@PathVariable String prefix) {
		List<Student> studentList = studentService.getStudentsWithSameLastnamePrefix(prefix);
		if (studentList.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(studentList, HttpStatus.OK);
	}

	@GetMapping("/marks")
	public ResponseEntity<?> getStudentsByMarks(@RequestParam int begin, @RequestParam int end) {
		List<Student> studentList = studentService.getStudentsByMarks(begin, end);
		if (studentList.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(studentList, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<?> createNewStudentRecord(@RequestBody Student s) {
		try {
			return new ResponseEntity<>(studentService.createNewStudentRecord(s), HttpStatus.CREATED);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStudentRecord(@PathVariable int id) {
		try {
			return new ResponseEntity<>(studentService.deleteStudentRecord(id), HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateStudentRecord(@PathVariable int id, @RequestBody Student s) {
		try {
			return new ResponseEntity<>(studentService.updateStudentDetails(id, s), HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

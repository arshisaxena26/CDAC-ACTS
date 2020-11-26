package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Course;
import com.app.service.ICourseService;

@RestController
@CrossOrigin("http://localhost:4200")
public class CourseController {

	@Autowired
	private ICourseService courseService;

	@GetMapping("/courses")
	public ResponseEntity<?> getAllStudents() {
		List<Course> courseList = courseService.getAllCourses();
		if (courseList.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(courseList, HttpStatus.OK);
	}
}

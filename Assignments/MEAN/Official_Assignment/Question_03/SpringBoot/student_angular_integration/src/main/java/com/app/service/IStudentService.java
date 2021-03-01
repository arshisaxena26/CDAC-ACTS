package com.app.service;

import java.util.List;

import com.app.pojos.Student;

public interface IStudentService {
	List<Student> getAllStudents();

	Student createNewStudentRecord(Student s);

	Student getStudentById(int id);

}

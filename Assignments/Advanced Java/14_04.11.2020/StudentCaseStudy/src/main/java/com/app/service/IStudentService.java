package com.app.service;

import java.time.LocalDate;
import java.util.List;

import com.app.pojos.Student;

public interface IStudentService {
	List<Student> getAllStudents();

	List<Student> getStudentsByDob(LocalDate date);

	List<Student> getStudentsWithSameLastnamePrefix(String prefix);

	List<Student> getStudentsByMarks(int begin, int end);

	Student createNewStudentRecord(Student s);

	String deleteStudentRecord(int id);

	Student updateStudentDetails(int id, Student s);
}

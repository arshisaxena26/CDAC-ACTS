package com.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.StudentRepository;
import com.app.pojos.Student;

@Service
@Transactional
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository studentDao;

	@Override
	public List<Student> getAllStudents() {
		return studentDao.findAll();
	}

	@Override
	public List<Student> getStudentsByDob(LocalDate date) {
		return studentDao.findByDobGreaterThan(date);
	}

	@Override
	public List<Student> getStudentsWithSameLastnamePrefix(String prefix) {
		return studentDao.findByLastNameStartingWith(prefix);
	}

	@Override
	public List<Student> getStudentsByMarks(int begin, int end) {
		return studentDao.findByMarksBetween(begin, end);
	}

	@Override
	public Student createNewStudentRecord(Student s) {
		return studentDao.save(s);
	}

	@Override
	public String deleteStudentRecord(int id) {
		studentDao.deleteById(id);
		return "Student Deleted From Database";
	}

	@Override
	public Student updateStudentDetails(int id, Student s) {
		Student peristentStudent = null;
		Optional<Student> student = studentDao.findById(id);

		if (studentDao.findById(id).isPresent()) {
			peristentStudent = student.get();
		}

		peristentStudent.setMarks(s.getMarks());
		peristentStudent.setLastName(s.getLastName());

		return peristentStudent;
	}

}

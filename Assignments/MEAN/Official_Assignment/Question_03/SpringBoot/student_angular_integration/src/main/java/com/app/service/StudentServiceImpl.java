package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.StudentRepository;
import com.app.pojos.Student;

@Service
@Transactional
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository studentRepo;

	@Override
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

	@Override
	public Student createNewStudentRecord(Student s) {
		return studentRepo.save(s);
	}

	@Override
	public Student getStudentById(int id) {
		return studentRepo.findByStudentId(id);
	}
}

package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	List<Student> findAll();

	Student findByStudentId(Integer id);
}

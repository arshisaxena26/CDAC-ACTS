package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
	List<Course> findAll();

}

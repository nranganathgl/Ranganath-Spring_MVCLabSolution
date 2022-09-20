package com.gl.student.mgmt.service;

import java.util.List;

import com.gl.student.mgmt.entity.Student;

public interface StudentService {

	public List<Student> findAll();
	
	public void save(Student theStudent);

	public void updateById(int studentId);
	
	public void deleteById(int studentId);
	
	public Student getStudent(int studentId);
}

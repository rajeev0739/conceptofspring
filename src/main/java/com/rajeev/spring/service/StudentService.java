/**
 * 
 */
package com.rajeev.spring.service;

import java.util.List;

import com.rajeev.spring.model.Student;

/**
 * @author Rajeev
 *
 */
public interface StudentService {
	
	
	public void add(Student student);
	public void edit(Student student);
	public void delete(int studentId);
	public Student getStudent(int studentId);
	public List  getAllStudent();

}

package com.student.Service;

import java.util.List;

import com.student.Model.Student;

public interface StudentService {

	Student addStudent(Student student);

	List<Student> getAllStudents();

	Student getStudentById(Integer id);

	Student updateStudent(Integer id, Student updatedStudent);

	void deleteStudent(Integer id);
	
	List<Student> saveAllStudents(List<Student> students);

}

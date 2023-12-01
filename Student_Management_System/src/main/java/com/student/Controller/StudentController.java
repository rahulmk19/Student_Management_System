package com.student.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.Exception.StudentException;
import com.student.Model.Student;
import com.student.Service.StudentService;

@RestController
@CrossOrigin("*")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/student")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		try {
			Student addedStudent = studentService.addStudent(student);
			return new ResponseEntity<>(addedStudent, HttpStatus.CREATED);
		} catch (StudentException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/student")
	public ResponseEntity<List<Student>> getAllStudents() {
		try {
			List<Student> students = studentService.getAllStudents();
			return new ResponseEntity<>(students, HttpStatus.OK);
		} catch (StudentException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
		try {
			Student student = studentService.getStudentById(id);
			if (student != null) {
				return new ResponseEntity<>(student, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (StudentException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/student/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student updatedStudent) {
		try {
			Student updated = studentService.updateStudent(id, updatedStudent);
			return new ResponseEntity<>(updated, HttpStatus.OK);
		} catch (StudentException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/student/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {
		try {
			studentService.deleteStudent(id);
			return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
		} catch (StudentException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/addAllStudent")
	public ResponseEntity<String> saveAllStudents(@RequestBody List<Student> students) {
		try {
			List<Student> savedStudents = studentService.saveAllStudents(students);
			return new ResponseEntity<>("Saved " + savedStudents.size() + " students successfully", HttpStatus.CREATED);
		} catch (StudentException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

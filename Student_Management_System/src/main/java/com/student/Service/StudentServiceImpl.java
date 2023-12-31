package com.student.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.student.Exception.StudentException;
import com.student.Model.Student;
import com.student.Repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	private final StudentRepository studentRepo;

	public StudentServiceImpl(StudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}

	@Override
	public Student addStudent(Student student) {
		LocalDate currentDate = LocalDate.now();
		LocalDate fourYearsAgo = currentDate.minusYears(4);

		if (student.getDob().isAfter(fourYearsAgo)) {
			throw new StudentException("Student is not eligible for admission. Age must be at least 4 years.");
		}

		Optional<List<Student>> existingStudentOptional = studentRepo.findByPhone(student.getPhone());

		if (existingStudentOptional.isPresent()) {
			List<Student> existingStudents = existingStudentOptional.get();
			for (Student existingStudent : existingStudents) {
				if (existingStudent.getFirstName().equals(student.getFirstName())
						&& existingStudent.getLastName().equals(student.getLastName())) {
					throw new StudentException("Student already registered");
				}
			}
		}

		try {
			return studentRepo.save(student);
		} catch (Exception e) {
			throw new StudentException("Error occurred while adding a student.", e);
		}
	}

	@Override
	public List<Student> getAllStudents() {
		try {
			return studentRepo.findAll();
		} catch (Exception e) {
			throw new StudentException("Error occurred while retrieving students.", e);
		}
	}

	@Override
	public Student getStudentById(Integer id) {
		try {
			return studentRepo.findById(id).orElse(null);
		} catch (Exception e) {
			throw new StudentException("Error occurred while retrieving a student by ID.", e);
		}
	}

	@Override
	public Student updateStudent(Integer id, Student updatedStudent) {
		try {
			Student existingStudent = studentRepo.findById(id).orElse(null);
			if (existingStudent == null) {
				throw new StudentException("Student not found with ID: " + id);
			}

			LocalDate currentDate = LocalDate.now();
			LocalDate fourYearsAgo = currentDate.minusYears(4);

			if (updatedStudent.getDob().isAfter(fourYearsAgo)) {
				throw new StudentException(
						"Updated student is not eligible for admission. Age must be at least 4 years.");
			}

			existingStudent.setFirstName(updatedStudent.getFirstName());
			existingStudent.setLastName(updatedStudent.getLastName());
			existingStudent.setPhone(updatedStudent.getPhone());
			existingStudent.setDob(updatedStudent.getDob());
			existingStudent.setGender(updatedStudent.getGender());
			existingStudent.setAddress(updatedStudent.getAddress());

			return studentRepo.save(existingStudent);
		} catch (Exception e) {
			throw new StudentException(e.getMessage());
		}
	}

	@Override
	public void deleteStudent(Integer id) {
		try {
			studentRepo.deleteById(id);
		} catch (Exception e) {
			throw new StudentException("Error occurred while deleting a student.", e);
		}
	}

	@Override
	public List<Student> saveAllStudents(List<Student> students) {
		try {
			return studentRepo.saveAll(students);
		} catch (Exception e) {
			throw new StudentException("Error occurred while saving the list of students.", e);
		}
	}
}

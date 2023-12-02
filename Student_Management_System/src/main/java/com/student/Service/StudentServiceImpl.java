package com.student.Service;

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
	    // Check if a student with the same phone number already exists
	    Optional<List<Student>> existingStudentOptional = studentRepo.findByPhone(student.getPhone());

	    if (existingStudentOptional.isPresent()) {
	        List<Student> existingStudents = existingStudentOptional.get();
	        // Assuming you want to check all existing students for the same phone number
	        for (Student existingStudent : existingStudents) {
	            if (existingStudent.getFirstName().equals(student.getFirstName())
	                    && existingStudent.getLastName().equals(student.getLastName())) {
	                throw new StudentException("Student already registered");
	            }
	        }
	    }

	    // No existing student with the same phone number and name, proceed to save
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

			existingStudent.setFirstName(updatedStudent.getFirstName());
			existingStudent.setLastName(updatedStudent.getLastName());
			existingStudent.setPhone(updatedStudent.getPhone());
			existingStudent.setDob(updatedStudent.getDob());
			existingStudent.setGender(updatedStudent.getGender());
			existingStudent.setAddress(updatedStudent.getAddress());

			return studentRepo.save(existingStudent);
		} catch (Exception e) {
			throw new StudentException("Error occurred while updating a student.", e);
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

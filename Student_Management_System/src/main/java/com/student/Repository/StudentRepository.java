package com.student.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.Model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	public Optional<List<Student>> findByPhone(String phone);
}

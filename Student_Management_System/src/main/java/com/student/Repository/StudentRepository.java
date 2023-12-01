package com.student.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.Model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}

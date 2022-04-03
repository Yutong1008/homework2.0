package com.example.demo.Service;

import com.example.demo.Entity.Student;
import com.example.demo.dto.EnrollResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentService extends JpaRepository<Student, Integer> {
    Object getStudentById(String id);

}


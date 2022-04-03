package com.example.demo.Service;

import com.example.demo.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherService extends JpaRepository<Teacher, Integer> {
}

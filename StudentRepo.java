package com.example.DataJpaDemo.repository;

import com.example.DataJpaDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {
}

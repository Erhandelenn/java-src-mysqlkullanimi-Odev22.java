package com.example.OnetoMany.repository;

import com.example.OnetoMany.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface StudentRepository extends JpaRepository<Student, Long> {}
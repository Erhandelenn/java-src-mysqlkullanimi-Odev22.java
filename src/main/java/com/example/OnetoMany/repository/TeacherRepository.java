package com.example.OnetoMany.repository;

import com.example.OnetoMany.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface TeacherRepository extends JpaRepository<Teacher, Long> {}
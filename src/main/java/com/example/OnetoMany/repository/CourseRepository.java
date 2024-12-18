package com.example.OnetoMany.repository;

import com.example.OnetoMany.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
    public interface CourseRepository extends JpaRepository<Course, Long> {}

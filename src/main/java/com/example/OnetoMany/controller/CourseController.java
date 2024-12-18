package com.example.OnetoMany.controller;

import com.example.OnetoMany.model.Course;
import com.example.OnetoMany.model.Student;
import com.example.OnetoMany.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}/students")
    public List<Student> getStudentsByCourse(@PathVariable Long id) {
        Course course = courseService.getCourseById(id);
        return course.getStudents();
    }

    @PostMapping
    public Course addCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    @GetMapping("/{id}/passed")
    public List<Student> getPassingStudents(@PathVariable Long id) {
        Course course = courseService.getCourseById(id);
        return course.getStudents().stream()
                .filter(student -> student.getGrade() >= 50)
                .toList();
    }

    @GetMapping("/{id}/failed")
    public List<Student> getFailingStudents(@PathVariable Long id) {
        Course course = courseService.getCourseById(id);
        return course.getStudents().stream()
                .filter(student -> student.getGrade() < 50)
                .toList();
    }

    @GetMapping("/{id}/average")
    public Double getCourseAverage(@PathVariable Long id) {
        Course course = courseService.getCourseById(id);
        return course.getStudents().stream()
                .mapToDouble(Student::getGrade)
                .average()
                .orElse(0.0);
    }
}

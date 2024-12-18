package com.example.OnetoMany.service;

import com.example.OnetoMany.model.Course;
import com.example.OnetoMany.model.Student;
import com.example.OnetoMany.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
    public Double calculateStudentAverage(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        List<Course> courses = student.getCourses();
        if (courses.isEmpty()) {
            return 0.0;
        }

        double totalGrade = courses.stream()
                .mapToDouble(course -> student.getGrade())
                .sum();

        return totalGrade / courses.size();
    }
}
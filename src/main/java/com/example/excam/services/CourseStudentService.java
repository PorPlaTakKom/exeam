package com.example.excam.services;

import com.example.excam.entitys.Course;
import com.example.excam.entitys.CourseStudent;
import com.example.excam.entitys.Student;
import com.example.excam.repository.CourseRepository;
import com.example.excam.repository.CourseStudentRepository;
import com.example.excam.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CourseStudentService {

    @Autowired
    CourseStudentRepository courseStudentRepository;

    @Autowired
    StudentService studentService;
    @Autowired
    CourseService courseService;
    public void addCourseToStudent(int courseId, int studentId) {
        Student student = studentService.getStudentById(studentId);
        Course course = courseService.getCourseById(courseId);
        CourseStudent courseStudent = new CourseStudent();
        courseStudent.setCourse(course);
        courseStudent.setStudent(student);
        courseStudent.setGrade(Math.random() * 4);
        courseStudentRepository.save(courseStudent);
    }

    public void removeCourseFromStudent(int courseId, int studentId) {
        Student student = studentService.getStudentById(studentId);
        Course course = courseService.getCourseById(courseId);
        CourseStudent courseStudent = courseStudentRepository.findByCourseAndStudent(course, student);
        if (courseStudent != null) {
            courseStudentRepository.delete(courseStudent);
        }
    }
}

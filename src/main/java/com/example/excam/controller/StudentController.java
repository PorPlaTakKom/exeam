package com.example.excam.controller;

import com.example.excam.entitys.Course;
import com.example.excam.entitys.CourseStudent;
import com.example.excam.entitys.Student;
import com.example.excam.repository.CourseRepository;
import com.example.excam.repository.StudentRepository;
import com.example.excam.services.CourseService;
import com.example.excam.services.CourseStudentService;
import com.example.excam.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/api/std")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseStudentService courseStudentService;
    @GetMapping("")
    public List<Student> getStudent(){
        return studentService.getStudent();
    }

    @PostMapping("/{stdId}/{courseId}")
    public void addCourse(@PathVariable Integer stdId, @PathVariable Integer courseId){
        courseStudentService.addCourseToStudent(courseId, stdId);
    }

    @DeleteMapping("/{studentId}/{courseId}")
    public void removeCourseFromStudent(@PathVariable int studentId, @PathVariable int courseId) {
        courseStudentService.removeCourseFromStudent(courseId, studentId);
    }
//    @PostMapping("/addStudent")
//    public Student addStd(){
//        Student std = new Student(123, "abc");
//        std.setCourse(new HashSet<>());
//        CourseStudent cs = new CourseStudent();
//        cs.setCourse(courseRepository.findById(1).get());
//        cs.setGrade(99.9);
//        cs.setId(99);
//        cs.setStudent(std);
//        std.getCourse().add(cs);
//        studentRepository.save(std);
//        return std;
////        return studentService.addStudent(std);
//    }
}

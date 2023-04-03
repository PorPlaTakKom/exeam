package com.example.excam.controller;

import com.example.excam.entitys.Course;
import com.example.excam.entitys.CourseStudent;
import com.example.excam.entitys.Student;
import com.example.excam.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("")
    public List<Course> getCourse(){
        return courseService.getCourse();
    }
    @GetMapping("/{courseId}/std")
    public ResponseEntity<?> getStudentByCourseId(@PathVariable Integer courseId){
        Course c = courseService.getCourseById(courseId);
        List<Student> stdList = new ArrayList<>();
        for(CourseStudent s: c.getStudent()){
            stdList.add(s.getStudent());
        }
        return ResponseEntity.ok(stdList);
    }
    @GetMapping("/{subCode}")
    public Course getStudentByCourseId(@PathVariable String subCode){
        return courseService.getCourseBySubCode(subCode);
    }
}

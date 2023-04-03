package com.example.excam.services;

import com.example.excam.entitys.Course;
import com.example.excam.entitys.Subject;
import com.example.excam.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public List<Course> getCourse(){
        return courseRepository.findAll();
    }

    public Course getCourseById(Integer id){
        return courseRepository.findById(id).orElseThrow(
                () -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Course Id " + id + " DOES NOT EXIST !!!")
        );
    }

    public Course getCourseBySubCode(String subCode){
        Subject sj = new Subject();
        sj.setSubjectCode(subCode);
        return courseRepository.findBySubjectCode(sj);
    }
}

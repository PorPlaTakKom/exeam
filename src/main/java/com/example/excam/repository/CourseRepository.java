package com.example.excam.repository;

import com.example.excam.entitys.Course;
import com.example.excam.entitys.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    Course findBySubjectCode(Subject subCode);
}

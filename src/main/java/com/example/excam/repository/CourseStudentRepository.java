package com.example.excam.repository;

import com.example.excam.entitys.Course;
import com.example.excam.entitys.CourseStudent;
import com.example.excam.entitys.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseStudentRepository extends JpaRepository<CourseStudent, Integer> {
    CourseStudent findByCourseAndStudent(Course course, Student student);
}

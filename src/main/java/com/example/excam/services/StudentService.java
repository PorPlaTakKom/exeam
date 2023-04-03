package com.example.excam.services;

import com.example.excam.entitys.Student;
import com.example.excam.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student addStudent(Student std){
        return studentRepository.save(std);
    }

    public List<Student> getStudent(){
        return studentRepository.findAll();
    }

    public Student getStudentById(Integer id){
        return studentRepository.findById(id).orElseThrow(
                () -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Student Id " + id + " DOES NOT EXIST !!!")
        );
    }
}

package com.example.excam.controller;

import com.example.excam.entitys.Subject;
import com.example.excam.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sub")
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @GetMapping("")
    public Page<Subject> getSubject(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "2") Integer size,
            @RequestParam(defaultValue = "subjectCode") String sortBy
    ){
        return subjectService.getSubjects(page, size, sortBy);
    }
}

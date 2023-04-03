package com.example.excam.services;

import com.example.excam.entitys.Subject;
import com.example.excam.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public Page<Subject> getSubjects(Integer page, Integer size, String sortBy){
        Sort s = Sort.by(sortBy);
        Pageable pageable = PageRequest.of(page, size, s);
        return subjectRepository.findAll(pageable);
    }

    public Subject getSubjects(String subCode){
        return subjectRepository.findBySubjectCode(subCode);
    }
}

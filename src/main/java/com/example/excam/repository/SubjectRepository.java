package com.example.excam.repository;

import com.example.excam.entitys.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, String> {
    Subject findBySubjectCode(String subCode);
}

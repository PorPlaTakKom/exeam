package com.example.excam.entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="subject")
public class Subject {
    @Id
    @Column(name= "subject_code")
    private String subjectCode;
    private String title;
    private String credit;
}

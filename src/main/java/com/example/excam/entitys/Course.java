package com.example.excam.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "course")
public class Course {
    @Id
    private Integer courseId;

//    private String subjectCode;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "subjectCode")
    private Subject subjectCode;

    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private Set<CourseStudent> student;

}

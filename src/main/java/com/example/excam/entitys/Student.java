package com.example.excam.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "student")
@NoArgsConstructor

public class Student {
    @Id
    private Integer studentId;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<CourseStudent> course;
}

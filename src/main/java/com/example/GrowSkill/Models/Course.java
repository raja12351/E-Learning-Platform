package com.example.GrowSkill.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "courses")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;

    private String courseName;

    private String courseDuration;

    private Integer courseFees;

    @OneToMany(mappedBy = "courses",cascade = CascadeType.ALL)
    private List<Instructor> instructorList;

    @OneToMany(mappedBy = "courses",cascade = CascadeType.ALL)
    private List<Customer> customerList;

    @OneToMany(mappedBy = "courses", cascade = CascadeType.ALL)
    private List<Class> classList;

    @OneToOne(mappedBy = "courses", cascade = CascadeType.ALL)
    private Certificate certificate;

    @OneToOne(mappedBy = "courses", cascade = CascadeType.ALL)
    private VideoRecordings videoRecordings;
}

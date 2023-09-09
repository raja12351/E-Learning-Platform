package com.example.GrowSkill.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "instructors")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer instructorId;

    private String name;

    private Integer age;

    private String expertise;

    private String emailId;

    private Long contactNo;

    @ManyToOne
    @JoinColumn
    private Course course;
}

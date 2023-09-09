package com.example.GrowSkill.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "class")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classId;

    private String topic;

    private LocalDate date;

    private String duration;

    private String zoomLink;

    @ManyToOne
    @JoinColumn
    private Course course;
}

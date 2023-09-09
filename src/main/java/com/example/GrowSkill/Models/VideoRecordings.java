package com.example.GrowSkill.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "/recording")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VideoRecordings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer videoId;

    private String videoUrl;

    @OneToOne
    @JoinColumn
    private Course course;
}

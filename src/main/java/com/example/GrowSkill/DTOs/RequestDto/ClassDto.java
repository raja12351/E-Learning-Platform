package com.example.GrowSkill.DTOs.RequestDto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ClassDto {
    private String topic;

    private LocalDate date;

    private String duration;

    private String zoomLink;

    private Integer courseId;
}

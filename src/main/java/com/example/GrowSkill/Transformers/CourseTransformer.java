package com.example.GrowSkill.Transformers;

import com.example.GrowSkill.DTOs.RequestDto.CourseDto;
import com.example.GrowSkill.DTOs.ResponseDto.RecordDto;
import com.example.GrowSkill.Models.Course;

public class CourseTransformer {

    public static Course convertDtoToEntity(CourseDto courseDto){
        Course course = Course.builder().courseName(courseDto.getCourseName())
                        .courseFees(courseDto.getCourseFees()).courseDuration(courseDto.getCourseDuration())
                .build();

        return course;
    }

    public static RecordDto convertEntityToDto(Course course){
        RecordDto recordDto = RecordDto.builder().videoUrl(course.getVideoRecordings().getVideoUrl())
                        .certificateUrl(course.getCertificate().getCertificateUrl())
                    .build();

        return recordDto;
    }
}

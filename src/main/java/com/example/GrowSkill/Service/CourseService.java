package com.example.GrowSkill.Service;

import com.example.GrowSkill.DTOs.RequestDto.CourseDto;
import com.example.GrowSkill.Models.Course;
import com.example.GrowSkill.Repository.CourseRepository;
import com.example.GrowSkill.Transformers.CourseTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public String addCourse(CourseDto courseDto) {

        Course course = CourseTransformer.convertDtoToEntity(courseDto);

        courseRepository.save(course);

        return "Course has been added successfully.";
    }
}

package com.example.GrowSkill.Controller;

import com.example.GrowSkill.DTOs.RequestDto.CourseDto;
import com.example.GrowSkill.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/add-course")
    public ResponseEntity<String> addCourse(@RequestBody CourseDto courseDto){
        String message = courseService.addCourse(courseDto);

        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
}

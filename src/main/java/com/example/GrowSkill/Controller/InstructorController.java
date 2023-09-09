package com.example.GrowSkill.Controller;

import com.example.GrowSkill.DTOs.RequestDto.InstructorDto;
import com.example.GrowSkill.Service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instructor")
public class InstructorController {
    @Autowired
    private InstructorService instructorService;

    @PostMapping("/add-instructor")
    public ResponseEntity<String> addInstructor(@RequestBody InstructorDto instructorDto){
        String message = instructorService.addInstructor(instructorDto);

        return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
    }

    @PutMapping("/add-instructor-to-course")
    public ResponseEntity<String> addToCourse(@RequestParam Integer instructorId, @RequestParam Integer courseId){
        try{
            String message = instructorService.addToCourse(instructorId, courseId);

            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_IMPLEMENTED);
        }
    }
}

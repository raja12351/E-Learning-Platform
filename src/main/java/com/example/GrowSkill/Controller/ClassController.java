package com.example.GrowSkill.Controller;

import com.example.GrowSkill.DTOs.RequestDto.ClassDto;
import com.example.GrowSkill.Service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/class")
public class ClassController {

    @Autowired
    private ClassService classService;

    @PostMapping("/add-class")
    public ResponseEntity<String> addClass(@RequestBody ClassDto classDto){
        try{
            String message = classService.addClass(classDto);

            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_IMPLEMENTED);
        }
    }
}

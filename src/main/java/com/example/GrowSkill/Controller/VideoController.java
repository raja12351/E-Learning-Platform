package com.example.GrowSkill.Controller;

import com.example.GrowSkill.DTOs.RequestDto.VideoDto;
import com.example.GrowSkill.Service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recording")
public class VideoController {

    @Autowired
    VideoService videoService;

    @PostMapping("/add-recording")
    public ResponseEntity<String> addRecording(@RequestBody VideoDto videoDto){
        try {
            String message = videoService.addRecording(videoDto);
            return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

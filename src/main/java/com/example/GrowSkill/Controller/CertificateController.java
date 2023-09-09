package com.example.GrowSkill.Controller;

import com.example.GrowSkill.DTOs.RequestDto.CertificateDto;
import com.example.GrowSkill.DTOs.RequestDto.VideoDto;
import com.example.GrowSkill.Service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/certificate")
public class CertificateController {

    @Autowired
    CertificateService certificateService;

    @PostMapping("/add-certificate")
    public ResponseEntity<String> addRecording(@RequestBody CertificateDto certificateDto){
        try {
            String message = certificateService.addCertificate(certificateDto);
            return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

package com.example.GrowSkill.Service;

import com.example.GrowSkill.DTOs.RequestDto.CertificateDto;
import com.example.GrowSkill.Exceptions.CourseException;
import com.example.GrowSkill.Models.Certificate;
import com.example.GrowSkill.Models.Course;
import com.example.GrowSkill.Repository.CertificateRepository;
import com.example.GrowSkill.Repository.CourseRepository;
import com.example.GrowSkill.Transformers.CertificateTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CertificateService {

    @Autowired
    CertificateRepository certificateRepository;

    @Autowired
    CourseRepository courseRepository;

    public String addCertificate(CertificateDto certificateDto) throws CourseException{
        Optional<Course> courseOptional = courseRepository.findById(certificateDto.getCourseId());

        if(courseOptional.isEmpty()){
            throw new CourseException("No course with given id!");
        }

        Course course = courseOptional.get();

        Certificate certificate = CertificateTransformer.convertDtoToEntity(certificateDto);

        course.setCertificate(certificate);
        certificate.setCourse(course);

        courseRepository.saveCourse(course);
        certificateRepository.saveCertificate(certificate);

        return "certificate is added with the course.";
    }
}

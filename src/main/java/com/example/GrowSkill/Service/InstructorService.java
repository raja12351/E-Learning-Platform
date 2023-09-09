package com.example.GrowSkill.Service;

import com.example.GrowSkill.DTOs.RequestDto.InstructorDto;
import com.example.GrowSkill.Exceptions.CourseException;
import com.example.GrowSkill.Exceptions.InstructorException;
import com.example.GrowSkill.Models.Course;
import com.example.GrowSkill.Models.Instructor;
import com.example.GrowSkill.Repository.CourseRepository;
import com.example.GrowSkill.Repository.InstructorRepository;
import com.example.GrowSkill.Transformers.InstructorTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private CourseRepository courseRepository;

    public String addInstructor(InstructorDto instructorDto) {

        Instructor instructor  = InstructorTransformer.convertDtoToEntity(instructorDto);

        instructorRepository.save(instructor);

        return "Instructor is added successfully into the database.";
    }

    public String addToCourse(Integer instructorId, Integer courseId) throws CourseException,InstructorException{
        Optional<Course> courseOptional = courseRepository.findById(courseId);

        Optional<Instructor> instructorOptional = instructorRepository.findById(instructorId);

        if(courseOptional.isEmpty()){
            throw new CourseException("No Course found with given id: " + courseId);
        }

        if(instructorOptional.isEmpty()){
            throw new InstructorException("No instructor found with given id: " + instructorId);
        }

        Course course = courseOptional.get();
        Instructor instructor = instructorOptional.get();

        course.getInstructorList().add(instructor);
        instructor.setCourse(course);

        courseRepository.save(course);
        instructorRepository.save(instructor);

        return "Instructor is assigned to the particular course.";
    }
}

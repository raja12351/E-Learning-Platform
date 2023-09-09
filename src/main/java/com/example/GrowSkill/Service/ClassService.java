package com.example.GrowSkill.Service;

import com.example.GrowSkill.DTOs.RequestDto.ClassDto;
import com.example.GrowSkill.Exceptions.CourseException;
import com.example.GrowSkill.Models.Class;
import com.example.GrowSkill.Models.Course;
import com.example.GrowSkill.Repository.CLassRepository;
import com.example.GrowSkill.Repository.CourseRepository;
import com.example.GrowSkill.Transformers.ClassTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassService {

    @Autowired
    CLassRepository cLassRepository;

    @Autowired
    CourseRepository courseRepository;

    public String addClass(ClassDto classDto) throws CourseException{
        Optional<Course> courseOpt = courseRepository.findByCourseId(classDto.getCourseId());

        if(courseOpt.isEmpty()){
            throw new CourseException("No course found with given id: " + classDto.getCourseId());
        }

        Course course = courseOpt.get();
        Class classes = ClassTransformer.convertDtoToEntity(classDto);

        List<Class> classList = course.getClassList();
        classList.add(classes);
        course.setClassList(classList);

        classes.setCourse(course);

        cLassRepository.saveClass(classes);
        courseRepository.saveCourse(course);

        return "Class has been added to tha database and it's particular course";
    }
}

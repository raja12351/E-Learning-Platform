package com.example.GrowSkill.Service;

import com.example.GrowSkill.DTOs.RequestDto.VideoDto;
import com.example.GrowSkill.Exceptions.CourseException;
import com.example.GrowSkill.Models.Course;
import com.example.GrowSkill.Models.VideoRecordings;
import com.example.GrowSkill.Repository.CourseRepository;
import com.example.GrowSkill.Repository.VideoRepository;
import com.example.GrowSkill.Transformers.VideoTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VideoService {

    @Autowired
    VideoRepository videoRepository;

    @Autowired
    CourseRepository courseRepository;

    public String addRecording(VideoDto videoDto) throws CourseException{
        Optional<Course> courseOptional = courseRepository.findById(videoDto.getCourseId());

        if(courseOptional.isEmpty()){
            throw new CourseException("No course with given id!");
        }

        Course course = courseOptional.get();

        VideoRecordings videoRecordings = VideoTransformer.convertDtoToEntity(videoDto);

        course.setVideoRecordings(videoRecordings);
        videoRecordings.setCourse(course);

        courseRepository.saveCourse(course);
        videoRepository.saveRecording(videoRecordings);

        return "Video has been added with the course.";
    }
}

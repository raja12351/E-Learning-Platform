package com.example.GrowSkill.Repository;

import com.example.GrowSkill.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {

    @Modifying
    @Transactional
    @Query(value="INSERT INTO courses (courseName, courseDuration, courseFees, instructorList, customerList, classList, certificate, videoRecordings) VALUES (:courses.courseName, :courses.courseDuration, :courses.courseFees, :courses.instructorList, :courses.customerList, :courses.classList, :courses.certificate, :courses.videoRecordings); ALTER TABLE courses MODIFY COLUMN instructorList VARCHAR(255) NULL, MODIFY COLUMN customerListList VARCHAR(255) NULL, MODIFY COLUMN classList VARCHAR(255) NULL, MODIFY COLUMN certificate VARCHAR(255) NULL, MODIFY COLUMN videoRecording VARCHAR(255) NULL", nativeQuery = true)
    void saveCourse(Course course);

    @Query(value = "SELECT * FROM courses WHERE courseName = :name", nativeQuery = true)
    Course findByCourseName(String name);

    @Query(value = "SELECT * FROM courses WHERE courseId = :courseId", nativeQuery = true)
    Optional<Course> findByCourseId(Integer courseId);
}

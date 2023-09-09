package com.example.GrowSkill.Repository;

import com.example.GrowSkill.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {

    Course findByCourseName(String name);
}

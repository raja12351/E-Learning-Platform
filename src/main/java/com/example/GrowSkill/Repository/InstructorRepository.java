package com.example.GrowSkill.Repository;

import com.example.GrowSkill.Models.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor,Integer> {

    @Modifying
    @Transactional
    @Query(value="INSERT INTO instructors (name, age, expertise, emailId, contactNo, course) VALUES (:instructor.name, :instructor.age, :instructor.expertise, :instructor.emailId, :instructor.contactNo, :instructor.course); ALTER TABLE instructors MODIFY COLUMN course VARCHAR(255) NULL", nativeQuery = true)
    void saveInstructor(Instructor instructor);
}

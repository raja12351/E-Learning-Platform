package com.example.GrowSkill.Repository;

import com.example.GrowSkill.Models.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CLassRepository extends JpaRepository<Class,Integer> {

    @Modifying
    @Transactional
    @Query(value="INSERT INTO class (topic, date, duration, zoomLink, course) VALUES (:classes.topic, :classes.date, :classes.duration, :classes.zoomLink, :classes.course)", nativeQuery = true)
    void saveClass(Class classes);
}

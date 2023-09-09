package com.example.GrowSkill.Repository;

import com.example.GrowSkill.Models.VideoRecordings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<VideoRecordings,Integer> {
}

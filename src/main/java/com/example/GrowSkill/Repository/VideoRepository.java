package com.example.GrowSkill.Repository;

import com.example.GrowSkill.Models.VideoRecordings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface VideoRepository extends JpaRepository<VideoRecordings,Integer> {

    @Modifying
    @Transactional
    @Query(value="INSERT INTO recording (videoUrl, course) VALUES (:videoRecordings.videoUrl, :videoRecordings.course)", nativeQuery = true)
    void saveRecording(VideoRecordings videoRecordings);
}

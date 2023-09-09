package com.example.GrowSkill.Transformers;

import com.example.GrowSkill.DTOs.RequestDto.VideoDto;
import com.example.GrowSkill.Models.VideoRecordings;

public class VideoTransformer {
    public static VideoRecordings convertDtoToEntity(VideoDto videoDto){
        VideoRecordings videoRecordings = VideoRecordings.builder().videoUrl(videoDto.getVideoUrl())
                                            .build();

        return videoRecordings;
    }
}

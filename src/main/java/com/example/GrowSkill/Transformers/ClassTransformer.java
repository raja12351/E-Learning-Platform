package com.example.GrowSkill.Transformers;

import com.example.GrowSkill.DTOs.RequestDto.ClassDto;
import com.example.GrowSkill.Models.Class;

public class ClassTransformer {

    public static Class convertDtoToEntity(ClassDto classDto){
        Class classes = Class.builder().topic(classDto.getTopic()).duration(classDto.getDuration())
                        .zoomLink(classDto.getZoomLink()).date(classDto.getDate())
                    .build();

        return classes;
    }
}

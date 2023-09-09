package com.example.GrowSkill.Transformers;

import com.example.GrowSkill.DTOs.RequestDto.InstructorDto;
import com.example.GrowSkill.Models.Instructor;

public class InstructorTransformer {

    public static Instructor convertDtoToEntity(InstructorDto instructorDto){
        Instructor instructor = Instructor.builder().name(instructorDto.getName()).expertise(instructorDto.getExpertise())
                        .emailId(instructorDto.getEmailId()).age(instructorDto.getAge())
                        .contactNo(instructorDto.getContactNo())
                    .build();

        return instructor;
    }
}

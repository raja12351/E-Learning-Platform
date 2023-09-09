package com.example.GrowSkill.DTOs.RequestDto;

import com.example.GrowSkill.Enums.Gender;
import com.example.GrowSkill.Enums.PaymentMode;
import lombok.Data;

@Data
public class CustomerDto {

    private String name;

    private Integer age;

    private Gender gender;

    private String emailId;

    private Long contactNo;

    private Integer amountPaid;

    private PaymentMode paymentMode;

    private Boolean paymentStatus;

    private String courseName;
}

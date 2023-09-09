package com.example.GrowSkill.Transformers;

import com.example.GrowSkill.DTOs.RequestDto.CustomerDto;
import com.example.GrowSkill.Models.Customer;

public class CustomerTransformer {

    public static Customer convertDtoToEntity(CustomerDto customerDto){
        Customer customer = Customer.builder().name(customerDto.getName()).age(customerDto.getAge())
                        .gender(customerDto.getGender()).emailId(customerDto.getEmailId())
                .amountPaid(customerDto.getAmountPaid()).paymentMode(customerDto.getPaymentMode())
                .contactNo(customerDto.getContactNo()).
                .build();

        return customer;
    }
}

package com.example.GrowSkill.Models;

import com.example.GrowSkill.Enums.Gender;
import com.example.GrowSkill.Enums.PaymentMode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customers")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    private String name;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String emailId;

    private Long contactNo;

    private Integer amountPaid;

    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;

    @ManyToOne
    @JoinColumn
    private Course course;
}

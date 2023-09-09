package com.example.GrowSkill.Repository;

import com.example.GrowSkill.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    @Modifying
    @Transactional
    @Query(value="INSERT INTO customers (name, age, gender, emailId, contactNo, amountPaid, paymentMode, course) VALUES (:customer.name, age, :customer.gender, :customer.emailId, :customer.contactNo, :customer.amountPaid, :customer.paymentMode, :customer.course)", nativeQuery = true)
    void saveCustomer(Customer customer);

    @Query(value = "SELECT * FROM customers WHERE customerId = :customerId", nativeQuery = true)
    Optional<Customer> findByCustomerId(Integer customerId);
}

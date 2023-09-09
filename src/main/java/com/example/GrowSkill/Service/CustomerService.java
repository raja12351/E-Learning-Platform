package com.example.GrowSkill.Service;

import com.example.GrowSkill.DTOs.RequestDto.CustomerDto;
import com.example.GrowSkill.DTOs.ResponseDto.RecordDto;
import com.example.GrowSkill.Exceptions.CustomerException;
import com.example.GrowSkill.Exceptions.EmailException;
import com.example.GrowSkill.Models.Course;
import com.example.GrowSkill.Models.Customer;
import com.example.GrowSkill.Repository.CourseRepository;
import com.example.GrowSkill.Repository.CustomerRepository;
import com.example.GrowSkill.Transformers.CourseTransformer;
import com.example.GrowSkill.Transformers.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    JavaMailSender mailSender;

    public String addCustomer(CustomerDto customerDto) throws EmailException{

        if(customerDto.getEmailId() == null){
            throw new EmailException("Email is important for the registration!");
        }

        Customer customer = CustomerTransformer.convertDtoToEntity(customerDto);

        Course course = null;

        if(customerDto.getPaymentStatus()){
            course = courseRepository.findByCourseName(customerDto.getCourseName());

            course.getCustomerList().add(customer);
            customer.setCourse(course);

            courseRepository.saveCourse(course);
            customerRepository.saveCustomer(customer);

            sendMail(course,customer);
        }

        return "Customer is added successfully into the database and it's particular course";
    }

    public void sendMail(Course course,Customer customer){
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        String body = "Hi "+ customer.getName() + ","+"\n"+
                "Your have successfully booked the course " + course.getCourseName() + "." +
                " on GrowSkill." + " The duration of course will be " + course.getCourseDuration() +" hrs." + "\n" +
                "Thank you for the booking and Keep Learning." + "\n"
                + "All the best." ;

        mailMessage.setSubject("Booking Confirmation");
        mailMessage.setText(body);
        mailMessage.setFrom("admin-desk@growskill.com");
        mailMessage.setTo(customer.getEmailId());

        mailSender.send(mailMessage);
    }

    public RecordDto getRecording(Integer customerId) throws CustomerException {

        Optional<Customer> customerOptional = customerRepository.findByCustomerId(customerId);

        if(customerOptional.isEmpty()){
            throw new CustomerException("No customer with given id: " + customerId);
        }
        Customer customer = customerOptional.get();
        Course course = customer.getCourse();

        RecordDto recordDto = CourseTransformer.convertEntityToDto(course);

        return recordDto;
    }
}

package com.example.GrowSkill.Controller;

import com.example.GrowSkill.DTOs.RequestDto.CustomerDto;
import com.example.GrowSkill.DTOs.ResponseDto.RecordDto;
import com.example.GrowSkill.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/add-customer")
    public ResponseEntity<String> addCustomer(@RequestBody CustomerDto customerDto){
        try{
            String message = customerService.addCustomer(customerDto);
            return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/get-recording-and-certificate")
    public ResponseEntity<RecordDto> getRecording(@RequestParam Integer customerId){
        try{
            RecordDto recordDto = customerService.getRecording(customerId);

            return new ResponseEntity<>(recordDto, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}

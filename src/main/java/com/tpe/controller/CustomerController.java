package com.tpe.controller;

import com.tpe.domain.Customer;
import com.tpe.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


//kisayol: ctrl+shift+ t
@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{id}") //http://localhost:8080/custmers/1  + GET
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id){

        Customer customer = customerService.getCustomerById(id);

        //return ResponseEntity.ok(customer);//200
        return new ResponseEntity<>(customer, HttpStatus.OK);// 200

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id){

        customerService.deleteCustomerById(id);

        return ResponseEntity.ok("Customer is deleted.");
    }


}

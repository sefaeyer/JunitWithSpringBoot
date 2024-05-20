package com.tpe.controller;

import com.tpe.domain.Customer;
import com.tpe.service.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    @Test
    void getCustomerById() {

        Customer customer=new Customer();
        customer.setId(1L);

        when(customerService.getCustomerById(1L)).thenReturn(customer);

        ResponseEntity<Customer> response = customerController.getCustomerById(1L);

        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(customer,response.getBody());
        verify(customerService).getCustomerById(1L);

    }

    @Test
    void deleteCustomer() {

        ResponseEntity<String> response =  customerController.deleteCustomer(2L);

        assertEquals(HttpStatus.OK,response.getStatusCode());
        verify(customerService).deleteCustomerById(2L);
        assertEquals("Customer is deleted.",response.getBody());
    }
}
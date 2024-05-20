package com.tpe.service;

import com.tpe.controller.CustomerController;
import com.tpe.domain.Customer;
import com.tpe.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    void getCustomerById() {

        Customer customer=new Customer();
        customer.setId(1L);

        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
        when(customerRepository.findById(99L)).thenReturn(Optional.empty());

        Customer found = customerService.getCustomerById(1L);

        assertEquals(1L,found.getId());
        assertThrows(RuntimeException.class,()->customerService.getCustomerById(99L));
        verify(customerRepository).findById(1L);
        verify(customerRepository).findById(99L);

    }

    @Test
    void deleteCustomerById() {

        Customer customer=new Customer();
        customer.setId(1L);

        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));

        customerService.deleteCustomerById(1L);

        verify(customerRepository).deleteById(1L);


    }
}
package com.tpe.service;

import com.tpe.domain.Customer;
import com.tpe.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor // const inj icin gerekli constructor i olusturur
public class CustomerService {


    private final CustomerRepository customerRepository;


    public Customer getCustomerById(Long id) {

        return customerRepository.findById(id).
                orElseThrow(()->new RuntimeException("Customer not found!"));

    }

    public void deleteCustomerById(Long id) {

        getCustomerById(id);
        customerRepository.deleteById(id);

    }
}

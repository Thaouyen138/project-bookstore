package com.example.demo.service.impl;

import com.example.demo.model.customer.Customer;
import com.example.demo.repository.ICustomerRepository;
import com.example.demo.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Optional<Customer> findCustomerByUserName(String username) {
        return customerRepository.findCustomerByUserName(username);
    }
}
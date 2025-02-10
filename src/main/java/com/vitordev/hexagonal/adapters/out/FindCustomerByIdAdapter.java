package com.vitordev.hexagonal.adapters.out;

import com.vitordev.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.vitordev.hexagonal.adapters.out.repository.CustomerRepository;
import com.vitordev.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.vitordev.hexagonal.application.core.domain.Customer;
import com.vitordev.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerMapper;

    @Override
    public Optional<Customer> find(String id) {
        var customerEntity = customerRepository.findById(id);
        return customerEntity.map(entity -> customerMapper.toCustomer(entity));
    }
}

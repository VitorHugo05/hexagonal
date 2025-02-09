package com.vitordev.hexagonal.adapters.out;

import com.vitordev.hexagonal.adapters.out.repository.CustomerRepository;
import com.vitordev.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.vitordev.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.vitordev.hexagonal.application.core.domain.Customer;
import com.vitordev.hexagonal.application.ports.out.InsertCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void insert(Customer customer) {
        CustomerEntity customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.insert(customerEntity);
    }
}

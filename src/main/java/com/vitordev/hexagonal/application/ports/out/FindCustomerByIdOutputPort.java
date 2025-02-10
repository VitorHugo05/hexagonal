package com.vitordev.hexagonal.application.ports.out;

import com.vitordev.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {
    Optional<Customer> find(String id);
}

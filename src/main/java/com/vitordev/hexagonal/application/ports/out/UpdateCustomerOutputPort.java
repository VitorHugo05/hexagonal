package com.vitordev.hexagonal.application.ports.out;

import com.vitordev.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {
    void update(Customer customer);
}

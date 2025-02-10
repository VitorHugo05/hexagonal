package com.vitordev.hexagonal.application.ports.in;

import com.vitordev.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {
    Customer find(String id);
}

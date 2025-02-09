package com.vitordev.hexagonal.application.ports.out;

import com.vitordev.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {
    Address find(String zipCode);
}

package com.vitordev.hexagonal.adapters.out.client.mapper;

import com.vitordev.hexagonal.adapters.out.client.response.AddressResponse;
import com.vitordev.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {
    Address toAddress(AddressResponse addressResponse);
}

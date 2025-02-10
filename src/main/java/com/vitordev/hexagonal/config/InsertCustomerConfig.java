package com.vitordev.hexagonal.config;

import com.vitordev.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.vitordev.hexagonal.adapters.out.InsertCustomerAdapter;
import com.vitordev.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.vitordev.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {
    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCode,
            InsertCustomerAdapter insertCustomerAdapter
    ) {
        return new InsertCustomerUseCase(findAddressByZipCode, insertCustomerAdapter);
    }
}

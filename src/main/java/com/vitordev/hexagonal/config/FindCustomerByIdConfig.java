package com.vitordev.hexagonal.config;

import com.vitordev.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.vitordev.hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.vitordev.hexagonal.adapters.out.InsertCustomerAdapter;
import com.vitordev.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.vitordev.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {
    @Bean
    public FindCustomerByIdUseCase findCustomerByIdUseCase(
            FindCustomerByIdAdapter findCustomerByIdAdapter
    ) {
        return new FindCustomerByIdUseCase(findCustomerByIdAdapter);
    }
}

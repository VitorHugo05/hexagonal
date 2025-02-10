package com.vitordev.hexagonal.config;

import com.vitordev.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.vitordev.hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.vitordev.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.vitordev.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.vitordev.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {
    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            UpdateCustomerAdapter updateCustomerAdapter
    ) {
        return new UpdateCustomerUseCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustomerAdapter);
    }
}

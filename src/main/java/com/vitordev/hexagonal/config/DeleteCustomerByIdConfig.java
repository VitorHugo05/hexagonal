package com.vitordev.hexagonal.config;

import com.vitordev.hexagonal.adapters.out.DeleteCustomerByIdAdapter;
import com.vitordev.hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.vitordev.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase;
import com.vitordev.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {
    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            DeleteCustomerByIdAdapter deleteCustomerByIdAdapter
    ) {
        return new DeleteCustomerByIdUseCase(findCustomerByIdUseCase, deleteCustomerByIdAdapter);
    }
}

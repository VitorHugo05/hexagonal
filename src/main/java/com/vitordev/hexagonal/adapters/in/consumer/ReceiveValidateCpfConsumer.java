package com.vitordev.hexagonal.adapters.in.consumer;

import com.vitordev.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.vitordev.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.vitordev.hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidateCpfConsumer {

    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "vitordev")
    public void receive(CustomerMessage message) {
        var customer = customerMessageMapper.toCustomer(message);
        updateCustomerInputPort.update(customer, message.getZipCode());
    }
}

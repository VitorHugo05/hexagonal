package com.vitordev.hexagonal.adapters.in.controller;

import com.vitordev.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.vitordev.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.vitordev.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.vitordev.hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.vitordev.hexagonal.application.core.domain.Customer;
import com.vitordev.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.vitordev.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.vitordev.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.vitordev.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.vitordev.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CostumerController {

    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest request) {
        var customer = customerMapper.toCostumer(request);
        insertCustomerInputPort.insert(customer, request.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {
        var customer = findCustomerByIdInputPort.find(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @Valid @RequestBody CustomerRequest request) {
        Customer customer = customerMapper.toCostumer(request);
        customer.setId(id);
        updateCustomerInputPort.update(customer, request.getZipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id) {
        deleteCustomerByIdInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }
}

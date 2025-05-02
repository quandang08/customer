package com.amu.customer.service;

import com.amu.customer.dto.CustomerRequest;
import com.amu.customer.dto.CustomerResponse;
import com.amu.customer.entities.Customer;
import com.amu.customer.exception.CustomerNotFoundException;
import com.amu.customer.mapper.CustomerMapper;
import com.amu.customer.repositories.CustomerRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public String createCustomer(@Valid CustomerRequest request) {
        var customer = repository.save(mapper.toCustomer(request));
        return customer.getId();
    }

    public void updateCustomer(@Valid CustomerRequest request) {
        var customer = repository.findById(request.id())
                .orElseThrow(() -> new CustomerNotFoundException(
                        String.format("Customer with id %s not found to update", request.id())
                ));
        mergerCustomer(customer, request);
        repository.save(customer);
    }

    private void mergerCustomer(Customer customer, @Valid CustomerRequest request) {
        if(StringUtils.isNotBlank(request.firstName())){
            customer.setFirstName(request.firstName());
        }
        if(StringUtils.isNotBlank(request.lastName())){
            customer.setLastName(request.lastName());
        }
        if(StringUtils.isNotBlank(request.email())){
            customer.setEmail(request.email());
        }
        if (request.address() != null) {
            customer.setAddress(request.address());
        }
    }

    public List<CustomerResponse> findAllCustomers() {
        return repository.findAll()
                .stream()
                .map(mapper::formCustomer)
                .collect(Collectors.toList());
    }

    public Boolean existsById(String id) {
        return repository.findById(id)
                .isPresent();
    }

    public CustomerResponse findById(String customerId) {
        return repository.findById(customerId)
                .map(mapper::formCustomer)
                .orElseThrow(() -> new CustomerNotFoundException(String.format("No customer found with id %s", customerId)));

    }

    public void deleteCustomer(String customerId) {
        repository.deleteById(customerId);
    }

}

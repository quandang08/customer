package com.amu.customer.mapper;

import com.amu.customer.dto.CustomerRequest;
import com.amu.customer.dto.CustomerResponse;
import com.amu.customer.entities.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {

    public Customer toCustomer( CustomerRequest request) {
        if(request==null){
            return null;
        }
        return Customer.builder()
                .id(request.id())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .address(request.address())
                .build();
    }

    public CustomerResponse formCustomer(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getAddress()

        );
    }
}

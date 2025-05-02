package com.amu.customer.dto;


import com.amu.customer.entities.Address;

public record CustomerResponse(
        String id,
        String firstName,
        String lastName,
        String email,
        Address address
) {

}

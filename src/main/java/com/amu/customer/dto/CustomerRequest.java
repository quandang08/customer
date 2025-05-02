package com.amu.customer.dto;

import com.amu.customer.entities.Address;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(String id,
        @NotNull(message = "Customer firstname is required")
        String firstName,
        @NotNull(message = "Customer lastname is required")
        String lastName,
        @NotNull(message = "Customer email is required")
        String email,
        @NotNull(message = "Customer firstname is required")
        Address address) {


}

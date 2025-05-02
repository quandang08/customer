package com.amu.customer.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Customer {
    @Id
    private String id;

    private String firstName;
    private String lastName;
    private Address address;
    private String email;
}

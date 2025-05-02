package com.amu.customer.repositories;

import com.amu.customer.entities.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer,String> {

}

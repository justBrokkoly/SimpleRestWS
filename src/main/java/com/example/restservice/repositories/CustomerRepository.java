package com.example.restservice.repositories;

import com.example.restservice.api.v1.model.CustomerDTO;
import com.example.restservice.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}

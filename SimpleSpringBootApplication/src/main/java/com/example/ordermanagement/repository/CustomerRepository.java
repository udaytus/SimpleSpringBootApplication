package com.example.ordermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ordermanagement.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository <Customer,Long> {

}

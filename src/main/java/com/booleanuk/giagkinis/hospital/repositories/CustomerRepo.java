package com.booleanuk.giagkinis.hospital.repositories;

import com.booleanuk.giagkinis.hospital.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
}

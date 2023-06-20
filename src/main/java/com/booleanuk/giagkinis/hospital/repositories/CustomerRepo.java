package com.booleanuk.giagkinis.hospital.repositories;

import com.booleanuk.giagkinis.hospital.models.Customer;
import com.booleanuk.giagkinis.hospital.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

    Customer findByUserId(Long userId);
}

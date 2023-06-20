package com.booleanuk.giagkinis.hospital.repositories;

import com.booleanuk.giagkinis.hospital.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepo extends JpaRepository<Doctor, Long> {

    Doctor findByUserId(Long userId);
}

package com.booleanuk.giagkinis.hospital.repositories;

import com.booleanuk.giagkinis.hospital.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepo extends JpaRepository<Appointment, Long> {

    List<Appointment> findByCustomerId (Long customerId);
    List<Appointment> findByDoctorId (Long doctorId);
}

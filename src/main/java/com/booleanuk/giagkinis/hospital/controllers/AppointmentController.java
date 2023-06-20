package com.booleanuk.giagkinis.hospital.controllers;

import com.booleanuk.giagkinis.hospital.models.Appointment;
import com.booleanuk.giagkinis.hospital.models.Doctor;
import com.booleanuk.giagkinis.hospital.repositories.AppointmentRepo;
import com.booleanuk.giagkinis.hospital.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AppointmentController {

    @Autowired
    private AppointmentRepo appointmentRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @GetMapping("/customers/{customerId}/appointments")
    public ResponseEntity<List<Appointment>> getAllAppointmentsForCustomers(@PathVariable Long customerId) {
        List<Appointment> appointments = appointmentRepo.findByCustomerId(customerId);
        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/doctors/{doctorId}/appointments")
    public ResponseEntity<List<Appointment>> getAllAppointmentsForDoctors(@PathVariable Long doctorId) {
        List<Appointment> appointments = appointmentRepo.findByDoctorId(doctorId);
        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/customers/{customerId}/appointments/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) {
        Appointment appointment = appointmentRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No Appointment found with this ID"));
        return ResponseEntity.ok(appointment);
    }

    @PostMapping("/customers/{customerId}/appointments")
    public ResponseEntity<Appointment> createAppointment(@PathVariable Long customerId, @RequestBody Appointment appointment) {
        appointment.setCustomer(customerRepo.findById(customerId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No Customer found with this ID")));
        return new ResponseEntity<>(appointmentRepo.save(appointment), HttpStatus.CREATED);
    }

    @PutMapping("/customers/{customerId}/appointments/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable Long id, Long customerId, @RequestBody Appointment appointment) {
        Appointment updatedAppointment = appointmentRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No Appointment found with this ID"));

        updatedAppointment.setAppointmentDateTime(appointment.getAppointmentDateTime());
        updatedAppointment.setDoctor(appointment.getDoctor());
        return new ResponseEntity<>(appointmentRepo.save(updatedAppointment), HttpStatus.CREATED);
    }

    @DeleteMapping("/customers/{customerId}/appointments/{id}")
    public ResponseEntity<Appointment> deleteAppointment(@PathVariable Long id) {
        Appointment appointmentToDelete = appointmentRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No Appointment found with this ID"));
        appointmentRepo.delete(appointmentToDelete);
        return ResponseEntity.ok(appointmentToDelete);
    }
}

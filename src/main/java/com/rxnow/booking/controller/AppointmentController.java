package com.rxnow.booking.controller;

import com.rxnow.booking.dto.AppointmentRequest;
import com.rxnow.booking.dto.AppointmentResponse;
import com.rxnow.booking.model.Appointment;
import com.rxnow.booking.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<AppointmentResponse> bookAppointment(@Valid @RequestBody AppointmentRequest request) {
        AppointmentResponse appointment = appointmentService.bookAppointment(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(appointment);
    }

    @GetMapping
    public ResponseEntity<List<AppointmentResponse>> getAppointments(
            @RequestParam(required = false) Long doctor_id,
            @RequestParam(required = false) Long patient_id,
            @RequestParam(required = false) String status) {

        if (doctor_id != null && patient_id == null && status == null) {
            List<AppointmentResponse> appointments = appointmentService.getAppointmentsByDoctorId(doctor_id);
            return ResponseEntity.ok(appointments);
        }

        if (patient_id != null && doctor_id == null && status == null) {
            List<AppointmentResponse> appointments = appointmentService.getAppointmentsByPatientId(patient_id);
            return ResponseEntity.ok(appointments);
        }

        List<AppointmentResponse> appointments = appointmentService.getAppointmentsWithFilters(doctor_id, patient_id, status);
        return ResponseEntity.ok(appointments);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<AppointmentResponse> updateAppointmentStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        try {
            Appointment.AppointmentStatus appointmentStatus = Appointment.AppointmentStatus.valueOf(status.toUpperCase());
            AppointmentResponse updatedAppointment = appointmentService.updateAppointmentStatus(id, appointmentStatus);
            return ResponseEntity.ok(updatedAppointment);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelAppointment(@PathVariable Long id) {
        appointmentService.cancelAppointment(id);
        return ResponseEntity.noContent().build();
    }
}

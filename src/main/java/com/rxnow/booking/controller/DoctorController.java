package com.rxnow.booking.controller;

import com.rxnow.booking.model.Doctor;
import com.rxnow.booking.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors(
            @RequestParam(required = false) String specialization,
            @RequestParam(required = false) String name) {

        if (specialization != null || name != null) {
            List<Doctor> doctors = doctorService.getAllDoctorsWithFilters(specialization, name);
            return ResponseEntity.ok(doctors);
        } else {
            List<Doctor> doctors = doctorService.getAllDoctors();
            return ResponseEntity.ok(doctors);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
        Doctor doctor = doctorService.getDoctorById(id);
        return ResponseEntity.ok(doctor);
    }

    @GetMapping("/specialization/{specialization}")
    public ResponseEntity<List<Doctor>> getDoctorsBySpecialization(@PathVariable String specialization) {
        List<Doctor> doctors = doctorService.getDoctorsBySpecialization(specialization);
        return ResponseEntity.ok(doctors);
    }

    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@Valid @RequestBody Doctor doctor) {
        Doctor savedDoctor = doctorService.saveDoctor(doctor);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDoctor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @Valid @RequestBody Doctor doctorDetails) {
        Doctor updatedDoctor = doctorService.updateDoctor(id, doctorDetails);
        return ResponseEntity.ok(updatedDoctor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }
}

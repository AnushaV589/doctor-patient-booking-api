package com.rxnow.booking.model;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class Appointment {
    private Long id;
    
    @NotNull(message = "Doctor ID is required")
    private Long doctorId;
    
    @NotNull(message = "Patient ID is required")
    private Long patientId;
    
    @NotNull(message = "Appointment date and time is required")
    @Future(message = "Appointment must be scheduled for a future date")
    private LocalDateTime appointmentDateTime;
    
    private AppointmentStatus status = AppointmentStatus.SCHEDULED;
    
    private String reason;
    private String notes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    private Doctor doctor;
    
    private Patient patient;
    
    // Constructors
    public Appointment() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    
    public Appointment(Long doctorId, Long patientId, LocalDateTime appointmentDateTime, String reason) {
        this();
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.appointmentDateTime = appointmentDateTime;
        this.reason = reason;
    }
    
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getDoctorId() {
        return doctorId;
    }
    
    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }
    
    public Long getPatientId() {
        return patientId;
    }
    
    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
    
    public LocalDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }
    
    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }
    
    public AppointmentStatus getStatus() {
        return status;
    }
    
    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }
    
    public String getReason() {
        return reason;
    }
    
    public void setReason(String reason) {
        this.reason = reason;
    }
    
    public String getNotes() {
        return notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    public Doctor getDoctor() {
        return doctor;
    }
    
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
    public Patient getPatient() {
        return patient;
    }
    
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    public enum AppointmentStatus {
        SCHEDULED, CONFIRMED, CANCELLED, COMPLETED, NO_SHOW
    }
}
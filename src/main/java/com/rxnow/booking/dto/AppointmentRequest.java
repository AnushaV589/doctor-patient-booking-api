package com.rxnow.booking.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class AppointmentRequest {
    @NotNull(message = "Doctor ID is required")
    private Long doctorId;
    
    @NotNull(message = "Patient ID is required")
    private Long patientId;
    
    @NotNull(message = "Appointment date and time is required")
    @Future(message = "Appointment must be scheduled for a future date")
    private LocalDateTime appointmentDateTime;
    
    private String reason;
    
    // Constructors
    public AppointmentRequest() {}
    
    public AppointmentRequest(Long doctorId, Long patientId, LocalDateTime appointmentDateTime, String reason) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.appointmentDateTime = appointmentDateTime;
        this.reason = reason;
    }
    
    // Getters and Setters
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
    
    public String getReason() {
        return reason;
    }
    
    public void setReason(String reason) {
        this.reason = reason;
    }
}
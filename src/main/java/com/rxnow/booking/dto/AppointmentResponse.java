package com.rxnow.booking.dto;

import com.rxnow.booking.model.Appointment;

import java.time.LocalDateTime;

public class AppointmentResponse {
    private Long id;
    private Long doctorId;
    private String doctorName;
    private String doctorSpecialization;
    private Long patientId;
    private String patientName;
    private LocalDateTime appointmentDateTime;
    private String status;
    private String reason;
    private String notes;
    private LocalDateTime createdAt;
    
    // Constructors
    public AppointmentResponse() {}
    
    public AppointmentResponse(Appointment appointment) {
        this.id = appointment.getId();
        this.doctorId = appointment.getDoctorId();
        this.patientId = appointment.getPatientId();
        this.appointmentDateTime = appointment.getAppointmentDateTime();
        this.status = appointment.getStatus().toString();
        this.reason = appointment.getReason();
        this.notes = appointment.getNotes();
        this.createdAt = appointment.getCreatedAt();
        
        if (appointment.getDoctor() != null) {
            this.doctorName = appointment.getDoctor().getName();
            this.doctorSpecialization = appointment.getDoctor().getSpecialization();
        }
        
        if (appointment.getPatient() != null) {
            this.patientName = appointment.getPatient().getName();
        }
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
    
    public String getDoctorName() {
        return doctorName;
    }
    
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
    
    public String getDoctorSpecialization() {
        return doctorSpecialization;
    }
    
    public void setDoctorSpecialization(String doctorSpecialization) {
        this.doctorSpecialization = doctorSpecialization;
    }
    
    public Long getPatientId() {
        return patientId;
    }
    
    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
    
    public String getPatientName() {
        return patientName;
    }
    
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
    
    public LocalDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }
    
    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
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
}
package com.rxnow.booking.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;
import java.util.List;

public class Doctor {
    private Long id;
    
    @NotBlank(message = "Doctor name is required")
    private String name;
    
    @NotBlank(message = "Specialization is required")
    private String specialization;
    
    private String email;
    private String phone;
    
    @NotNull(message = "Start time is required")
    private LocalTime startTime;
    
    @NotNull(message = "End time is required")
    private LocalTime endTime;
    
    private List<DayOfWeek> availableDays;
    
    private Double consultationFee;
    private String qualifications;
    private Integer experience;
    
    // Constructors
    public Doctor() {}
    
    public Doctor(String name, String specialization, String email, String phone, 
                  LocalTime startTime, LocalTime endTime, List<DayOfWeek> availableDays) {
        this.name = name;
        this.specialization = specialization;
        this.email = email;
        this.phone = phone;
        this.startTime = startTime;
        this.endTime = endTime;
        this.availableDays = availableDays;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSpecialization() {
        return specialization;
    }
    
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public LocalTime getStartTime() {
        return startTime;
    }
    
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
    
    public LocalTime getEndTime() {
        return endTime;
    }
    
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
    
    public List<DayOfWeek> getAvailableDays() {
        return availableDays;
    }
    
    public void setAvailableDays(List<DayOfWeek> availableDays) {
        this.availableDays = availableDays;
    }
    
    public Double getConsultationFee() {
        return consultationFee;
    }
    
    public void setConsultationFee(Double consultationFee) {
        this.consultationFee = consultationFee;
    }
    
    public String getQualifications() {
        return qualifications;
    }
    
    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }
    
    public Integer getExperience() {
        return experience;
    }
    
    public void setExperience(Integer experience) {
        this.experience = experience;
    }
    
    public enum DayOfWeek {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
}
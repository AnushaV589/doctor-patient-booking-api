package com.rxnow.booking.service;

import com.rxnow.booking.dto.AppointmentRequest;
import com.rxnow.booking.dto.AppointmentResponse;
import com.rxnow.booking.exception.AppointmentConflictException;
import com.rxnow.booking.exception.ResourceNotFoundException;
import com.rxnow.booking.model.Appointment;
import com.rxnow.booking.model.Doctor;
import com.rxnow.booking.model.Patient;
import com.rxnow.booking.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {
    
    @Autowired
    private AppointmentRepository appointmentRepository;
    
    @Autowired
    private DoctorService doctorService;
    
    @Autowired
    private PatientService patientService;
    
    public AppointmentResponse bookAppointment(AppointmentRequest request) {
        // Validate doctor and patient exist
        Doctor doctor = doctorService.getDoctorById(request.getDoctorId());
        Patient patient = patientService.getPatientById(request.getPatientId());
        
        // Check for appointment conflicts (30-minute buffer)
        LocalDateTime startTime = request.getAppointmentDateTime().minusMinutes(15);
        LocalDateTime endTime = request.getAppointmentDateTime().plusMinutes(45);
        
        long conflictCount = appointmentRepository.countConflictingAppointments(
                request.getDoctorId(), startTime, endTime);
        
        if (conflictCount > 0) {
            throw new AppointmentConflictException(
                    "Doctor has a conflicting appointment at the requested time");
        }
        
        // Create and save appointment
        Appointment appointment = new Appointment(
                request.getDoctorId(),
                request.getPatientId(),
                request.getAppointmentDateTime(),
                request.getReason()
        );
        
        appointment = appointmentRepository.save(appointment);
        
        // Load related entities for response
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        
        return new AppointmentResponse(appointment);
    }
    
    public List<AppointmentResponse> getAppointmentsByDoctorId(Long doctorId) {
        // Validate doctor exists
        doctorService.getDoctorById(doctorId);
        
        List<Appointment> appointments = appointmentRepository.findByDoctorIdOrderByAppointmentDateTimeAsc(doctorId);
        return appointments.stream()
                .map(appointment -> {
                    appointment.setDoctor(doctorService.getDoctorById(appointment.getDoctorId()));
                    appointment.setPatient(patientService.getPatientById(appointment.getPatientId()));
                    return new AppointmentResponse(appointment);
                })
                .collect(Collectors.toList());
    }
    
    public List<AppointmentResponse> getAppointmentsByPatientId(Long patientId) {
        // Validate patient exists
        patientService.getPatientById(patientId);
        
        List<Appointment> appointments = appointmentRepository.findByPatientIdOrderByAppointmentDateTimeAsc(patientId);
        return appointments.stream()
                .map(appointment -> {
                    appointment.setDoctor(doctorService.getDoctorById(appointment.getDoctorId()));
                    appointment.setPatient(patientService.getPatientById(appointment.getPatientId()));
                    return new AppointmentResponse(appointment);
                })
                .collect(Collectors.toList());
    }
    
    public List<AppointmentResponse> getAppointmentsWithFilters(Long doctorId, Long patientId, String status) {
        Appointment.AppointmentStatus appointmentStatus = null;
        if (status != null && !status.isEmpty()) {
            try {
                appointmentStatus = Appointment.AppointmentStatus.valueOf(status.toUpperCase());
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid appointment status: " + status);
            }
        }
        
        List<Appointment> appointments = appointmentRepository.findAppointmentsWithFilters(
                doctorId, patientId, appointmentStatus);
        
        return appointments.stream().map(appointment -> {
            if (appointment.getDoctorId() != null) {
                appointment.setDoctor(doctorService.getDoctorById(appointment.getDoctorId()));
            }
            if (appointment.getPatientId() != null) {
                appointment.setPatient(patientService.getPatientById(appointment.getPatientId()));
            }
            return new AppointmentResponse(appointment);
        }).collect(Collectors.toList());
    }
    
    public AppointmentResponse updateAppointmentStatus(Long appointmentId, Appointment.AppointmentStatus status) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with id: " + appointmentId));
        
        appointment.setStatus(status);
        appointment = appointmentRepository.save(appointment);
        
        // Load related entities for response
        appointment.setDoctor(doctorService.getDoctorById(appointment.getDoctorId()));
        appointment.setPatient(patientService.getPatientById(appointment.getPatientId()));
        
        return new AppointmentResponse(appointment);
    }
    
    public void cancelAppointment(Long appointmentId) {
        updateAppointmentStatus(appointmentId, Appointment.AppointmentStatus.CANCELLED);
    }
}
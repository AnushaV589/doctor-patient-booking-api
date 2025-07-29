package com.rxnow.booking.repository;

import com.rxnow.booking.model.Appointment;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class AppointmentRepository {
    
    private final Map<Long, Appointment> appointments = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);
    
    public List<Appointment> findAll() {
        return new ArrayList<>(appointments.values());
    }
    
    public Optional<Appointment> findById(Long id) {
        return Optional.ofNullable(appointments.get(id));
    }
    
    public Appointment save(Appointment appointment) {
        if (appointment.getId() == null) {
            appointment.setId(idGenerator.getAndIncrement());
        }
        appointments.put(appointment.getId(), appointment);
        return appointment;
    }
    
    public void deleteById(Long id) {
        appointments.remove(id);
    }
    
    public boolean existsById(Long id) {
        return appointments.containsKey(id);
    }
    
    public List<Appointment> findByDoctorIdOrderByAppointmentDateTimeAsc(Long doctorId) {
        return appointments.values().stream()
                .filter(appointment -> appointment.getDoctorId().equals(doctorId))
                .sorted(Comparator.comparing(Appointment::getAppointmentDateTime))
                .collect(Collectors.toList());
    }
    
    public List<Appointment> findByPatientIdOrderByAppointmentDateTimeAsc(Long patientId) {
        return appointments.values().stream()
                .filter(appointment -> appointment.getPatientId().equals(patientId))
                .sorted(Comparator.comparing(Appointment::getAppointmentDateTime))
                .collect(Collectors.toList());
    }
    
    public long countConflictingAppointments(Long doctorId, LocalDateTime startTime, LocalDateTime endTime) {
        return appointments.values().stream()
                .filter(appointment -> appointment.getDoctorId().equals(doctorId))
                .filter(appointment -> appointment.getStatus() != Appointment.AppointmentStatus.CANCELLED 
                        && appointment.getStatus() != Appointment.AppointmentStatus.NO_SHOW)
                .filter(appointment -> {
                    LocalDateTime appointmentTime = appointment.getAppointmentDateTime();
                    return appointmentTime.isAfter(startTime) && appointmentTime.isBefore(endTime);
                })
                .count();
    }
    
    public List<Appointment> findAppointmentsWithFilters(Long doctorId, Long patientId, 
                                                        Appointment.AppointmentStatus status) {
        return appointments.values().stream()
                .filter(appointment -> doctorId == null || appointment.getDoctorId().equals(doctorId))
                .filter(appointment -> patientId == null || appointment.getPatientId().equals(patientId))
                .filter(appointment -> status == null || appointment.getStatus().equals(status))
                .sorted(Comparator.comparing(Appointment::getAppointmentDateTime))
                .collect(Collectors.toList());
    }
}
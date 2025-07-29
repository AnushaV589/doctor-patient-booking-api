package com.rxnow.booking.repository;

import com.rxnow.booking.model.Doctor;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class DoctorRepository {
    
    private final Map<Long, Doctor> doctors = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);
    
    public List<Doctor> findAll() {
        return new ArrayList<>(doctors.values());
    }
    
    public Optional<Doctor> findById(Long id) {
        return Optional.ofNullable(doctors.get(id));
    }
    
    public Doctor save(Doctor doctor) {
        if (doctor.getId() == null) {
            doctor.setId(idGenerator.getAndIncrement());
        }
        doctors.put(doctor.getId(), doctor);
        return doctor;
    }
    
    public void deleteById(Long id) {
        doctors.remove(id);
    }
    
    public boolean existsById(Long id) {
        return doctors.containsKey(id);
    }
    
    public List<Doctor> findBySpecializationContainingIgnoreCase(String specialization) {
        return doctors.values().stream()
                .filter(doctor -> doctor.getSpecialization().toLowerCase()
                        .contains(specialization.toLowerCase()))
                .collect(Collectors.toList());
    }
    
    public List<Doctor> findDoctorsWithFilters(String specialization, String name) {
        return doctors.values().stream()
                .filter(doctor -> {
                    boolean matchesSpecialization = specialization == null || 
                            doctor.getSpecialization().toLowerCase()
                                    .contains(specialization.toLowerCase());
                    boolean matchesName = name == null || 
                            doctor.getName().toLowerCase()
                                    .contains(name.toLowerCase());
                    return matchesSpecialization && matchesName;
                })
                .collect(Collectors.toList());
    }
}
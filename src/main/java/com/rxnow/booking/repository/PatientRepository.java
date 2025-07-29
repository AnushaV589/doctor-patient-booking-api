package com.rxnow.booking.repository;

import com.rxnow.booking.model.Patient;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PatientRepository {
    
    private final Map<Long, Patient> patients = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);
    
    public List<Patient> findAll() {
        return new ArrayList<>(patients.values());
    }
    
    public Optional<Patient> findById(Long id) {
        return Optional.ofNullable(patients.get(id));
    }
    
    public Patient save(Patient patient) {
        if (patient.getId() == null) {
            patient.setId(idGenerator.getAndIncrement());
        }
        patients.put(patient.getId(), patient);
        return patient;
    }
    
    public void deleteById(Long id) {
        patients.remove(id);
    }
    
    public boolean existsById(Long id) {
        return patients.containsKey(id);
    }
    
    public Optional<Patient> findByEmail(String email) {
        return patients.values().stream()
                .filter(patient -> patient.getEmail().equals(email))
                .findFirst();
    }
}
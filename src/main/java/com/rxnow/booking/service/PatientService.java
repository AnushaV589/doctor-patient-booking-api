package com.rxnow.booking.service;

import com.rxnow.booking.exception.ResourceNotFoundException;
import com.rxnow.booking.model.Patient;
import com.rxnow.booking.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    
    @Autowired
    private PatientRepository patientRepository;
    
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
    
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + id));
    }
    
    public Patient getPatientByEmail(String email) {
        return patientRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with email: " + email));
    }
    
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }
    
    public Patient updatePatient(Long id, Patient patientDetails) {
        Patient patient = getPatientById(id);
        
        patient.setName(patientDetails.getName());
        patient.setEmail(patientDetails.getEmail());
        patient.setPhone(patientDetails.getPhone());
        patient.setDateOfBirth(patientDetails.getDateOfBirth());
        patient.setAddress(patientDetails.getAddress());
        patient.setGender(patientDetails.getGender());
        patient.setEmergencyContact(patientDetails.getEmergencyContact());
        
        return patientRepository.save(patient);
    }
    
    public void deletePatient(Long id) {
        if (!patientRepository.existsById(id)) {
            throw new ResourceNotFoundException("Patient not found with id: " + id);
        }
        patientRepository.deleteById(id);
    }
}
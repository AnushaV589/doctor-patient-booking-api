package com.rxnow.booking.service;

import com.rxnow.booking.exception.ResourceNotFoundException;
import com.rxnow.booking.model.Doctor;
import com.rxnow.booking.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    
    @Autowired
    private DoctorRepository doctorRepository;
    
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }
    
    public List<Doctor> getAllDoctorsWithFilters(String specialization, String name) {
        return doctorRepository.findDoctorsWithFilters(specialization, name);
    }
    
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id: " + id));
    }
    
    public List<Doctor> getDoctorsBySpecialization(String specialization) {
        return doctorRepository.findBySpecializationContainingIgnoreCase(specialization);
    }
    
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
    
    public Doctor updateDoctor(Long id, Doctor doctorDetails) {
        Doctor doctor = getDoctorById(id);
        
        doctor.setName(doctorDetails.getName());
        doctor.setSpecialization(doctorDetails.getSpecialization());
        doctor.setEmail(doctorDetails.getEmail());
        doctor.setPhone(doctorDetails.getPhone());
        doctor.setStartTime(doctorDetails.getStartTime());
        doctor.setEndTime(doctorDetails.getEndTime());
        doctor.setAvailableDays(doctorDetails.getAvailableDays());
        doctor.setConsultationFee(doctorDetails.getConsultationFee());
        doctor.setQualifications(doctorDetails.getQualifications());
        doctor.setExperience(doctorDetails.getExperience());
        
        return doctorRepository.save(doctor);
    }
    
    public void deleteDoctor(Long id) {
        if (!doctorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Doctor not found with id: " + id);
        }
        doctorRepository.deleteById(id);
    }
}
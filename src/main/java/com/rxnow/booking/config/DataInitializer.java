package com.rxnow.booking.config;

import com.rxnow.booking.model.Appointment;
import com.rxnow.booking.model.Doctor;
import com.rxnow.booking.model.Patient;
import com.rxnow.booking.repository.AppointmentRepository;
import com.rxnow.booking.repository.DoctorRepository;
import com.rxnow.booking.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private DoctorRepository doctorRepository;
    
    @Autowired
    private PatientRepository patientRepository;
    
    @Autowired
    private AppointmentRepository appointmentRepository;
    
    @Override
    public void run(String... args) throws Exception {
        initializeDoctors();
        initializePatients();
        initializeAppointments();
    }
    
    private void initializeDoctors() {
        // Dr. Sarah Johnson - Cardiology
        Doctor doctor1 = new Doctor();
        doctor1.setName("Dr. Sarah Johnson");
        doctor1.setSpecialization("Cardiology");
        doctor1.setEmail("sarah.johnson@rxnow.com");
        doctor1.setPhone("+1-555-0101");
        doctor1.setStartTime(LocalTime.of(9, 0));
        doctor1.setEndTime(LocalTime.of(17, 0));
        doctor1.setAvailableDays(Arrays.asList(
                Doctor.DayOfWeek.MONDAY, Doctor.DayOfWeek.TUESDAY, 
                Doctor.DayOfWeek.WEDNESDAY, Doctor.DayOfWeek.THURSDAY, Doctor.DayOfWeek.FRIDAY
        ));
        doctor1.setConsultationFee(200.00);
        doctor1.setQualifications("MD, FACC");
        doctor1.setExperience(12);
        doctorRepository.save(doctor1);
        
        // Dr. Michael Chen - Pediatrics
        Doctor doctor2 = new Doctor();
        doctor2.setName("Dr. Michael Chen");
        doctor2.setSpecialization("Pediatrics");
        doctor2.setEmail("michael.chen@rxnow.com");
        doctor2.setPhone("+1-555-0102");
        doctor2.setStartTime(LocalTime.of(8, 0));
        doctor2.setEndTime(LocalTime.of(16, 0));
        doctor2.setAvailableDays(Arrays.asList(
                Doctor.DayOfWeek.MONDAY, Doctor.DayOfWeek.TUESDAY, 
                Doctor.DayOfWeek.WEDNESDAY, Doctor.DayOfWeek.THURSDAY, 
                Doctor.DayOfWeek.FRIDAY, Doctor.DayOfWeek.SATURDAY
        ));
        doctor2.setConsultationFee(150.00);
        doctor2.setQualifications("MD, FAAP");
        doctor2.setExperience(8);
        doctorRepository.save(doctor2);
        
        // Dr. Emily Rodriguez - Dermatology
        Doctor doctor3 = new Doctor();
        doctor3.setName("Dr. Emily Rodriguez");
        doctor3.setSpecialization("Dermatology");
        doctor3.setEmail("emily.rodriguez@rxnow.com");
        doctor3.setPhone("+1-555-0103");
        doctor3.setStartTime(LocalTime.of(10, 0));
        doctor3.setEndTime(LocalTime.of(18, 0));
        doctor3.setAvailableDays(Arrays.asList(
                Doctor.DayOfWeek.TUESDAY, Doctor.DayOfWeek.WEDNESDAY, 
                Doctor.DayOfWeek.THURSDAY, Doctor.DayOfWeek.FRIDAY, Doctor.DayOfWeek.SATURDAY
        ));
        doctor3.setConsultationFee(175.00);
        doctor3.setQualifications("MD, FAAD");
        doctor3.setExperience(10);
        doctorRepository.save(doctor3);
        
        // Dr. James Wilson - Orthopedics
        Doctor doctor4 = new Doctor();
        doctor4.setName("Dr. James Wilson");
        doctor4.setSpecialization("Orthopedics");
        doctor4.setEmail("james.wilson@rxnow.com");
        doctor4.setPhone("+1-555-0104");
        doctor4.setStartTime(LocalTime.of(9, 0));
        doctor4.setEndTime(LocalTime.of(17, 0));
        doctor4.setAvailableDays(Arrays.asList(
                Doctor.DayOfWeek.MONDAY, Doctor.DayOfWeek.WEDNESDAY, Doctor.DayOfWeek.FRIDAY
        ));
        doctor4.setConsultationFee(250.00);
        doctor4.setQualifications("MD, FAAOS");
        doctor4.setExperience(15);
        doctorRepository.save(doctor4);
        
        // Dr. Lisa Kumar - Internal Medicine
        Doctor doctor5 = new Doctor();
        doctor5.setName("Dr. Lisa Kumar");
        doctor5.setSpecialization("Internal Medicine");
        doctor5.setEmail("lisa.kumar@rxnow.com");
        doctor5.setPhone("+1-555-0105");
        doctor5.setStartTime(LocalTime.of(8, 30));
        doctor5.setEndTime(LocalTime.of(16, 30));
        doctor5.setAvailableDays(Arrays.asList(
                Doctor.DayOfWeek.MONDAY, Doctor.DayOfWeek.TUESDAY, 
                Doctor.DayOfWeek.WEDNESDAY, Doctor.DayOfWeek.THURSDAY, Doctor.DayOfWeek.FRIDAY
        ));
        doctor5.setConsultationFee(180.00);
        doctor5.setQualifications("MD, FACP");
        doctor5.setExperience(9);
        doctorRepository.save(doctor5);
    }
    
    private void initializePatients() {
        // Patient 1
        Patient patient1 = new Patient();
        patient1.setName("John Smith");
        patient1.setEmail("john.smith@email.com");
        patient1.setPhone("+1-555-1001");
        patient1.setDateOfBirth(LocalDate.of(1985, 3, 15));
        patient1.setGender("Male");
        patient1.setAddress("123 Main St, Springfield, IL");
        patientRepository.save(patient1);
        
        // Patient 2
        Patient patient2 = new Patient();
        patient2.setName("Emma Johnson");
        patient2.setEmail("emma.johnson@email.com");
        patient2.setPhone("+1-555-1002");
        patient2.setDateOfBirth(LocalDate.of(1990, 7, 22));
        patient2.setGender("Female");
        patient2.setAddress("456 Oak Ave, Springfield, IL");
        patientRepository.save(patient2);
        
        // Patient 3
        Patient patient3 = new Patient();
        patient3.setName("Robert Brown");
        patient3.setEmail("robert.brown@email.com");
        patient3.setPhone("+1-555-1003");
        patient3.setDateOfBirth(LocalDate.of(1982, 11, 8));
        patient3.setGender("Male");
        patient3.setAddress("789 Pine Rd, Springfield, IL");
        patientRepository.save(patient3);
        
        // Patient 4
        Patient patient4 = new Patient();
        patient4.setName("Jennifer Davis");
        patient4.setEmail("jennifer.davis@email.com");
        patient4.setPhone("+1-555-1004");
        patient4.setDateOfBirth(LocalDate.of(1995, 1, 30));
        patient4.setGender("Female");
        patient4.setAddress("321 Elm St, Springfield, IL");
        patientRepository.save(patient4);
        
        // Patient 5
        Patient patient5 = new Patient();
        patient5.setName("David Miller");
        patient5.setEmail("david.miller@email.com");
        patient5.setPhone("+1-555-1005");
        patient5.setDateOfBirth(LocalDate.of(1988, 9, 12));
        patient5.setGender("Male");
        patient5.setAddress("654 Maple Dr, Springfield, IL");
        patientRepository.save(patient5);
    }
    
    private void initializeAppointments() {
        // Sample appointments
        Appointment appointment1 = new Appointment();
        appointment1.setDoctorId(1L);
        appointment1.setPatientId(1L);
        appointment1.setAppointmentDateTime(LocalDateTime.of(2024, 2, 15, 10, 0));
        appointment1.setStatus(Appointment.AppointmentStatus.SCHEDULED);
        appointment1.setReason("Regular checkup");
        appointmentRepository.save(appointment1);
        
        Appointment appointment2 = new Appointment();
        appointment2.setDoctorId(2L);
        appointment2.setPatientId(2L);
        appointment2.setAppointmentDateTime(LocalDateTime.of(2024, 2, 16, 14, 30));
        appointment2.setStatus(Appointment.AppointmentStatus.CONFIRMED);
        appointment2.setReason("Child vaccination");
        appointmentRepository.save(appointment2);
        
        Appointment appointment3 = new Appointment();
        appointment3.setDoctorId(3L);
        appointment3.setPatientId(3L);
        appointment3.setAppointmentDateTime(LocalDateTime.of(2024, 2, 17, 11, 15));
        appointment3.setStatus(Appointment.AppointmentStatus.SCHEDULED);
        appointment3.setReason("Skin condition consultation");
        appointmentRepository.save(appointment3);
        
        Appointment appointment4 = new Appointment();
        appointment4.setDoctorId(4L);
        appointment4.setPatientId(4L);
        appointment4.setAppointmentDateTime(LocalDateTime.of(2024, 2, 18, 15, 45));
        appointment4.setStatus(Appointment.AppointmentStatus.SCHEDULED);
        appointment4.setReason("Knee pain assessment");
        appointmentRepository.save(appointment4);
        
        Appointment appointment5 = new Appointment();
        appointment5.setDoctorId(5L);
        appointment5.setPatientId(5L);
        appointment5.setAppointmentDateTime(LocalDateTime.of(2024, 2, 19, 9, 30));
        appointment5.setStatus(Appointment.AppointmentStatus.CONFIRMED);
        appointment5.setReason("Annual physical exam");
        appointmentRepository.save(appointment5);
    }
}
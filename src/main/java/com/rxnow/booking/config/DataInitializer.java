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
        // Dr. Anusha - Cardiology
        Doctor doctor1 = new Doctor();
        doctor1.setName("Dr. Anusha Vanapalli");
        doctor1.setSpecialization("Cardiology");
        doctor1.setEmail("anusha.v@rxnow.com");
        doctor1.setPhone("+91-9133508724");
        doctor1.setStartTime(LocalTime.of(9, 0));
        doctor1.setEndTime(LocalTime.of(17, 0));
        doctor1.setAvailableDays(Arrays.asList(
                Doctor.DayOfWeek.MONDAY, Doctor.DayOfWeek.TUESDAY,
                Doctor.DayOfWeek.WEDNESDAY, Doctor.DayOfWeek.THURSDAY, Doctor.DayOfWeek.FRIDAY
        ));
        doctor1.setConsultationFee(500.00);
        doctor1.setQualifications("MBBS, MD");
        doctor1.setExperience(5);
        doctorRepository.save(doctor1);

        // Dr. Sravani - Pediatrics
        Doctor doctor2 = new Doctor();
        doctor2.setName("Dr. Sravani Reddy");
        doctor2.setSpecialization("Pediatrics");
        doctor2.setEmail("sravani.reddy@rxnow.com");
        doctor2.setPhone("+91-9123456780");
        doctor2.setStartTime(LocalTime.of(8, 0));
        doctor2.setEndTime(LocalTime.of(16, 0));
        doctor2.setAvailableDays(Arrays.asList(
                Doctor.DayOfWeek.MONDAY, Doctor.DayOfWeek.TUESDAY,
                Doctor.DayOfWeek.WEDNESDAY, Doctor.DayOfWeek.THURSDAY,
                Doctor.DayOfWeek.FRIDAY, Doctor.DayOfWeek.SATURDAY
        ));
        doctor2.setConsultationFee(450.00);
        doctor2.setQualifications("MBBS, DCH");
        doctor2.setExperience(3);
        doctorRepository.save(doctor2);

        // Dr. Vara - Dermatology
        Doctor doctor3 = new Doctor();
        doctor3.setName("Dr. Vara Lakshmi");
        doctor3.setSpecialization("Dermatology");
        doctor3.setEmail("vara.lakshmi@rxnow.com");
        doctor3.setPhone("+91-9000001234");
        doctor3.setStartTime(LocalTime.of(10, 0));
        doctor3.setEndTime(LocalTime.of(18, 0));
        doctor3.setAvailableDays(Arrays.asList(
                Doctor.DayOfWeek.TUESDAY, Doctor.DayOfWeek.WEDNESDAY,
                Doctor.DayOfWeek.THURSDAY, Doctor.DayOfWeek.FRIDAY, Doctor.DayOfWeek.SATURDAY
        ));
        doctor3.setConsultationFee(600.00);
        doctor3.setQualifications("MBBS, DDVL");
        doctor3.setExperience(4);
        doctorRepository.save(doctor3);

        // Dr. Kishore - Orthopedics
        Doctor doctor4 = new Doctor();
        doctor4.setName("Dr. Kishore Kumar");
        doctor4.setSpecialization("Orthopedics");
        doctor4.setEmail("kishore.k@rxnow.com");
        doctor4.setPhone("+91-9876543210");
        doctor4.setStartTime(LocalTime.of(9, 0));
        doctor4.setEndTime(LocalTime.of(17, 0));
        doctor4.setAvailableDays(Arrays.asList(
                Doctor.DayOfWeek.MONDAY, Doctor.DayOfWeek.WEDNESDAY, Doctor.DayOfWeek.FRIDAY
        ));
        doctor4.setConsultationFee(700.00);
        doctor4.setQualifications("MBBS, MS Ortho");
        doctor4.setExperience(6);
        doctorRepository.save(doctor4);

        // Dr. Chandu - Internal Medicine
        Doctor doctor5 = new Doctor();
        doctor5.setName("Dr. Chandu Teja");
        doctor5.setSpecialization("Internal Medicine");
        doctor5.setEmail("chandu.teja@rxnow.com");
        doctor5.setPhone("+91-9012345678");
        doctor5.setStartTime(LocalTime.of(8, 30));
        doctor5.setEndTime(LocalTime.of(16, 30));
        doctor5.setAvailableDays(Arrays.asList(
                Doctor.DayOfWeek.MONDAY, Doctor.DayOfWeek.TUESDAY,
                Doctor.DayOfWeek.WEDNESDAY, Doctor.DayOfWeek.THURSDAY, Doctor.DayOfWeek.FRIDAY
        ));
        doctor5.setConsultationFee(480.00);
        doctor5.setQualifications("MBBS, MD Internal Medicine");
        doctor5.setExperience(4);
        doctorRepository.save(doctor5);
    }

    private void initializePatients() {
        Patient p1 = new Patient();
        p1.setName("Karthik");
        p1.setEmail("karthik@rxnow.com");
        p1.setPhone("+91-8000000001");
        p1.setDateOfBirth(LocalDate.of(1990, 1, 1));
        p1.setGender("Male");
        p1.setAddress("Hyderabad, Telangana");
        patientRepository.save(p1);

        Patient p2 = new Patient();
        p2.setName("Shashank");
        p2.setEmail("shashank@rxnow.com");
        p2.setPhone("+91-8000000002");
        p2.setDateOfBirth(LocalDate.of(1992, 2, 2));
        p2.setGender("Male");
        p2.setAddress("Vijayawada, AP");
        patientRepository.save(p2);

        Patient p3 = new Patient();
        p3.setName("Deepika");
        p3.setEmail("deepika@rxnow.com");
        p3.setPhone("+91-8000000003");
        p3.setDateOfBirth(LocalDate.of(1994, 3, 3));
        p3.setGender("Female");
        p3.setAddress("Guntur, AP");
        patientRepository.save(p3);

        Patient p4 = new Patient();
        p4.setName("Nikhil");
        p4.setEmail("nikhil@rxnow.com");
        p4.setPhone("+91-8000000004");
        p4.setDateOfBirth(LocalDate.of(1996, 4, 4));
        p4.setGender("Male");
        p4.setAddress("Warangal, Telangana");
        patientRepository.save(p4);

        Patient p5 = new Patient();
        p5.setName("Swathi");
        p5.setEmail("swathi@rxnow.com");
        p5.setPhone("+91-8000000005");
        p5.setDateOfBirth(LocalDate.of(1998, 5, 5));
        p5.setGender("Female");
        p5.setAddress("Vizag, AP");
        patientRepository.save(p5);
    }

    private void initializeAppointments() {
        Appointment a1 = new Appointment();
        a1.setDoctorId(1L);
        a1.setPatientId(1L);
        a1.setAppointmentDateTime(LocalDateTime.of(2025, 8, 1, 10, 0));
        a1.setStatus(Appointment.AppointmentStatus.SCHEDULED);
        a1.setReason("Chest pain checkup");
        appointmentRepository.save(a1);

        Appointment a2 = new Appointment();
        a2.setDoctorId(2L);
        a2.setPatientId(2L);
        a2.setAppointmentDateTime(LocalDateTime.of(2025, 8, 2, 14, 30));
        a2.setStatus(Appointment.AppointmentStatus.CONFIRMED);
        a2.setReason("Child fever consultation");
        appointmentRepository.save(a2);

        Appointment a3 = new Appointment();
        a3.setDoctorId(3L);
        a3.setPatientId(3L);
        a3.setAppointmentDateTime(LocalDateTime.of(2025, 8, 3, 11, 15));
        a3.setStatus(Appointment.AppointmentStatus.SCHEDULED);
        a3.setReason("Acne treatment");
        appointmentRepository.save(a3);

        Appointment a4 = new Appointment();
        a4.setDoctorId(4L);
        a4.setPatientId(4L);
        a4.setAppointmentDateTime(LocalDateTime.of(2025, 8, 4, 15, 45));
        a4.setStatus(Appointment.AppointmentStatus.SCHEDULED);
        a4.setReason("Joint pain");
        appointmentRepository.save(a4);

        Appointment a5 = new Appointment();
        a5.setDoctorId(5L);
        a5.setPatientId(5L);
        a5.setAppointmentDateTime(LocalDateTime.of(2025, 8, 5, 9, 30));
        a5.setStatus(Appointment.AppointmentStatus.CONFIRMED);
        a5.setReason("Diabetes checkup");
        appointmentRepository.save(a5);
    }
}

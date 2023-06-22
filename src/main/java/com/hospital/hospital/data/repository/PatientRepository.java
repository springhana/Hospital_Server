package com.hospital.hospital.data.repository;

import com.hospital.hospital.data.entity.Doctor;
import com.hospital.hospital.data.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}

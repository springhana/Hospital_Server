package com.hospital.hospital.data.repository;

import com.hospital.hospital.data.entity.Diagnosis;
import com.hospital.hospital.data.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    @Query("select doctor from Doctor as doctor where doctor.doctorId = ?1")
    List<Doctor> findByName(Integer id);

}

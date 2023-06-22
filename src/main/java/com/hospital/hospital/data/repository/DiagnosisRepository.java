package com.hospital.hospital.data.repository;

import com.hospital.hospital.data.entity.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DiagnosisRepository extends JpaRepository<Diagnosis, Integer> {
    Optional<Diagnosis> findById(Integer number);
}

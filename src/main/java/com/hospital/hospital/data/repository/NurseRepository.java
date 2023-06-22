package com.hospital.hospital.data.repository;

import com.hospital.hospital.data.entity.Doctor;
import com.hospital.hospital.data.entity.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NurseRepository extends JpaRepository<Nurse, Integer> {

    @Query("select nurse from Nurse as nurse where nurse.nurseNumber = ?1")
    List<Nurse> findByName(Integer name);

}

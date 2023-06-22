package com.hospital.hospital.data.dao.impl;

import com.hospital.hospital.data.dao.PatientDAO;
import com.hospital.hospital.data.entity.Nurse;
import com.hospital.hospital.data.entity.Patient;
import com.hospital.hospital.data.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PatientDAOImpl implements PatientDAO {

    private PatientRepository patientRepository;

    @Autowired
    public PatientDAOImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> getAllPatient() {
        List<Patient> lists = patientRepository.findAll();
        return lists;
    }
}

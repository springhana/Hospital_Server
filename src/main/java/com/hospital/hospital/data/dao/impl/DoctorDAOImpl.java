package com.hospital.hospital.data.dao.impl;

import com.hospital.hospital.data.dao.DoctorDAO;
import com.hospital.hospital.data.entity.Doctor;
import com.hospital.hospital.data.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DoctorDAOImpl implements DoctorDAO {
    private DoctorRepository doctorRepository;

    @Autowired
    public DoctorDAOImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        List<Doctor> lists = doctorRepository.findAll();
        return lists;
    }
}

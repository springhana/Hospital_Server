package com.hospital.hospital.data.dao.impl;

import com.hospital.hospital.data.dao.NurseDAO;
import com.hospital.hospital.data.entity.Nurse;
import com.hospital.hospital.data.repository.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NurseDAOImpl implements NurseDAO {
    private NurseRepository nurseRepository;

    @Autowired
    public NurseDAOImpl(NurseRepository nurseRepository) {
        this.nurseRepository = nurseRepository;
    }

    @Override
    public List<Nurse> getAllNurses() {
        List<Nurse> lists = nurseRepository.findAll();
        return lists;
    }
}

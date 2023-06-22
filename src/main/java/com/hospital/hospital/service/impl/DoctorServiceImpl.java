package com.hospital.hospital.service.impl;

import com.hospital.hospital.data.dao.DoctorDAO;
import com.hospital.hospital.data.entity.Doctor;
import com.hospital.hospital.data.entity.dto.DoctorDto;
import com.hospital.hospital.service.DoctorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorDAO doctorDAO;

    public DoctorServiceImpl(DoctorDAO doctorDAO) {
        this.doctorDAO = doctorDAO;
    }

    @Override
    public List<DoctorDto> getAllDoctor() {
        List<Doctor> lists = doctorDAO.getAllDoctors();
        List<DoctorDto> listsDto = new ArrayList<>();
        for (Doctor p : lists
        ) {
            DoctorDto dto = new DoctorDto();
            dto.setDoctorId(p.getDoctorId());
            dto.setDoctorName(p.getDoctorName());
            dto.setTel(p.getTel());
            dto.setFieldOfMedicine(p.getFieldOfMedicine());
            listsDto.add(dto);
        }

        return listsDto;
    }
}

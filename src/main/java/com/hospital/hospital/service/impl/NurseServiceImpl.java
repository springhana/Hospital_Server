package com.hospital.hospital.service.impl;

import com.hospital.hospital.data.dao.NurseDAO;
import com.hospital.hospital.data.entity.Nurse;
import com.hospital.hospital.data.entity.dto.NurseDto;
import com.hospital.hospital.service.NurseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NurseServiceImpl implements NurseService {
    private final NurseDAO nurseDAO;

    public NurseServiceImpl(NurseDAO nurseDAO) {
        this.nurseDAO = nurseDAO;
    }


    @Override
    public List<NurseDto> getAllNurse() {
        List<Nurse> lists = nurseDAO.getAllNurses();
        List<NurseDto> listsDto = new ArrayList<>();
        for (Nurse p : lists
        ) {
            NurseDto dto = new NurseDto();
            dto.setNurseNumber(p.getNurseNumber());
            dto.setNurseName(p.getNurseName());
            dto.setTel(p.getTel());
            dto.setFunctions(p.getFunctions());
            listsDto.add(dto);
        }

        return listsDto;
    }
}

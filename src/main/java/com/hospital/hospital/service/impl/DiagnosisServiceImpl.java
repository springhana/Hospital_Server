package com.hospital.hospital.service.impl;

import com.hospital.hospital.data.dao.DiagnosisDAO;
import com.hospital.hospital.data.entity.Diagnosis;
import com.hospital.hospital.data.entity.dto.DiagnosisDto;
import com.hospital.hospital.service.DiagnosisService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiagnosisServiceImpl implements DiagnosisService {

    private final DiagnosisDAO diagnosisDAO;

    public DiagnosisServiceImpl(DiagnosisDAO diagnosisDAO) {
        this.diagnosisDAO = diagnosisDAO;
    }

    @Override
    public List<DiagnosisDto> getAllDiagnosis() {
        List<Diagnosis> lists = diagnosisDAO.getAllDiagnosis();
        List<DiagnosisDto> listsDto = new ArrayList<>();
        for (Diagnosis p : lists
        ) {
            DiagnosisDto dto = new DiagnosisDto();
            dto.setDiagnosisNum(p.getDiagnosisNum());
            dto.setDiagnosisContent(p.getDiagnosisContent());
            dto.setDiagnosisDate(p.getDiagnosisDate());
            dto.setDoctor(p.getDoctor());
            dto.setPatient(p.getPatient());
            listsDto.add(dto);
        }

        return listsDto;
    }

    @Override
    public void deleteProduct(Integer number) throws Exception {
        diagnosisDAO.deleteProduct(number);
    }
}

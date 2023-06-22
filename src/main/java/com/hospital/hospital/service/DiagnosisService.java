package com.hospital.hospital.service;

import com.hospital.hospital.data.entity.dto.DiagnosisDto;

import java.util.List;

public interface DiagnosisService {
    List<DiagnosisDto> getAllDiagnosis();

    void deleteProduct(Integer number) throws Exception;

}

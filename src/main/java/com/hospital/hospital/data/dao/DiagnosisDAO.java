package com.hospital.hospital.data.dao;

import com.hospital.hospital.data.entity.Diagnosis;

import java.util.List;

public interface DiagnosisDAO {
    List<Diagnosis> getAllDiagnosis();

    void deleteProduct(Integer number) throws Exception;
}

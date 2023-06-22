package com.hospital.hospital.data.dao.impl;

import com.hospital.hospital.data.dao.DiagnosisDAO;
import com.hospital.hospital.data.entity.Diagnosis;
import com.hospital.hospital.data.repository.DiagnosisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class DiagnosisDAOImpl implements DiagnosisDAO {

    private DiagnosisRepository diagnosisRepository;

    @Autowired
    public DiagnosisDAOImpl(DiagnosisRepository diagnosisRepository) {
        this.diagnosisRepository = diagnosisRepository;
    }

    @Override
    public List<Diagnosis> getAllDiagnosis() {
        List<Diagnosis> lists = diagnosisRepository.findAll();
        return lists;
    }

    @Override
    public void deleteProduct(Integer number) throws Exception {
        Optional<Diagnosis> selected = diagnosisRepository.findById(number);

        if (selected.isPresent()) {
            Diagnosis diagnosis = selected.get();

            diagnosisRepository.delete(diagnosis);
        } else {
            throw new Exception();
        }
    }
}

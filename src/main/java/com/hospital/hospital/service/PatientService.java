package com.hospital.hospital.service;

import com.hospital.hospital.data.entity.dto.PatientDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PatientService {
    List<PatientDto> getAllPatient();

    String joinOneImage(MultipartFile filename);

}

package com.hospital.hospital.data.entity.dto;

import com.hospital.hospital.data.entity.Doctor;
import com.hospital.hospital.data.entity.Patient;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DiagnosisDto {
    private Integer diagnosisNum;

    private String diagnosisContent;

    private Date diagnosisDate;

    private Doctor doctor;

    private Patient patient;
}

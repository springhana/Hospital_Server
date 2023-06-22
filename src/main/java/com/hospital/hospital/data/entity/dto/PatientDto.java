package com.hospital.hospital.data.entity.dto;

import com.hospital.hospital.data.entity.Doctor;
import com.hospital.hospital.data.entity.Nurse;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class PatientDto {
    private Integer patientNum;

    private String patientName;

    private String tel;

    private String image;

    private Doctor doctor;

    private Nurse nurse;
}

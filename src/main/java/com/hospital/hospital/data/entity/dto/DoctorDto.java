package com.hospital.hospital.data.entity.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DoctorDto {
    private Integer doctorId;

    private String doctorName;

    private String tel;

    private String fieldOfMedicine;

}

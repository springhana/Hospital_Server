package com.hospital.hospital.data.entity.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class NurseDto {
    private Integer nurseNumber;

    private String nurseName;

    private String tel;

    private String functions;
}

package com.hospital.hospital.data.entity.dto;

import com.hospital.hospital.data.entity.Diagnosis;
import com.hospital.hospital.data.entity.Nurse;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ChartDto {

    private Integer chartNum;

    private String chartContent;

    private Diagnosis diagnosis;

    private Nurse nurse;

}

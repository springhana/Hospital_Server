package com.hospital.hospital.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Table(name = "Diagnosis")
public class Diagnosis {
    @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diagnosis_num")
    private Integer diagnosisNum;

    @Column(name = "diagnosis_content")
    private String diagnosisContent;

    @Column(name = "diagnosis_date")
    private Date diagnosisDate;

    @ManyToOne
    @JoinColumn(name = "doctor_doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_patient_num")
    private Patient patient;

    // 생성자, getter 및 setter 메서드
}

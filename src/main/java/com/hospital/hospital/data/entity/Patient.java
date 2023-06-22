package com.hospital.hospital.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Table(name = "Patient")
public class Patient {

    @Id
    @Column(name = "patient_num")
    private Integer patientNum;

    @Column(name = "patient_name")
    private String patientName;

    @Column(name = "tel", unique=true)
    private String tel;

    @Column(name = "image")
    private String image;

    @ManyToOne
    @JoinColumn(name = "doctor_doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "nurse_nurse_number")
    private Nurse nurse;

    // 생성자, getter 및 setter 메서드
}


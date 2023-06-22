package com.hospital.hospital.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Table(name = "Doctor")
public class Doctor {
    @Id
    @Column(name = "doctor_id")
    private Integer doctorId;

    @Column(name = "doctor_name")
    private String doctorName;

    @Column(name = "tel")
    private String tel;

    @Column(name = "the_field_of_medicine")
    private String fieldOfMedicine;

    // 생성자, getter 및 setter 메서드
}

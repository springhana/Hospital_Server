package com.hospital.hospital.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Table(name = "Nurse")
public class Nurse {
    @Id
    @Column(name = "nurse_number")
    private Integer nurseNumber;

    @Column(name = "nurse_name")
    private String nurseName;

    @Column(name = "tel")
    private String tel;

    @Column(name = "functions")
    private String functions;

    // 생성자, getter 및 setter 메서드
}

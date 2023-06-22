package com.hospital.hospital.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Table(name = "Chart")
public class Chart { //차트 테이블
    @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chart_num")
    private Integer chartNum;

    @Column(name = "chart_content")
    private String chartContent;

    @ManyToOne
    @JoinColumn(name = "diagnosis_diagnosis_num")
    private Diagnosis diagnosis;

    @ManyToOne
    @JoinColumn(name = "nurse_nurse_number")
    private Nurse nurse;

    // 생성자, getter 및 setter 메서드
}

package com.hospital.hospital.controller;

import com.hospital.hospital.data.entity.Patient;
import com.hospital.hospital.data.entity.QPatient;
import com.hospital.hospital.data.entity.dto.PatientDto;
import com.hospital.hospital.service.PatientService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Patient")
//@CrossOrigin(origins = "http://192.168.68.51:8080") // 집에 가면 ip주소 바꿔야함
@CrossOrigin(origins = "*") // 집에 가면 ip주소 바꿔야함
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patient_getAll")
    public ResponseEntity<List<PatientDto>> get() {
        List<PatientDto> getAll = patientService.getAllPatient();
        return ResponseEntity.status(HttpStatus.OK).body(getAll);
    }

    @PersistenceContext
    EntityManager entityManager;

    @GetMapping("/patientOne")
    public ResponseEntity<List<Patient>> patientOne(String name, String tel) {
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        QPatient qPatient = QPatient.patient;

        List<Patient> qPatientList = jpaQueryFactory
                .select(qPatient)
                .from(qPatient)
                .where(qPatient.patientName.eq(name), qPatient.tel.eq(tel))
                .orderBy(qPatient.patientNum.asc())
                .fetch();

        return ResponseEntity.status(HttpStatus.OK).body(qPatientList);
    }

    @GetMapping("/patientIdOne")
    public ResponseEntity<List<Patient>> patientIdOne(Integer number) {
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        QPatient qPatient = QPatient.patient;

        List<Patient> qPatientList = jpaQueryFactory
                .select(qPatient)
                .from(qPatient)
                .where(qPatient.patientNum.eq(number))
                .orderBy(qPatient.patientNum.asc())
                .fetch();

        return ResponseEntity.status(HttpStatus.OK).body(qPatientList);
    }


}

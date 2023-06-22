package com.hospital.hospital.controller;

import com.hospital.hospital.data.entity.Diagnosis;
import com.hospital.hospital.data.entity.QDiagnosis;
import com.hospital.hospital.data.entity.dto.DiagnosisDto;
import com.hospital.hospital.service.DiagnosisService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diagnosis")
//@CrossOrigin(origins = "http://192.168.68.51:8080") // 집에 가면 ip주소 바꿔야함
@CrossOrigin(origins = "*") // 집에 가면 ip주소 바꿔야함
public class DiagnosisContorller {
    private final DiagnosisService diagnosisService;

//    @Autowired
//    DiagnosisRepository diagnosisRepository;

    public DiagnosisContorller(DiagnosisService diagnosisService) {
        this.diagnosisService = diagnosisService;
    }

    @GetMapping("/diagnosis_getAll")
    public ResponseEntity<List<DiagnosisDto>> get() {
        List<DiagnosisDto> getAll = diagnosisService.getAllDiagnosis();
        return ResponseEntity.status(HttpStatus.OK).body(getAll);
    }

    @PersistenceContext
    EntityManager entityManager;

    @GetMapping("/diagnosisOne_doctorId")
    public ResponseEntity<List<Diagnosis>> diagnosisOne_doctorId(Integer number) {
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        QDiagnosis qDiagnosis = QDiagnosis.diagnosis;

        List<Diagnosis> diagnosisList = jpaQueryFactory
                .select(qDiagnosis)
                .from(qDiagnosis)
                .where(qDiagnosis.doctor.doctorId.eq(number))
                .orderBy(qDiagnosis.diagnosisNum.asc())
                .fetch();

        return ResponseEntity.status(HttpStatus.OK).body(diagnosisList);
    }

    @GetMapping("/diagnosisOne_patientId")
    public ResponseEntity<List<Diagnosis>> diagnosisOne_patientId(Integer number) {
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        QDiagnosis qDiagnosis = QDiagnosis.diagnosis;

        List<Diagnosis> diagnosisList = jpaQueryFactory
                .select(qDiagnosis)
                .from(qDiagnosis)
                .where(qDiagnosis.patient.patientNum.eq(number))
                .orderBy(qDiagnosis.diagnosisNum.asc())
                .fetch();

        return ResponseEntity.status(HttpStatus.OK).body(diagnosisList);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteDiagnosis(Integer number) throws Exception {
        diagnosisService.deleteProduct(number);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }
}

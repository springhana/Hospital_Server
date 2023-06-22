package com.hospital.hospital.controller;

import com.hospital.hospital.data.entity.Doctor;
import com.hospital.hospital.data.entity.QDoctor;
import com.hospital.hospital.data.entity.dto.DoctorDto;
import com.hospital.hospital.data.repository.DoctorRepository;
import com.hospital.hospital.service.DoctorService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
//@CrossOrigin(origins = "http://192.168.68.51:8080") // 집에 가면 ip주소 바꿔야함
@CrossOrigin(origins = "*") // 집에 가면 ip주소 바꿔야함
public class DoctorController {

    private final DoctorService doctorService;

    private final DoctorRepository doctorRepository;

//    @Autowired
//    DoctorRepository doctorRepository;

    public DoctorController(DoctorService doctorService, DoctorRepository doctorRepository) {
        this.doctorService = doctorService;
        this.doctorRepository = doctorRepository;
    }


    @GetMapping("/doctor_getAll")
    public ResponseEntity<List<DoctorDto>> get() {
        List<DoctorDto> getAll = doctorService.getAllDoctor();
        return ResponseEntity.status(HttpStatus.OK).body(getAll);
    }

    @PersistenceContext
    EntityManager entityManager;

    @GetMapping("/doctorOne")
    public ResponseEntity<List<Doctor>> doctorOne(String name, Integer number) {
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        QDoctor qDoctor = QDoctor.doctor;

        List<Doctor> doctorList = jpaQueryFactory
                .select(qDoctor)
                .from(qDoctor)
                .where(qDoctor.doctorName.eq(name), qDoctor.doctorId.eq(number))
                .orderBy(qDoctor.doctorId.asc())
                .fetch();

        return ResponseEntity.status(HttpStatus.OK).body(doctorList);
    }

    @PostMapping("/doctorPost")
    public String saveMany() {
        //의사 데이터 저장 (DB 에서만 가능하게)
        Integer[] doctorId = {800101,800312,800403,800543,800576,800601,800900,801001,801208,802019};
        String[] doctorName = {"차태현","이태정","이태서","유재석","홍길동","안성기","김연아","김병만","김민종","전지현"};
        String[] doctorTel = {"011-222-7643","010-333-1340","019-777-3764","010-222-1263","016-333-7263","011-222-0987","010-555-3784","010-555-3542","010-333-8743","010-999-1265"};
        String[] doctorMedicine = {"내과","소아과","피부과","방사선과","피부과","내과","소아과","외과","외과","소아과"};
        
        for (int i = 0; i < doctorId.length; i++){
            Doctor doctor = new Doctor();
            doctor.setDoctorId(doctorId[i]);
            doctor.setDoctorName(doctorName[i]);
            doctor.setTel(doctorTel[i]);
            doctor.setFieldOfMedicine(doctorMedicine[i]);
            doctorRepository.save(doctor);
        }
        return "의사 데이터 저장";
    }

    //  thymeleaf 의사 데이터 가져오기
    @GetMapping("/doctors")
    public ResponseEntity<List<DoctorDto>> getDoctors(Model model) {
        List<DoctorDto> doctors = doctorService.getAllDoctor();
        model.addAttribute("doctors", doctors);
        return ResponseEntity.status(HttpStatus.OK).body(doctors);
    }
}

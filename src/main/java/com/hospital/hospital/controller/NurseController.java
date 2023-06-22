package com.hospital.hospital.controller;

import com.hospital.hospital.data.entity.Nurse;
import com.hospital.hospital.data.entity.QNurse;
import com.hospital.hospital.data.entity.dto.NurseDto;
import com.hospital.hospital.data.repository.NurseRepository;
import com.hospital.hospital.service.NurseService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nurse")
//@CrossOrigin(origins = "http://192.168.68.51:8080") // 집에 가면 ip주소 바꿔야함
@CrossOrigin(origins = "*") // 집에 가면 ip주소 바꿔야함
public class NurseController {
    private final NurseService nurseService;
    private final NurseRepository nurseRepository;

//    @Autowired
//    NurseRepository nurseRepository;

    public NurseController(NurseService nurseService, NurseRepository nurseRepository) {
        this.nurseService = nurseService;
        this.nurseRepository = nurseRepository;
    }

    @GetMapping("/nurse_getAll")
    public ResponseEntity<List<NurseDto>> get() {
        List<NurseDto> getAll = nurseService.getAllNurse();
        return ResponseEntity.status(HttpStatus.OK).body(getAll);
    }

    @PersistenceContext
    EntityManager entityManager;

    @GetMapping("/nurseOne")
    public ResponseEntity<List<Nurse>> nurseOne(String name, Integer number) {
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        QNurse qNurse = QNurse.nurse;

        List<Nurse> nurseList = jpaQueryFactory
                .select(qNurse)
                .from(qNurse)
                .where(qNurse.nurseName.eq(name), qNurse.nurseNumber.eq(number))
                .orderBy(qNurse.nurseNumber.asc())
                .fetch();

        return ResponseEntity.status(HttpStatus.OK).body(nurseList);
    }

    @PostMapping("/nursePost")
    public String saveMany() {
        //의사 데이터 저장 (DB 에서만 가능하게)
        Integer[] nurseNumber = {100021,100089,100211,100302,100309,100356,100605,100804,101018,104145};
        String[] nurseName = {"윤성애","신지원","이서연","김은영","박성완","이선용","유정화","라하나","김화경","김현"};
        String[] nurseTel = {"016-333-8745","010-666-7643","010-222-3214","010-555-8751","010-777-4996","010-777-1234","010-333-4588","010-222-1340","019-888-4116","010-999-8520"};
        String[] nurseFunction = {"소아과","내과","외과","피부과","피부과","소아과","방사선과","내과","소아과","외과"};

        for (int i = 0; i < nurseNumber.length; i++){
            Nurse nurse = new Nurse();
            nurse.setNurseNumber(nurseNumber[i]);
            nurse.setNurseName(nurseName[i]);
            nurse.setTel(nurseTel[i]);
            nurse.setFunctions(nurseFunction[i]);
            nurseRepository.save(nurse);
        }
        return "간호사 데이터 저장";
    }

    //  thymeleaf 간호사 데이터 가져오기
    @GetMapping("/nurses")
    public ResponseEntity<List<NurseDto>> getDoctors(Model model) {
        List<NurseDto> nurses = nurseService.getAllNurse();
        model.addAttribute("nurses", nurses);
        return ResponseEntity.status(HttpStatus.OK).body(nurses);
    }
}

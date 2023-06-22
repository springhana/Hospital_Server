package com.hospital.hospital.controller;

import com.hospital.hospital.data.entity.*;
import com.hospital.hospital.data.repository.*;
import com.hospital.hospital.service.PatientService;
import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/sign")
@MultipartConfig(maxFileSize = 1024 * 1024 * 2, maxRequestSize = 1024 * 1024 * 10)
@CrossOrigin(origins = "*") // 집에 가면 ip주소 바꿔야함
public class SignUpController {

    Doctor doctor;
    Nurse nurse;
    Patient patient1;

    Diagnosis diagnosis1;
    private final ChartRepository chartRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final NurseRepository nurseRepository;
    private final DiagnosisRepository diagnosisRepository;

    @Autowired
    PatientService patientService;

    public SignUpController(ChartRepository chartRepository, PatientRepository patientRepository, DoctorRepository doctorRepository, NurseRepository nurseRepository, DiagnosisRepository diagnosisRepository) {
        this.chartRepository = chartRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.nurseRepository = nurseRepository;
        this.diagnosisRepository = diagnosisRepository;
    }

    @PostMapping("/PatientSave")
    public ResponseEntity<List<Patient>> PatientSave(@RequestBody Patient patient, @RequestParam Integer nurseID, Integer doctorID) {
//    public ResponseEntity<List<Patient>> PatientSave(@RequestBody Patient patient, @RequestParam("image") MultipartFile filename, Integer nurseID, Integer doctorID) {

        List<Doctor> DoctorList = doctorRepository.findByName(doctorID);
        doctor = null;
        if (!DoctorList.isEmpty()) {
            doctor = DoctorList.get(0);
        }

        List<Nurse> NurseList = nurseRepository.findByName(nurseID);
        nurse = null;
        if (!NurseList.isEmpty()) {
            nurse = NurseList.get(0);
        }

        patient1 = new Patient();
        patient1.setPatientNum(patient.getPatientNum());
        patient1.setPatientName(patient.getPatientName());
        patient1.setTel(patient.getTel());
        patient1.setImage(patient.getImage());
        patient1.setDoctor(doctor);
        patient1.setNurse(nurse);
        patientRepository.save(patient1);

        ArrayList<Patient> patientList = new ArrayList<>();
        patientList.add(patient1);

        return ResponseEntity.status(HttpStatus.OK).body(patientList);
    }

    @PostMapping("/DiagnosisSave")
    public ResponseEntity<List<Diagnosis>> DiagnosisSave(@RequestBody Diagnosis diagnosis) {

        Date date = new Date();

        diagnosis1 = new Diagnosis();
        diagnosis1.setDiagnosisNum(diagnosis.getDiagnosisNum());
        diagnosis1.setDiagnosisContent(diagnosis.getDiagnosisContent());
        diagnosis1.setDiagnosisDate(date);
        diagnosis1.setDoctor(doctor);
        diagnosis1.setPatient(patient1);
        diagnosisRepository.save(diagnosis1);

        ArrayList<Diagnosis> DiagnosisList = new ArrayList<>();
        DiagnosisList.add(diagnosis1);

        return ResponseEntity.status(HttpStatus.OK).body(DiagnosisList);
    }

    @PostMapping("/ChartSave")
    public ResponseEntity<List<Chart>> ChartSave(@RequestBody Chart chart) {

        Chart chart1 = new Chart();
        chart1.setChartNum(chart.getChartNum());
        chart1.setChartContent(chart.getChartContent());
        chart1.setDiagnosis(diagnosis1);
        chart1.setNurse(nurse);
        chartRepository.save(chart1);

        ArrayList<Chart> ChartList = new ArrayList<>();
        ChartList.add(chart1);

        return ResponseEntity.status(HttpStatus.OK).body(ChartList);
    }

    @PostMapping("/image")
    public String JoinOneImage(@RequestParam("filename") MultipartFile filename) {
        String uuid = "";
        if (filename != null) {
            uuid = patientService.joinOneImage(filename);
        } else {
            // filename이 존재하지 않는 경우에 대한 처리
            // 예: 에러 메시지 반환 또는 기본값 반환
            uuid = "ERROR";
        }

        return uuid;
    }

}

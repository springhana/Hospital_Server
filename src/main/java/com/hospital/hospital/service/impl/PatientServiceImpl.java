package com.hospital.hospital.service.impl;

import com.hospital.hospital.data.dao.PatientDAO;
import com.hospital.hospital.data.entity.Patient;
import com.hospital.hospital.data.entity.dto.PatientDto;
import com.hospital.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PatientServiceImpl implements PatientService {

    @Value("${uploadPath}")
    private String UPLOAD_LOCATION; // C:/Images

    private final PatientDAO patientDAO;


//    private final PatientRepository patientRepository;

    //    public PatientServiceImpl(PatientDAO patientDAO, PatientRepository patientRepository) {
    public PatientServiceImpl(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
//        this.patientRepository = patientRepository;
    }

    @Override
    public List<PatientDto> getAllPatient() {
        List<Patient> lists = patientDAO.getAllPatient();
        List<PatientDto> listsDto = new ArrayList<>();
        for (Patient p : lists
        ) {
            PatientDto dto = new PatientDto();
            dto.setPatientNum(p.getPatientNum());
            dto.setPatientName(p.getPatientName());
            dto.setTel(p.getTel());
            dto.setDoctor(p.getDoctor());
            dto.setNurse(p.getNurse());
            listsDto.add(dto);
        }

        return listsDto;
    }

    @Override
    public String joinOneImage(MultipartFile filename) {
        // file 저장 => C:/Users/xksxk/OneDrive/바탕 화면/학교/3학년/3학년1학기/Spring boot/images
        System.out.println("filename: " + filename);
        String uuidFile = fileOneSave(filename); // 책이미지 저장
        return uuidFile;
    }

    public String fileOneSave(MultipartFile file) {
        String uuidFile = null;
        String fileName = file.getOriginalFilename();

        String fileExt = fileName.substring(fileName.lastIndexOf("."));
//        log.info("UPLOAD_LOCATION : {}", UPLOAD_LOCATION); // C:/Images
//        log.info("파일 이름 : {}", fileName);
//        log.info("파일 확장자 : {}", fileExt); // .jpg 등
//        log.info("파일 크기 : {}", file.getSize());
        uuidFile = UUID.randomUUID().toString().replaceAll("-", "") + fileExt; // dcacbbcad6d84168a145b5caac334766.jpg
//        log.info("UUID 파일명 : {}", uuidFile);
        String uploadFile = UPLOAD_LOCATION + "/" + uuidFile; // C:/Images/dcacbbcad6d84168a145b5caac334766.jpg
        System.out.println("file : " + uploadFile);

//        log.info("업로드 파일 : {}", uploadFile);
        try {
            if (file.isEmpty()) {
                throw new IOException("common.file.empty"); // 빈 파일입니다.
            }

            InputStream src = file.getInputStream();
            Path dest = Paths.get(uploadFile);
//            log.info("src : {}", src);
//            log.info("dest : {}", dest);
            Files.copy(src, dest, StandardCopyOption.REPLACE_EXISTING); // java.nio.file.* 필요
        } catch (IOException e) {
            throw new RuntimeException("fileOne Save Error" + e.getMessage());
        }
        return uuidFile;
    }
}

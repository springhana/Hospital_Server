package com.hospital.hospital.controller.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hospital")
@CrossOrigin(origins = "*")
public class HospitalController {

    @GetMapping("")
    public String index() {
        return "index"; // thymeleaf/index.html
    }

    @GetMapping("/diagnosis")
    public String loginForm() { // 로그인 폼 보내줌
        return "signPatient";
    }

    @GetMapping("/userLogin")
    public String userLogin() { // 로그인 폼 보내줌
        return "userLogin";
    }


    @GetMapping("/doctorLogin")
    public String doctorLogin() { // 로그인 폼 보내줌
        return "doctorLogin";
    }

    @GetMapping("/nurseLogin")
    public String nurseLogin() { // 로그인 폼 보내줌
        return "nurseLogin";
    }


    @GetMapping("/dir_chr")
    public String dir_chr() {
        return "signDia_Chr"; // thymeleaf/index.html
    }


}

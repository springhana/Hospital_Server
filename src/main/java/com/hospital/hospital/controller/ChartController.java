package com.hospital.hospital.controller;

import com.hospital.hospital.data.entity.Chart;
import com.hospital.hospital.data.entity.QChart;
import com.hospital.hospital.data.entity.dto.ChartDto;
import com.hospital.hospital.service.ChartService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chart")
//@CrossOrigin(origins = "http://192.168.68.51:8080") // 집에 가면 ip주소 바꿔야함
@CrossOrigin(origins = "*") // 집에 가면 ip주소 바꿔야함
public class ChartController {

    private final ChartService chartService;

//    @Autowired
//    ChartRepository chartRepository;

    public ChartController(ChartService chartService) {
        this.chartService = chartService;
    }

    @GetMapping("/chart_getAll")
    public ResponseEntity<List<ChartDto>> get() {
        List<ChartDto> getAll = chartService.getAllChart();
        return ResponseEntity.status(HttpStatus.OK).body(getAll);
    }

    @PersistenceContext
    EntityManager entityManager;

    @GetMapping("/chartOne")
    public ResponseEntity<List<Chart>> chartOne(Integer number) {
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        QChart qChart = QChart.chart;

        List<Chart> chartList = jpaQueryFactory
                .select(qChart)
                .from(qChart)
                .where(qChart.nurse.nurseNumber.eq(number))
                .orderBy(qChart.chartNum.asc())
                .fetch();

        return ResponseEntity.status(HttpStatus.OK).body(chartList);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteDiagnosis(Integer number) throws Exception {
        chartService.deleteProduct(number);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }
}

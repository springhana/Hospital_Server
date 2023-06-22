package com.hospital.hospital.service.impl;

import com.hospital.hospital.data.dao.ChartDAO;
import com.hospital.hospital.data.entity.Chart;
import com.hospital.hospital.data.entity.dto.ChartDto;
import com.hospital.hospital.service.ChartService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChartServiceImpl implements ChartService {

    private final ChartDAO chartDAO;

    public ChartServiceImpl(ChartDAO chartDAO) {
        this.chartDAO = chartDAO;
    }

    @Override
    public List<ChartDto> getAllChart() {
        List<Chart> lists = chartDAO.getAllChart();
        List<ChartDto> listsDto = new ArrayList<>();
        for (Chart p : lists
        ) {
            ChartDto dto = new ChartDto();
            dto.setChartNum(p.getChartNum());
            dto.setChartContent(p.getChartContent());
            dto.setDiagnosis(p.getDiagnosis());
            dto.setNurse(p.getNurse());
            listsDto.add(dto);
        }
        return listsDto;
    }

    @Override
    public void deleteProduct(Integer number) throws Exception {
        chartDAO.deleteProduct(number);
    }
}

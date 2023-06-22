package com.hospital.hospital.service;

import com.hospital.hospital.data.entity.dto.ChartDto;

import java.util.List;

public interface ChartService {
    List<ChartDto> getAllChart();

    void deleteProduct(Integer number) throws Exception;
}

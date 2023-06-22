package com.hospital.hospital.data.dao;

import com.hospital.hospital.data.entity.Chart;

import java.util.List;

public interface ChartDAO {
    List<Chart> getAllChart();

    void deleteProduct(Integer number) throws Exception;
}

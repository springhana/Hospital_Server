package com.hospital.hospital.data.dao.impl;

import com.hospital.hospital.data.dao.ChartDAO;
import com.hospital.hospital.data.entity.Chart;
import com.hospital.hospital.data.repository.ChartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ChartDAOImpl implements ChartDAO {

    private ChartRepository chartRepository;

    @Autowired
    public ChartDAOImpl(ChartRepository chartRepository) {
        this.chartRepository = chartRepository;
    }

    @Override
    public List<Chart> getAllChart() {
        List<Chart> lists = chartRepository.findAll();
        return lists;
    }

    @Override
    public void deleteProduct(Integer number) throws Exception {
        System.out.println("number: "  + number);
        Optional<Chart> selected = chartRepository.findChartByDiagnosisNum(number);

        if (selected.isPresent()) {
            Chart chart = selected.get();

            chartRepository.delete(chart);
        } else {
            throw new Exception();
        }
    }
}

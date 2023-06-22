package com.hospital.hospital.data.repository;

import com.hospital.hospital.data.entity.Chart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ChartRepository extends JpaRepository<Chart, Integer> {

    @Query("SELECT c FROM Chart c JOIN c.diagnosis d WHERE d.diagnosisNum = :diagnosisNum")
    Optional<Chart> findChartByDiagnosisNum(@Param("diagnosisNum") Integer diagnosisNum);
}

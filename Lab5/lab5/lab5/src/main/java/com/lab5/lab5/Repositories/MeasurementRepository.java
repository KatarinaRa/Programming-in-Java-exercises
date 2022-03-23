package com.lab5.lab5.Repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lab5.lab5.Models.Measurements;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurements, String>{
	
	public default Measurements add(Measurements m) {
		m.setId(m.getId());
		m.setYear(m.getYear());
		m.setMonth(m.getMonth());
		m.setResult(m.getResult());
		return m;
	}
	
	@Query("SELECT SUM(m.result) FROM Measurements m WHERE m.year = :year")
	public double getAllYearMeasurements(@Param("year") String year);
	
	@Query("SELECT SUM(m.result) FROM Measurements m WHERE m.year = :year AND m.month = :month")
	public double getMeasurementsByMonths(@Param("year") String year, @Param("month") String month);
	
	@Query("SELECT SUM(m.result) FROM Measurements m  WHERE m.year = :year GROUP BY month")
	public List<String> getYearMeasurementsByMonths(@Param("year") String year);
}

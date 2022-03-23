package com.lab5.lab5.Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lab5.lab5.Models.Measurements;
import com.lab5.lab5.Repositories.MeasurementRepository;

@Service
public class MeasurementService {
	@Autowired
	private MeasurementRepository repository;

	public Measurements createMeasurement(Measurements m) {
		repository.add(m);
		return repository.save(m);
		
	}

	public List<Measurements> getMeasurement() {
		return repository.findAll();
	}
	

	public void deleteMeasurement(String id) {
		repository.deleteById(id);
	}

	public Measurements updateMeasurement(String id, Measurements details) {
		Measurements m = repository.findById(id).get();
		m.setResult(m.getResult());
		m.setYear(m.getYear());
		m.setMonth(m.getMonth());
		m.setDevice(m.getDevice());
		return repository.save(m);
	}
	
	public double getAllYearMeasurements(String year) {
		double count = repository.getAllYearMeasurements(year);
		return count;

	}
	
	public List<String> getYearMeasurementsByMonths(String year) {
		List<String> list = repository.getYearMeasurementsByMonths(year);
		return list;
		
	}
	
	public double getMeasurementsByMonths(String year,String month)
	{
		double count = repository.getMeasurementsByMonths(year,month);
		return count;
	}

}

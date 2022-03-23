package com.lab5.lab5.Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lab5.lab5.Models.Client;
import com.lab5.lab5.Models.Measurements;
import com.lab5.lab5.Services.ClientService;
import com.lab5.lab5.Services.MeasurementService;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

@RestController
public class MeasurementController {
	@Autowired
	private MeasurementService service;

	@PostMapping("/measurements")
	public ResponseEntity<Measurements> createMeasurement(@RequestBody Measurements m) {
		if(m == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<>(service.createMeasurement(m),HttpStatus.OK);
	}

	@GetMapping("/measurements")
	public ResponseEntity<List<Measurements>> getMeasurement() {
		return new ResponseEntity(service.getMeasurement(),HttpStatus.OK);
	}

	@PutMapping("/measurements/{Id}")
	public ResponseEntity<Measurements> updateMeasurement(@PathVariable(value = "Id") String id, @RequestBody Measurements details) {
		if( details == null || id == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<>(service.updateMeasurement(id, details), HttpStatus.OK);
	}

	@DeleteMapping("/measurements/{Id}")
	public ResponseEntity<Measurements> deleteMeasurement(@PathVariable(value = "Id") String id) {
		if(id == null)
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		else
		{
			service.deleteMeasurement(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	
	@GetMapping("/results")
	public String getAllYearMeasurements(@QueryParam("year") String year) { 

		double zbroj = service.getAllYearMeasurements(year);
		return "godina: " + year + " ukupna potrošnja " + zbroj;
	}

	@GetMapping("/yearMeasurments")
	public List<String> geYearMeasurementsByMonths(@QueryParam("year") String year) {
		List<String> list = service.getYearMeasurementsByMonths(year);
		return list;
	}

	@GetMapping("/measurmentsByMonth")
	public String getMeasurementsByMonths(@QueryParam("year") String year, @QueryParam("month") String month) {
		double zbroj = service.getMeasurementsByMonths(year, month);
		return "godina: " + year + " mjesec: " + month + " ukupna potrosnja " + zbroj;
	}
}

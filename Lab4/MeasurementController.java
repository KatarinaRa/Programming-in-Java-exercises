package vjezba4.demo.Controllers;

import java.util.List;

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

import vjezba4.demo.Models.Client;
import vjezba4.demo.Models.Measurements;
import vjezba4.demo.Services.ClientService;
import vjezba4.demo.Services.MeasurementService;

@RestController
public class MeasurementController {
	@Autowired
	private MeasurementService service;

	@PostMapping("/measurments")
	public ResponseEntity<Measurements> createMeasurement(@RequestBody Measurements m) {
		if( m == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<>(service.createMeasurement(m),HttpStatus.OK);
	}

	@GetMapping("/measurments")
	public ResponseEntity<List<Measurements>> getMeasurement() {
		return new ResponseEntity<>(service.getMeasurement(),HttpStatus.OK);
	}

	@PutMapping("/measurments/{Id}")
	public ResponseEntity<Measurements>updateMeasurement(@PathVariable(value = "Id") String id, @RequestBody Measurements details) {
		if (details == null || id == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<>(service.updateMeasurement(id, details),HttpStatus.OK);
	}

	@DeleteMapping("/measurments/{Id}")
	public ResponseEntity<Measurements> deleteMeasurement(@PathVariable(value = "Id") String id) {
		if ( id == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		else {
			service.deleteMeasurement(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}

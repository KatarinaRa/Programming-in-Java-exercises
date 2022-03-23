package vjezba4.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vjezba4.demo.Models.Measurements;
import vjezba4.demo.Repositories.ClientRepository;
import vjezba4.demo.Repositories.MeasurementRepository;

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
}

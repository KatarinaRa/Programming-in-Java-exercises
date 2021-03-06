package vjezba4.demo.Services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vjezba4.demo.Models.Client;
import vjezba4.demo.Models.Device;
import vjezba4.demo.Repositories.ClientRepository;
import vjezba4.demo.Repositories.DeviceRepository;

@Service
public class DeviceService {
	@Autowired
    private DeviceRepository repository;  

	public Device createDevice(Device c) {
	    return repository.save(c);
	}
	

	public List<Device> getDevices() {
	    return repository.findAll();
	}

	public void deleteDevice(String id) {
	    repository.deleteById(id);
	}
	
	public Device updateDevice(String id, Device details) {
		Device d = repository.findById(id).get(); 
		d.setClient(d.getClient());
		d.setMeasurments(d.getMeasurments());
        return repository.save(d);                                
}
}

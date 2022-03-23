package vjezba4.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vjezba4.demo.Models.Address;
import vjezba4.demo.Models.Device;
import vjezba4.demo.Repositories.AddressRepository;
import vjezba4.demo.Repositories.DeviceRepository;

@Service
public class AddressService {
	@Autowired
	private AddressRepository repository;  

	public Address createAddress(Address c) {
	    return repository.save(c);
	}

	public List<Address> getAddress() {
	    return repository.findAll();
	}

	public void deleteAddress(String id) {
	    repository.deleteById(id);
	}
	
	public Address updateAddress(String id, Address details) {
		Address a = repository.findById(id).get();
        a.setCity(details.getCity());
        a.setNumber(details.getNumber());
        a.setStreet(details.getStreet());
        return repository.save(a);                                
}
}

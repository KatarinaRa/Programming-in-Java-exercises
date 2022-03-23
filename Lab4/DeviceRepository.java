package vjezba4.demo.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import vjezba4.demo.Models.Address;
import vjezba4.demo.Models.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, String> {

}

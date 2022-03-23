package com.lab5.lab5.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lab5.lab5.Models.Device;
@Repository
public interface DeviceRepository extends JpaRepository<Device, String> {

}

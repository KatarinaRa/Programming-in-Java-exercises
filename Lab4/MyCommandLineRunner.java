package vjezba4.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import vjezba4.demo.Models.Address;
import vjezba4.demo.Models.Client;
import vjezba4.demo.Models.Device;
import vjezba4.demo.Models.Measurements;
import vjezba4.demo.Repositories.ClientRepository;
import vjezba4.demo.Repositories.DeviceRepository;

@Component
public class MyCommandLineRunner implements CommandLineRunner{

    private static final Logger logger = LoggerFactory.getLogger(MyCommandLineRunner.class);

    @Autowired
    private ClientRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Client("1", "Katarina", "Ramljak", new Address("1","Split","Gotovceva","11"), new Device("1")));
        repository.save(new Client("2", "Pero", "Peric", new Address("2","Zagreb","Busiceva","11"), new Device("2")));
    }
}

package com.osm.avions;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.osm.avions.entities.avion;
import com.osm.avions.service.AvionService;


@SpringBootApplication
public class AvionsApplication implements CommandLineRunner {

    @Autowired
    AvionService avionService;

    public static void main(String[] args) {
        SpringApplication.run(AvionsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    	avionService.saveAvion(new avion("Boeing 747", 15000, 400, new Date()));
    	avionService.saveAvion(new avion("Airbus A320", 12000, 200, new Date()));
    	avionService.saveAvion(new avion("Cessna 172", 1200, 4, new Date()));
    }
}
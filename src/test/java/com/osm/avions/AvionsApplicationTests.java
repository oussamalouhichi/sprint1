package com.osm.avions;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.osm.avions.entities.avion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.osm.avions.repos.avionRepository;
import com.osm.avions.service.AvionService;


@SpringBootTest
class AvionsApplicationTests { 

    @Autowired
    private avionRepository avionRepository;
    @Autowired
    private AvionService AvionService ; 

    @Test
    public void testCreateAvion() {
        avion avion = new avion("Boeing 747", 660, 13800.0, new Date());
        avionRepository.save(avion);
    }
    @Test
    public void testFindAvion() {
        avion a = avionRepository.findById(1L).get();     
        System.out.println(a);
    }

    @Test
    public void testUpdateAvion() {
        avion a = avionRepository.findById(1L).get();
        a.setModele("Airbus A350");
        avionRepository.save(a);
    }

    @Test
    public void testDeleteAvion() {
        avionRepository.deleteById(1L);
    }

    @Test
    public void testListerTousAvions() {
        List<avion> avions = avionRepository.findAll();   
        for (avion a : avions) {
            System.out.println(a);
        }
    }
    @Test
    public void testFindByNomAvionContains() 
    { 
        Page<avion> avions = AvionService.getAllAvionsParPage(0, 2); 
        System.out.println(avions.getSize()); 
        System.out.println(avions.getTotalElements()); 
        System.out.println(avions.getTotalPages()); 

        avions.getContent().forEach(a -> { 
            System.out.println(a.toString()); 
        });  

        /* ou bien 
        for (Avion a : avions) 
        { 
            System.out.println(a); 
        } 
        */
    }
}
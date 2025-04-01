package com.osm.avions.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.osm.avions.entities.avion;
import com.osm.avions.repos.avionRepository;

@Service
public class AvionServiceImpl implements AvionService {

    @Autowired
    avionRepository avionRepository;

    @Override
    public avion saveAvion(avion a) {
        return avionRepository.save(a);
    }

    @Override
    public avion updateAvion(avion a) {
        return avionRepository.save(a);
    }

    @Override
    public void deleteAvion(avion a) {
        avionRepository.delete(a);
    }

    @Override
    public void deleteAvionById(Long id) {
        avionRepository.deleteById(id);
    }

    @Override
    public avion getAvion(Long id) {
        return avionRepository.findById(id).get();
    }

    @Override
    public List<avion> getAllAvions() {
        return avionRepository.findAll();
    }
    @Override
    public Page<avion> getAllAvionsParPage(int page, int size) {
        return avionRepository.findAll(PageRequest.of(page, size));
    }
}

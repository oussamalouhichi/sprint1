package com.osm.avions.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.osm.avions.entities.avion;

public interface AvionService {
    avion saveAvion(avion a);
    avion updateAvion(avion a);
    void deleteAvion(avion a);
    void deleteAvionById(Long id);
    avion getAvion(Long id);
    List<avion> getAllAvions();
    Page<avion> getAllAvionsParPage(int page, int size);
}
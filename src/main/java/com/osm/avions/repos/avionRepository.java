package com.osm.avions.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.osm.avions.entities.*;

public interface avionRepository extends JpaRepository<avion, Long> {

}

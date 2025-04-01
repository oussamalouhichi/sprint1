package com.osm.avions.entities;

import java.util.Date; 
import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.GenerationType; 
import jakarta.persistence.Id; 

@Entity 
public class avion { 
  
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long idAvion; 
    private String modele; 
    private int capacite; 
    private double autonomie;  
    private Date dateFabrication; 
 
    public avion() { 
        super(); 
    } 
 
    public avion(String modele, int capacite, double autonomie, Date dateFabrication) { 
        super(); 
        this.modele = modele; 
        this.capacite = capacite; 
        this.autonomie = autonomie; 
        this.dateFabrication = dateFabrication; 
    } 

    public Long getIdAvion() { 
        return idAvion; 
    } 

    public void setIdAvion(Long idAvion) { 
        this.idAvion = idAvion; 
    } 

    public String getModele() { 
        return modele; 
    } 

    public void setModele(String modele) { 
        this.modele = modele; 
    } 

    public int getCapacite() { 
        return capacite; 
    } 

    public void setCapacite(int capacite) { 
        this.capacite = capacite; 
    } 

    public double getAutonomie() { 
        return autonomie; 
    } 

    public void setAutonomie(double autonomie) { 
        this.autonomie = autonomie; 
    } 

    public Date getDateFabrication() { 
        return dateFabrication; 
    } 

    public void setDateFabrication(Date dateFabrication) { 
        this.dateFabrication = dateFabrication; 
    } 

    @Override 
    public String toString() { 
        return "Avion [idAvion=" + idAvion + ", modele=" + modele + 
               ", capacite=" + capacite + ", autonomie=" + autonomie + 
               ", dateFabrication=" + dateFabrication + "]"; 
    } 
}
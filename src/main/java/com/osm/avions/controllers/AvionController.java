package com.osm.avions.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.osm.avions.entities.avion;
import com.osm.avions.service.AvionService;

@Controller
public class AvionController {
    @Autowired
    AvionService avionService;

    @GetMapping("/listeAvions") 
    public String listeAvions(ModelMap modelMap, 
        @RequestParam(name = "page", defaultValue = "0") int page, 
        @RequestParam(name = "size", defaultValue = "2") int size) 
    { 
        Page<avion> avions = avionService.getAllAvionsParPage(page, size); 
        modelMap.addAttribute("avions", avions); 
        modelMap.addAttribute("pages", new int[avions.getTotalPages()]);  
        modelMap.addAttribute("currentPage", page);    
        return "listeAvions";  
    }

    @GetMapping("/showCreate")
    public String showCreate() {
        return "createAvion";
    }

    @GetMapping("/saveAvion")
    public String saveAvion(@ModelAttribute("avion") avion avion,
                            @RequestParam("date") String date,
                            ModelMap modelMap) throws ParseException {
        // Convert date
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateformat.parse(String.valueOf(date));
        avion.setDateFabrication(dateCreation);

        avion savedAvion = avionService.saveAvion(avion);
        String msg = "Avion enregistré avec Id " + savedAvion.getIdAvion();
        modelMap.addAttribute("msg", msg);
        return "createAvion";
    }

    @GetMapping("/supprimerAvion")
    public String supprimerAvion(@RequestParam("id") Long id, 
                                 ModelMap modelMap, 
                                 @RequestParam(name = "page", defaultValue = "0") int page, 
                                 @RequestParam(name = "size", defaultValue = "2") int size) {
        avionService.deleteAvionById(id);
        Page<avion> avions = avionService.getAllAvionsParPage(page, size);
        modelMap.addAttribute("avions", avions);
        modelMap.addAttribute("pages", new int[avions.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        
        return "listeAvions";
    }
    @GetMapping("/modifierAvion")
    public String editerAvion(@RequestParam("id") Long id,
                              ModelMap modelMap) {
        avion a = avionService.getAvion(id);
        modelMap.addAttribute("avion", a);
        return "editerAvion";
    }

    @GetMapping("/updateAvion")
    public String updateAvion(@ModelAttribute("avion") avion avion,
                              @RequestParam("date") String date,
                              ModelMap modelMap) throws ParseException {
        // Convert date
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateformat.parse(String.valueOf(date));
        avion.setDateFabrication(dateCreation);

        avionService.updateAvion(avion);
        List<avion> avions = avionService.getAllAvions();
        modelMap.addAttribute("avions", avions);
        return "listeAvions";
    }
}

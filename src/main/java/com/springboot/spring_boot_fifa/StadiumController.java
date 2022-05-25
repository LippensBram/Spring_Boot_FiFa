package com.springboot.spring_boot_fifa;

import domain.Stadium;
import domain.Wedstrijd;
import domain.WedstrijdTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.VoetbalService;

import java.util.List;

@Controller
@RequestMapping("/stadium")
public class StadiumController {
    @Autowired
    private VoetbalService voetbalService;

    @ModelAttribute("stadiumList")
    public List<Stadium> populateStadiums(){
        return voetbalService.getStadiumList();
    }
    @GetMapping
    public String showForm(){
        return "stadium/stadiumOverzicht";
    }
    @PostMapping
    public String onSubmit(Model model) {
        Stadium stadium = voetbalService.getStadiumList().get(1);
        List<WedstrijdTicket> wedstrijdList = voetbalService.getWedstrijdenByStadium(stadium);
        Wedstrijd wedstrijd = wedstrijdList.get(0).getWedstrijd();
        model.addAttribute("wedstrijdenLijst", wedstrijdList);
//        model.addAttribute("test", wedstrijd);
        model.addAttribute("stadium", stadium);
        return "stadium/wedstrijdenForm";
    }
}

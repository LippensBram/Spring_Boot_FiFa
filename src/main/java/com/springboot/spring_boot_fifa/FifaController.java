package com.springboot.spring_boot_fifa;

import java.util.ArrayList;
import java.util.List;

import domain.Wedstrijd;
import domain.WedstrijdTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import domain.Stadium;
import service.VoetbalServiceImpl;

@Controller
@RequestMapping("/fifa")
public class FifaController {

    private List<String> stadiumList = new ArrayList<>();

    @Autowired
    private VoetbalServiceImpl serviceImpl;

    //Init
    @GetMapping
    public String showHomePage(Model model) {
        stadiumList = serviceImpl.getStadiumList();
        model.addAttribute("stadiumList",stadiumList);
        return "fifa/listStadiums";
    }
    //after you choose a stadium
    @PostMapping
    public String onSubmit(@ModelAttribute String selectedStadium, Model model) {
        Stadium currentStadium = new Stadium(selectedStadium);
        serviceImpl.getWedstrijdenByStadium(selectedStadium);
        model.addAttribute("wedstrijden",serviceImpl.getWedstrijdenByStadium(selectedStadium));
        model.addAttribute("stadium", currentStadium);
        return "fifa/wedstrijdenOverzicht";
    }
    //after you choose which match you want to book
    @GetMapping(value = "/{id}")
    public String show(@PathVariable String id, Model model){
        WedstrijdTicket wedstrijdTicket = serviceImpl.getWedstrijd(id);
        if (wedstrijdTicket == null){
            return "redirect:/wedstrijden/list";
        }
        model.addAttribute("wedstrijd", wedstrijdTicket);
        return "fifa/koopForm";
    }
}

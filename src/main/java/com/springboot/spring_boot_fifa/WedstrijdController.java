package com.springboot.spring_boot_fifa;

import Utility.Message;
import domain.AankoopTicket;
import domain.Stadium;
import domain.WedstrijdTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import service.VoetbalService;
import service.VoetbalServiceImpl;
import validator.AankoopTicketValidation;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/fifa")
@SessionAttributes("aantalTickets")
public class WedstrijdController {
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private VoetbalService voetbalService;
    @Autowired
    private AankoopTicketValidation aankoopTicketValidation;
    @ModelAttribute("stadiumList")
    public List<WedstrijdTicket> wedstrijden(){
        return voetbalService.getWedstrijdenByStadium(voetbalService.getStadiumList().get(1));
    }

    @GetMapping("/list")
    public String listWedstrijden(Model model){
        model.addAttribute("wedstrijdenList", wedstrijden());
        return "fifa/list";
    }
    @GetMapping("/buy/{id}")
    public String bestelForm(@PathVariable String id, Model model){
        WedstrijdTicket wedstrijdTicket = voetbalService.getWedstrijd(id);
        AankoopTicket aankoopTicket = new AankoopTicket();
        aankoopTicket.setVoetbalCode1(10);
        aankoopTicket.setVoetbalCode2(20);
        aankoopTicket.setAantalTickets(1);
        if(wedstrijdTicket == null|| wedstrijdTicket.uitverkocht()) return "redirect:/fifa/list";
        model.addAttribute("aankoopTicket",aankoopTicket);
        model.addAttribute("wedstrijdTicket",wedstrijdTicket);
        return "fifa/koop";
    }
    @PostMapping(value = "/buy/{id}")
    public String buy(@PathVariable String id,@Valid AankoopTicket aankoopTicket, BindingResult result, Model model, Locale locale){
        aankoopTicketValidation.validate(aankoopTicket,result);
        if(result.hasErrors()){
            model.addAttribute("message", new Message("error", messageSource.getMessage("contact_save_fail", new Object[]{}, locale)));
            model.addAttribute("wedstrijdTicket",voetbalService.getWedstrijd(id));
            return "fifa/koop";
        }
        voetbalService.getWedstrijd(id).ticketsKopen(aankoopTicket.getAantalTickets());
        model.addAttribute("aantalTickets", aankoopTicket.getAantalTickets());
        return "redirect:/fifa/list/";
    }
//    @PostMapping("/{id}")
//    public String onSubmit(@Valid AankoopTicket aankoopTicket, BindingResult result, Model model){
//        aankoopTicketValidation.validate(aankoopTicket,result);
//        if(result.hasErrors()) return "wedstrijd/koopForm";
//        System.out.println(matchId);
//        System.out.println(voetbalService.ticketsBestellen(matchId, aankoopTicket.getAantalTickets()));
//        return "redirect:/";
//    }
}

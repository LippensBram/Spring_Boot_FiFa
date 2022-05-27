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
import service.StadiumDao;
import service.VoetbalService;
import service.WedstrijdTicketDao;
import validator.AankoopTicketValidation;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/fifa")
@SessionAttributes({"aantalTickets", "uitverkocht", "aantalGekocht"})

public class FifaController {
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private VoetbalService voetbalService;
    @Autowired
    private AankoopTicketValidation aankoopTicketValidation;


    @GetMapping("/stadium")
    public String listStadium(Model model){
        model.addAttribute("stadiumList",voetbalService.getStadiumList());
//        model.addAttribute("stadiumList",stadiumDao.findAll());
        model.addAttribute("stadium", new Stadium());
        Integer aantal = (Integer) model.getAttribute("aantalTickets");
        if(aantal != null)
            System.out.println(model.getAttribute("aantalTickets").getClass());
        return "fifa/stadiumList";
    }
    @RequestMapping(value = "/stadium")
    public String onSubmit(@ModelAttribute("stadium") Stadium stadium, Model model){
        System.out.println(stadium.toString());
        model.addAttribute("wedstrijdenList", voetbalService.getWedstrijdenByStadium(stadium));
//        model.addAttribute("wedstrijdenList", wedstrijdTicketDao. )
        return "fifa/list";
    }

    @GetMapping("/buy/{id}")
    public String bestelForm(@PathVariable String id, Model model){
        WedstrijdTicket wedstrijdTicket = voetbalService.getWedstrijd(Long.parseLong(id));
        AankoopTicket aankoopTicket = new AankoopTicket();
        model.addAttribute("uitverkocht",false);

        if(wedstrijdTicket == null|| wedstrijdTicket.uitverkocht()) {
            model.addAttribute("uitverkocht",true);
            return "redirect:/fifa/stadium";
        }

        model.addAttribute("aankoopTicket",aankoopTicket);
        model.addAttribute("wedstrijdTicket",wedstrijdTicket);
        return "fifa/koop";
    }
    @PostMapping(value = "/buy/{id}")
    public String buy(@PathVariable String id,@Valid AankoopTicket aankoopTicket, BindingResult result, Model model, Locale locale){
//        WedstrijdTicket wedstrijdTicket = voetbalService.getWedstrijd(Long.parseLong(id));
        aankoopTicketValidation.validate(aankoopTicket,result);
        if(result.hasErrors()){
            model.addAttribute("message", new Message("error", messageSource.getMessage("contact_save_fail", new Object[]{}, locale)));
//            model.addAttribute("wedstrijdTicket",wedstrijdTicket);
            return "fifa/koop";
        }
        int aantalGekocht = voetbalService.ticketsBestellen(Long.parseLong(id),aankoopTicket.getAantalTickets());
        model.addAttribute("aantalTickets", aantalGekocht);
        return "redirect:/fifa/stadium";
    }
}

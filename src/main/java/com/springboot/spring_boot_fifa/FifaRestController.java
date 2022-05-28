package com.springboot.spring_boot_fifa;

import domain.Wedstrijd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.VoetbalService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/rest")
public class FifaRestController {
    @Autowired
    private VoetbalService voetbalService;

    @GetMapping(value = "fifaDetail/{id}")
    public List<String> getWedstrijdDetail(@PathVariable("id") Integer id){
        return Arrays.stream(voetbalService.getWedstrijd(id.longValue()).getWedstrijd().getLanden()).toList();
    }
}

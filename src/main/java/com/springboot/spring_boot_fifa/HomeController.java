package com.springboot.spring_boot_fifa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String showHomePage() {return "redirect:/fifa/list";}


}

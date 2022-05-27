package com.springboot.spring_boot_fifa;

import domain.PopulateDatabase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import service.*;
import validator.AankoopTicketValidation;

@SpringBootApplication
@EnableTransactionManagement
public class SpringBootFiFaApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootFiFaApplication.class, args);
    }
    @Bean
    public VoetbalServiceImpl voetbalServiceImpl() {
        return new VoetbalServiceImpl();
    }
    @Bean
    public AankoopTicketValidation aankoopTicketValidation(){return new AankoopTicketValidation();}
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("converter");
        return messageSource;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("resources/css/");
        registry.addResourceHandler("/scripts/**").addResourceLocations("resources/scripts/");
    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/403").setViewName("403");
    }
    @Bean
    public WedstrijdTicketDao wedStrijdTicketDao(){
        return new WedstrijdTicketDaoJpa();
    }
    @Bean
    public StadiumDao stadiumDao(){
        return new StadiumDaoJpa();
    }
    @Bean
    public PopulateDatabase populateDatabase(){
        return new PopulateDatabase();
    }
}

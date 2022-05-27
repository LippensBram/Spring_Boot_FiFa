package com.springboot.spring_boot_fifa;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import validator.AankoopTicketValidation;

import java.util.stream.Stream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FifaControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeAll
    public void before() {
//        controller = new FifaController();
//        mockMvc = standaloneSetup(controller).build();
//        ReflectionTestUtils.setField(controller, "aankoopValidation", new AankoopTicketValidation());
        mockMvc =
                MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testListStadium() throws Exception {
        mockMvc.perform(get("/fifa/stadium"))
                .andExpect(view().name("fifa/stadiumList"))
                .andExpect(model().attributeExists("stadiumList"))
                .andExpect(model().attributeExists("stadium"));
    }
    @Test
    public void testOnSubmit() throws Exception {
        mockMvc.perform(post("/fifa/stadium"))
                .andExpect(view().name("fifa/list"))
                .andExpect(model().attributeExists("wedstrijdenList"));
    }
    @Test
    public void testBestelForm() throws Exception {
        mockMvc.perform(get("/fifa/buy/3"))
                .andExpect(view().name("fifa/koop"))
                .andExpect(model().attributeExists("uitverkocht"))
                .andExpect(model().attributeExists("aankoopTicket"))
                .andExpect(model().attributeExists("wedstrijdTicket"));
    }
    @Test
    public void testBuy() throws Exception {
        mockMvc.perform(post("/fifa/buy/3"))
                .andExpect(view().name("/fifa/stadium"))
                .andExpect(model().attributeExists("aantalTickets"));
    }

    private FifaController controller;

    @ParameterizedTest
    @MethodSource("addFixture")
    public void add(String increase, String decrease) throws Exception{
        mockMvc.perform(post("/increaseDecrease")
                        .param("percentIncrease", increase)
                        .param("percentDecrease", decrease)
                )
                .andExpect(view().name("priceChange"));
    }
//    private static Stream<Arguments> addFixture() {
//        return Stream.of()
//    }

//    private FifaController fifaController;
//    private MockMvc mockMvc;
//
//    @BeforeAll
//    public void before(){
//        fifaController = new FifaController();
//        mockMvc = standaloneSetup(fifaController).build();
//        ReflectionTestUtils.setField(fifaController,"aankoopTicketValidation", new AankoopTicketValidation());
//    }
//    @ParameterizedTest
//    @MethodSource("addFixture")
//    public void koop(String email, String aantalTickets, String code1, String code2 ) throws Exception{
//        mockMvc.perform(post("/buy/{id}")
//                .param("email",email)
//                .param("aantalTickets",aantalTickets)
//                .param("voetbalCode1", code1)
//                .param("voetbalCode2",code2)).andExpect(view().name("koop"));
//    }
//
//    private static Stream<Arguments> addFixture() {
//        return Stream.of(
//                Arguments.of("poep", "100", "30","10"),
//                Arguments.of("poep", "100", "30","10"),
//                Arguments.of("poep", "100", "30","10"),
//                Arguments.of("poep", "100", "30","10"));
//    }
}

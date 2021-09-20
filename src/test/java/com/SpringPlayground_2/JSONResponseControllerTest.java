//package com.SpringPlayground_2;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//
//import static org.hamcrest.Matchers.is;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static  org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//
//@WebMvcTest(JSONRseponseController.class)
//
//public class JSONResponseControllerTest {
//    @Autowired
//    private MockMvc mvc;
//
//    @Test
//    public void testObject() throws Exception {
//        this.mvc.perform(
//                        get("/json/person")
//                                .accept(MediaType.APPLICATION_JSON)
//                                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.firstName", is("Dwayne")))
//                .andExpect(jsonPath("$.lastName", is("Johnson")));
//    }
//}
//

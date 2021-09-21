package com.SpringPlayground_2;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;


import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import static org.hamcrest.Matchers.is;

import static  org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(JSONRseponseController.class)


public class JSONResponseControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testObject() throws Exception {
        this.mvc.perform(
                        get("/json/person")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", is("Dwayne")))
                .andExpect(jsonPath("$.lastName", is("Johnson")));
    }

    @Test
    public void testObjectParams() throws Exception{
        MockHttpServletRequestBuilder request = post("/json/testing")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"q\": \"other\", \"from\": \"2010\"}");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Search: q=something from =2010"));
    }

                      // 1

    @Test
    public void testCreate() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper(); // Helper

        HashMap<String, Object> data = new HashMap<String, Object>(){  // 2
            {
                put("name", "Hercules");
                put("age", 57);
            }
        };

        String json = objectMapper.writeValueAsString(data);            // 3

        MockHttpServletRequestBuilder request = post("/json/test2")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);                                         // 4

        this.mvc.perform(request).andExpect(status().is4xxClientError());
    }

    @Test
    public void testCreateSuiteCase() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        JSONRseponseController.SuitCase suitecase1 = new JSONRseponseController.SuitCase(12, 18,8,35);

        String body = objectMapper.writeValueAsString(suitecase1);

        MockHttpServletRequestBuilder request = post("/json/test2")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body);

        this.mvc.perform(request).andExpect(status().is4xxClientError());
    }

    @Test
    public void sendPersonInfoWithJsonFile() throws Exception{
        String body = getJson("/data.json");
         this.mvc.perform(post("/json/test2")
                 .contentType(MediaType.APPLICATION_JSON)
                 .content(body)).andExpect(status().is4xxClientError());
    }

    private String getJson(String path) throws  Exception{
        URL url = this.getClass().getResource(path);
        return new String (Files.readAllBytes(Paths.get(url.getFile())));
    }
}


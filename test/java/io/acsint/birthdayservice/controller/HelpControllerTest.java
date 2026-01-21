package io.acsint.birthdayservice.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelpController.class)
class HelpControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void helloWithoutName() throws Exception {
        mockMvc.perform(get("/help"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Hello world"))
                .andExpect(jsonPath("$.name").value("world"));
    }

    @Test
    void helloWithName() throws Exception {
        mockMvc.perform(get("/help").param("name", "Alice"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Hello Alice"))
                .andExpect(jsonPath("$.name").value("Alice"));
    }

    @Test
    void helloWithBlankName() throws Exception {
        mockMvc.perform(get("/help").param("name", "   "))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Hello world"))
                .andExpect(jsonPath("$.name").value("world"));
    }

}

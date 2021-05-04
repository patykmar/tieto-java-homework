package com.tieto.homework.demo.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CiphersController.class)
class CiphersControllerTest {

    @Autowired
    private MockMvc mvc;

    @BeforeAll
    public void prepare(){
//        this.toTest = new CiphersController();
    }

    @Test
    void postCesarCryptString() throws Exception {

        mvc.perform(get("/api/cesar/crypt")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void postCesarDecryptString() {
//        assertEquals("zebra", this.toTest.postCesarDecryptString("bgdtc"));
    }

    @Test
    void postMorseCryptString() {
//        assertEquals(".- .... --- .--- ", this.toTest.postMorseCryptString("ahoj"));
    }

    @Test
    void postMorseDecryptString() {
//        assertEquals("ahoj", this.toTest.postMorseDecryptString(".- .... --- .--- "));
    }
}
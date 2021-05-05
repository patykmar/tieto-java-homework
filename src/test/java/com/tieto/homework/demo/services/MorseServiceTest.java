package com.tieto.homework.demo.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MorseServiceTest {

    private final MorseService morseService;

    public MorseServiceTest() {
        this.morseService = new MorseService();
    }

    @Test
    void encrypt() {
        String encrypted = this.morseService.encrypt("ahoj");
        assertEquals(".- .... --- .---", encrypted);
    }

    @Test
    void decrypt() {
        String dencrypted = this.morseService.decrypt(".- .... --- .---");
        assertEquals("ahoj", dencrypted);
    }
}
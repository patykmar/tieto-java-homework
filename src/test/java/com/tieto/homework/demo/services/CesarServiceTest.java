package com.tieto.homework.demo.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CesarServiceTest {

    private final CesarService cesarService;

    CesarServiceTest() {
        this.cesarService = new CesarService();

        // set parameters which is not corrected readed from application.yaml
        this.cesarService.setPosition(2);
        this.cesarService.setAlphabetCharCount(26);
        this.cesarService.setAlphabetStartPosition(97);
        this.cesarService.setAlphabetEndPosition(122);
    }

    @Test
    void encrypt() {
        String encrypted = this.cesarService.encrypt("ahoj");
        assertEquals("cjql", encrypted);
    }

    @Test
    void decrypt() {
        String dencrypted = this.cesarService.decrypt("cjql");
        assertEquals("ahoj", dencrypted);
    }
}
package com.tieto.homework.demo.controller;

import com.tieto.homework.demo.repository.CesarRepository;
import com.tieto.homework.demo.repository.MorseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CiphersController {

    @Autowired
    private CesarRepository cesarRepository;

    @Autowired
    private MorseRepository morseRepository;


    @PostMapping("/cesar/crypt")
    public String postCesarCryptString(@RequestParam( name = "word", defaultValue = "zebra") String word) {
        return this.cesarRepository.encrypt(word);
    }

    @PostMapping("/cesar/decrypt")
    public String postCesarDecryptString(@RequestParam( name = "word", defaultValue = "bgdtc") String word) {
        return this.cesarRepository.decrypt(word);
    }

    @PostMapping("/morse/crypt")
    public String postMorseCryptString(@RequestParam( name = "word", defaultValue = "ahoj") String word) {
        return this.morseRepository.encrypt(word);
    }

    @PostMapping("/morse/decrypt")
    public String postMorseDecryptString(@RequestParam( name = "word", defaultValue = ".- .... --- .---") String word) {
        return this.morseRepository.decrypt(word);
    }
}

package com.tieto.homework.demo.controller;

import com.tieto.homework.demo.classes.Parameters;
import com.tieto.homework.demo.services.CesarService;
import com.tieto.homework.demo.services.MorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CiphersController {

    @Autowired
    private CesarService cesarRepository;

    @Autowired
    private MorseService morseRepository;


    @PostMapping("/cesar/crypt")
    public String postCesarEncryptString(@RequestParam( name = "word", defaultValue = "zebra") String word) {
        return this.cesarRepository.encrypt(word);
    }

    @PostMapping("/cesar/decrypt")
    public String postCesarDecryptString(@RequestParam( name = "word", defaultValue = "bgdtc") String word) {
        return this.cesarRepository.decrypt(word);
    }

    @GetMapping("/cesar/parameters")
    public List<Parameters> getCesarParameters() {
        return this.cesarRepository.getAllParameters();
    }

    @PostMapping("/morse/crypt")
    public String postMorseEncryptString(@RequestParam( name = "word", defaultValue = "ahoj") String word) {
        return this.morseRepository.encrypt(word);
    }

    @PostMapping("/morse/decrypt")
    public String postMorseDecryptString(@RequestParam( name = "word", defaultValue = ".- .... --- .---") String word) {
        return this.morseRepository.decrypt(word);
    }
}

package com.tieto.homework.demo.controller;

import com.tieto.homework.demo.entity.Parameters;
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
    private CesarService cesarService;

    @Autowired
    private MorseService morseService;


    @PostMapping("/cesar/encrypt")
    public String postCesarEncryptString(@RequestParam( name = "word", defaultValue = "zebra") String word) {
        return this.cesarService.encrypt(word);
    }

    @PostMapping("/cesar/decrypt")
    public String postCesarDecryptString(@RequestParam( name = "word", defaultValue = "bgdtc") String word) {
        return this.cesarService.decrypt(word);
    }

    @GetMapping("/cesar/parameters")
    public List<Parameters> getCesarParameters() {
        return this.cesarService.getAllParameters();
    }

    @PostMapping("/morse/encrypt")
    public String postMorseEncryptString(@RequestParam( name = "word", defaultValue = "ahoj") String word) {
        return this.morseService.encrypt(word);
    }

    @PostMapping("/morse/decrypt")
    public String postMorseDecryptString(@RequestParam( name = "word", defaultValue = ".- .... --- .---") String word) {
        return this.morseService.decrypt(word);
    }
}

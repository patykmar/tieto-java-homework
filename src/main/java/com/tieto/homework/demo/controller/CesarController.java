package com.tieto.homework.demo.controller;

import com.tieto.homework.demo.repository.CesarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CesarController {

    @Autowired
    private CesarRepository cesarRepository;


    @PostMapping("/cesar/crypt")
    public String postCesarCryptString(@RequestParam( name = "word", defaultValue = "zebra") String word) {
        return this.cesarRepository.encrypt(word);
    }

    @PostMapping("/cesar/decrypt")
    public String postCesarDecryptString(@RequestParam( name = "word", defaultValue = "bgdtc") String word) {
        return this.cesarRepository.decrypt(word);
    }
}

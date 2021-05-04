package com.tieto.homework.demo.controller;

import com.tieto.homework.demo.classes.Slovo;
import com.tieto.homework.demo.repository.CesarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CesarController {

    @Autowired
    private CesarRepository cesarRepository;


    @PostMapping("/sifruj")
    public Slovo postSifruj(@RequestBody Slovo slovo) {
        return this.cesarRepository.sifruj(slovo);
    }

    @PostMapping("/desifruj")
    public Slovo postDesifruj(@RequestBody Slovo slovo) {
        return this.cesarRepository.desifruj(slovo);
    }
}

package com.tieto.homework.demo.repository;

import com.tieto.homework.demo.classes.Slovo;
import org.springframework.stereotype.Repository;

@Repository
public class CesarRepository {


    public static Slovo sifruj(Slovo slovo) {
        String localSlovo = slovo.getSlovo().toLowerCase();
        char[] slovoArray = localSlovo.toCharArray();
        String sifrovaneSlovo = "";

        for (char znak : slovoArray) {
            int poziceNovehoZnaku = (int)znak + slovo.getPosun();
            if (poziceNovehoZnaku > 122){
                poziceNovehoZnaku -= 26;
            }
            sifrovaneSlovo += (char)poziceNovehoZnaku;
        }

        return new Slovo(sifrovaneSlovo,slovo.getPosun());
    }

    public static Slovo desifruj(Slovo slovo) {
        String localSlovo = slovo.getSlovo().toLowerCase();
        char[] slovoArray = localSlovo.toCharArray();
        String deSifrovaneSlovo = "";

        for (char znak : slovoArray) {
            int poziceNovehoZnaku = (int)znak - slovo.getPosun();
            if (poziceNovehoZnaku < 97){
                poziceNovehoZnaku += 26;
            }
            deSifrovaneSlovo += (char)poziceNovehoZnaku;
        }

        return new Slovo(deSifrovaneSlovo, slovo.getPosun());
    }

}

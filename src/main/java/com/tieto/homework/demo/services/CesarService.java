package com.tieto.homework.demo.services;

import com.tieto.homework.demo.entity.Parameters;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CesarService implements IEncryptable {

    @Value("${custom.ciphers.cesar.position}")
    @Getter @Setter private int position;

    @Value("${custom.ciphers.cesar.alphabet.position.start}")
    @Getter @Setter private int alphabetStartPosition;

    @Value("${custom.ciphers.cesar.alphabet.position.end}")
    @Getter @Setter private int alphabetEndPosition;

    @Value("${custom.ciphers.cesar.alphabet.char-count}")
    @Getter @Setter private int alphabetCharCount;

    @Override
    public String encrypt(String word) {
        String localWord = word.toLowerCase();
        char[] slovoArray = localWord.toCharArray();
        String cipheredWord = "";

        for (char character : slovoArray) {
            int positionOfNewChar = (int) character + this.position;
            if (positionOfNewChar > this.alphabetEndPosition) {
                positionOfNewChar -= this.alphabetCharCount;
            }
            cipheredWord += (char) positionOfNewChar;
        }

        return cipheredWord;
    }

    @Override
    public String decrypt(String word) {
        String localWord = word.toLowerCase();
        char[] slovoArray = localWord.toCharArray();
        String decryptedWord = "";

        for (char znak : slovoArray) {
            int positionOfNewChar = (int) znak - this.position;
            if (positionOfNewChar < this.alphabetStartPosition) {
                positionOfNewChar += this.alphabetCharCount;
            }
            decryptedWord += (char) positionOfNewChar;
        }

        return decryptedWord;
    }

    public List<Parameters> getAllParameters() {
        List<Parameters> parameters = new ArrayList<>();
        parameters.add(new Parameters("position", this.position));
        parameters.add(new Parameters("alphabet-start-position", this.alphabetStartPosition));
        parameters.add(new Parameters("alphabet-end-position", this.alphabetEndPosition));
        parameters.add(new Parameters("alphabet-char-count", this.alphabetCharCount));
        return parameters;
    }
}

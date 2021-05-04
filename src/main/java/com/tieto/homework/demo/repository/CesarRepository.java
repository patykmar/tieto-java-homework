package com.tieto.homework.demo.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class CesarRepository implements IEncryptable{

    @Value("${custom.ciphers.cesar.position}")
    private int position;

    @Value("${custom.ciphers.cesar.alphabet.position.start}")
    private int alphabetStartPosition;

    @Value("${custom.ciphers.cesar.alphabet.position.end}")
    private int alphabetEndPosition;

    @Value("${custom.ciphers.cesar.alphabet.char-count}")
    private int alphabetCharCount;

    @Override
    public String encrypt(String word) {
        String localWord = word.toLowerCase();
        char[] slovoArray = localWord.toCharArray();
        String cipheredWord = "";

        for (char character : slovoArray) {
            int positionOfNewChar = (int)character + this.position;
            if (positionOfNewChar > this.alphabetEndPosition){
                positionOfNewChar -= this.alphabetCharCount;
            }
            cipheredWord += (char)positionOfNewChar;
        }

        return cipheredWord;
    }

    @Override
    public String decrypt(String word) {
        String localWord = word.toLowerCase();
        char[] slovoArray = localWord.toCharArray();
        String decryptedWord = "";

        for (char znak : slovoArray) {
            int positionOfNewChar = (int)znak - this.position;
            if (positionOfNewChar < this.alphabetStartPosition){
                positionOfNewChar += this.alphabetCharCount;
            }
            decryptedWord += (char)positionOfNewChar;
        }

        return decryptedWord;
    }
}

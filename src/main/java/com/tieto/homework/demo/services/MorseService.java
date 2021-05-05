package com.tieto.homework.demo.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MorseService implements IEncryptable {

    private Map<Character, String> alphabetToMorse;
    private Map<String, Character> morseToAlphabet;

    public MorseService() {
        super();
        this.alphabetToMorse = new HashMap<>();
        this.morseToAlphabet = new HashMap<>();
        this.setAlphabetToMorse();
        this.setMorseToAlphabet();
    }

    @Override
    public String encrypt(String word) {
        String encrypterWord = "";
        for (char character : word.toCharArray()) {
            encrypterWord += this.alphabetToMorse.get(character) + " ";
        }
        return encrypterWord.trim();
    }

    @Override
    public String decrypt(String word) {
        String decrypterWord = "";
        for (String morseChar : word.split(" ")) {
            decrypterWord += this.morseToAlphabet.get(morseChar);
        }
        return decrypterWord;
    }

    private void setAlphabetToMorse() {
        this.alphabetToMorse.put('a', ".-");
        this.alphabetToMorse.put('b', "-...");
        this.alphabetToMorse.put('c', "-.-.");
        this.alphabetToMorse.put('d', "-..");
        this.alphabetToMorse.put('e', ".");
        this.alphabetToMorse.put('f', "..-.");
        this.alphabetToMorse.put('g', "--.");
        this.alphabetToMorse.put('h', "....");
        this.alphabetToMorse.put('i', "..");
        this.alphabetToMorse.put('j', ".---");
        this.alphabetToMorse.put('k', "-.-");
        this.alphabetToMorse.put('l', ".-..");
        this.alphabetToMorse.put('m', "--");
        this.alphabetToMorse.put('n', "-.");
        this.alphabetToMorse.put('o', "---");
        this.alphabetToMorse.put('p', ".--.");
        this.alphabetToMorse.put('q', "--.-");
        this.alphabetToMorse.put('r', ".-.");
        this.alphabetToMorse.put('s', "...");
        this.alphabetToMorse.put('t', "-");
        this.alphabetToMorse.put('u', "..-");
        this.alphabetToMorse.put('v', "...-");
        this.alphabetToMorse.put('w', ".--");
        this.alphabetToMorse.put('x', "-..-");
        this.alphabetToMorse.put('y', "-.--");
        this.alphabetToMorse.put('z', "--..");
    }

    private void setMorseToAlphabet() {
        this.morseToAlphabet.put(".-", 'a');
        this.morseToAlphabet.put("-...", 'b');
        this.morseToAlphabet.put("-.-.", 'c');
        this.morseToAlphabet.put("-..", 'd');
        this.morseToAlphabet.put(".", 'e');
        this.morseToAlphabet.put("..-.", 'f');
        this.morseToAlphabet.put("--.", 'g');
        this.morseToAlphabet.put("....", 'h');
        this.morseToAlphabet.put("..", 'i');
        this.morseToAlphabet.put(".---", 'j');
        this.morseToAlphabet.put("-.-", 'k');
        this.morseToAlphabet.put(".-..", 'l');
        this.morseToAlphabet.put("--", 'm');
        this.morseToAlphabet.put("-.", 'n');
        this.morseToAlphabet.put("---", 'o');
        this.morseToAlphabet.put(".--.", 'p');
        this.morseToAlphabet.put("--.-", 'q');
        this.morseToAlphabet.put(".-.", 'r');
        this.morseToAlphabet.put("...", 's');
        this.morseToAlphabet.put("-", 't');
        this.morseToAlphabet.put("..-", 'u');
        this.morseToAlphabet.put("...-", 'v');
        this.morseToAlphabet.put(".--", 'w');
        this.morseToAlphabet.put("-..-", 'x');
        this.morseToAlphabet.put("-.--", 'y');
        this.morseToAlphabet.put("--..", 'z');
    }
}

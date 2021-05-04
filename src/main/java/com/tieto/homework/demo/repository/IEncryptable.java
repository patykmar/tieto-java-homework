package com.tieto.homework.demo.repository;

public interface IEncryptable {
    String encrypt(String word);
    String decrypt(String word);
}

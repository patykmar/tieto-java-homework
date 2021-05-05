package com.tieto.homework.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Slovo {
    private String slovo;
    private int posun;

    @Override
    public String toString() {
        return this.slovo;
    }
}

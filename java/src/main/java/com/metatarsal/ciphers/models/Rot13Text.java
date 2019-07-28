package com.metatarsal.ciphers.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode()
public class Rot13Text extends Text {

    private static final int KEY = 13;

    public Rot13Text(String plainText) {
        super();
        this.plainText = plainText;
    }

    public int getKEY() {
        return KEY;
    }
}

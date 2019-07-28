package com.metatarsal.ciphers.models;

import lombok.Data;

@Data
public abstract class Text {

    String plainText;
    String cipherText;

    //TODO why can't other classes inherit lombok @Data getters/setters?
    public String getPlainText() {
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }

    public String getCipherText() {
        return cipherText;
    }

    public void setCipherText(String cipherText) {
        this.cipherText = cipherText;
    }
}

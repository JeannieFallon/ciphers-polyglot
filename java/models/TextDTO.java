package com.metatarsal.primavera.models;

public class TextDTO {

    private String plaintext;
    private String ciphertext;
    private String key;
    private int textLength;
    private int keyLength;
    private int shiftVal;

    public TextDTO() {

    }

    public TextDTO(String plainText, int shiftVal) {
        this.plaintext = plainText;
        this.textLength = plainText.length();
        this.shiftVal = shiftVal;
    }

    public TextDTO(String plaintext, String key) {
        this.plaintext = plaintext;
        this.key = key;
        this.textLength = plaintext.length();
        this.keyLength = key.length();
    }

    public String getPlaintext() {
        return plaintext;
    }

    public void setPlaintext(String plaintext) {
        this.plaintext = plaintext;
    }

    public String getCiphertext() {
        return ciphertext;
    }

    public void setCiphertext(String ciphertext) {
        this.ciphertext = ciphertext;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getTextLength() {
        return textLength;
    }

    public int getKeyLength() {
        return keyLength;
    }

    public int getShiftVal() {
        return shiftVal;
    }
}

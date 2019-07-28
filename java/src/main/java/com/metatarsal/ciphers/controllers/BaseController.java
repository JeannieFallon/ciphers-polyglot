package com.metatarsal.ciphers.controllers;

import com.metatarsal.ciphers.models.CaesarText;
import com.metatarsal.ciphers.models.Rot13Text;
import com.metatarsal.ciphers.models.VigenereText;
import com.metatarsal.ciphers.services.CipherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class BaseController {

    @Autowired
    Rot13Controller rot13Controller;
    @Autowired
    CaesarController caesarController;
    @Autowired
    VigenereController vigenereController;
    @Autowired
    CipherService cipherService;

    public void index() {

        Scanner scanner = new Scanner(System.in);
        String plainText, keyword;
        int key;
        boolean isValid;

        System.out.println("Enter plaintext:");
        plainText = scanner.nextLine();

        isValid = false;
        key = 0;
        while (!isValid) {
            System.out.println("Enter a positive integer as the key for the Caesar cipher:");
            var input = scanner.nextLine();
            try {
                key = Integer.parseInt(input);
                isValid = key > 0;
            } catch (Exception e) {
                System.out.println("Invalid input. Positive integers only.");
            }
        }

        isValid = false;
        keyword = "";
        while (!isValid) {
            System.out.println("Enter a key word for the Vigenere cipher:");
            keyword = scanner.nextLine();
            if (keyword.matches("(?<=\\s|^)[a-zA-Z]*(?=[.,;:]?\\s|$)")) {
                isValid = true;
            } else {
                System.out.println("Invalid input. Alphabetic characters only.");
            }
        }

	scanner.close();

        Rot13Text rText = rot13Controller.rot13Cipher(new Rot13Text(plainText));
        CaesarText cText = caesarController.caesarCipher(new CaesarText(plainText, key));
        VigenereText vText = vigenereController.vigenereCipher(new VigenereText(plainText, keyword));

        System.out.println("ROT13:\n" + rText.getCipherText());
        System.out.println("Caesar:\n" + cText.getCipherText());
        System.out.println("Vigenere:\n" +  vText.getCipherText());
    }

    public StringBuilder getStringBuilder() {
        return new StringBuilder();
    }
}

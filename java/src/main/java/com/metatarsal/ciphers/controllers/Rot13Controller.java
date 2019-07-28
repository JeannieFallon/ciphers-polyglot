package com.metatarsal.ciphers.controllers;

import com.metatarsal.ciphers.models.Rot13Text;
import org.springframework.stereotype.Controller;

@Controller
public class Rot13Controller extends BaseController {

    public Rot13Text rot13Cipher(Rot13Text text) {

        StringBuilder sb = getStringBuilder();

        for(int i = 0, n = text.getPlainText().length(); i < n; i++) {
            sb.append(cipherService.getCipherLetter(text.getPlainText().charAt(i),
                                                    text.getKEY()));
        }

        text.setCipherText(sb.toString());

        return text;
    }
}

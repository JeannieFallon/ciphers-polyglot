package com.metatarsal.ciphers.controllers;

import com.metatarsal.ciphers.models.CaesarText;
import org.springframework.stereotype.Controller;

@Controller
public class CaesarController extends BaseController {

    public CaesarText caesarCipher(CaesarText text) {

        StringBuilder sb = getStringBuilder();

        for (int i = 0, n = text.getPlainText().length(); i < n; i++) {
            sb.append(cipherService.getCipherLetter(text.getPlainText().charAt(i),
                                                    text.getKey()));
        }

        text.setCipherText(sb.toString());

        return text;
    }
}

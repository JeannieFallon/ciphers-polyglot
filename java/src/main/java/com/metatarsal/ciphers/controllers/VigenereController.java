package com.metatarsal.ciphers.controllers;

import com.metatarsal.ciphers.models.VigenereText;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

@Controller
public class VigenereController extends BaseController {

    public VigenereText vigenereCipher(VigenereText text) {

        StringBuilder sb = getStringBuilder();
        ArrayList<Integer> shiftVals = cipherService.getShiftVals(text.getKeyword());
        int i = 0;

        while (i < text.getPlainText().length()) {

            for (int j = 0, n = shiftVals.size(); j < n; j++) {

                if (i >= text.getPlainText().length()) {
                    break;
                } else {
                    sb.append(cipherService.getCipherLetter(text.getPlainText().charAt(i),
                                                            shiftVals.get(j)));
                }

                i++;
            }
        }

        text.setCipherText(sb.toString());
        return text;
    }
}

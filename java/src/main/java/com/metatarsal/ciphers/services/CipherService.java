package com.metatarsal.ciphers.services;

import com.metatarsal.ciphers.util.CipherConstants;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CipherService {

    public char getCipherLetter(char letter, int shiftVal) {

        int asciiVal = (int)letter;

        // only shift upper- and lowercase letters
        if (asciiVal >= CipherConstants.ENG_LOWER_FLOOR && asciiVal <= CipherConstants.ENG_LOWER_CEILING) {
            asciiVal = getCipherAscii(CipherConstants.ENG_LOWER_FLOOR, asciiVal, shiftVal);
        } else if (asciiVal >= CipherConstants.ENG_UPPER_FLOOR && asciiVal <= CipherConstants.ENG_UPPER_CEILING) {
            asciiVal =  getCipherAscii(CipherConstants.ENG_UPPER_FLOOR, asciiVal, shiftVal);
        }

        return (char)asciiVal;
    }

    public int getCipherAscii(int alphaMapVal, int asciiVal, int shiftVal) {

        // map ASCII value onto index of letter in alphabet
        int alphaIdx = asciiVal - alphaMapVal;
        // wrap rotation around alphabet indices
        alphaIdx = getRotation(alphaIdx, shiftVal);
        // return to original ASCII range
        return alphaIdx + alphaMapVal;
    }

    public int getRotation(int alphaIdx, int shiftVal) {
        return  (alphaIdx + shiftVal) % CipherConstants.ENG_ALPHA_LEN;
    }

    public ArrayList<Integer> getShiftVals(String keyword) {

        ArrayList<Integer> shiftVals = new ArrayList<>();
        int asciiVal;

        keyword = keyword.toLowerCase();

        for (int i = 0, n = keyword.length(); i < n; i++) {
            asciiVal = (int)keyword.charAt(i);
            shiftVals.add((char)asciiVal - CipherConstants.ENG_LOWER_FLOOR + 1);
        }

        return shiftVals;
    }
}

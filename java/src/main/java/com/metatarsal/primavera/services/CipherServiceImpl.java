package com.metatarsal.primavera.services;

import com.metatarsal.primavera.constants.CipherConstants;
import com.metatarsal.primavera.models.TextDTO;
import org.springframework.stereotype.Service;

@Service
public class CipherServiceImpl implements CipherService {

    public CipherServiceImpl() {

    }

    @Override
    public TextDTO getSingleShiftCipher(TextDTO text) {
        StringBuffer sb = new StringBuffer();
        for (char currChar : text.getPlaintext().toCharArray()) {
            sb.append(shiftChar(currChar, text.getShiftVal()));
        }
        text.setCiphertext(sb.toString());
        return text;
    }

    @Override
    public TextDTO getMultiShiftCipher(TextDTO text) {
        StringBuffer sb = new StringBuffer();

        // get shift value of each letter in key according to its index in alphabet
        int textLen = text.getTextLength();
        int keyLen = text.getKeyLength();
        int[] shiftVals = new int[keyLen];
        shiftVals = getShiftValsFromKey(text.getKey(), shiftVals);

        for (int i = 0; i <= textLen; i++) {
            for (int j = 0; j < keyLen; j++) {
                if (i < textLen ) {
                    char currChar = text.getPlaintext().toCharArray()[i];
                    sb.append(shiftChar(currChar, shiftVals[j]));
                    i++;
                } else {
                    break;
                }
            }
        }

        text.setCiphertext(sb.toString());
        return text;
    }

    @Override
    public char shiftChar(char charToShift, int shiftVal) {
        int asciiVal = (int)charToShift;

        // only shift upper or lower case letters in text
        if (asciiVal >= CipherConstants.ENG_LOWER_FLOOR && asciiVal <= CipherConstants.ENG_LOWER_CEILING) {
            asciiVal = getCipherAscii(CipherConstants.ENG_LOWER_FLOOR, asciiVal, shiftVal);
        } else if (asciiVal >= CipherConstants.ENG_UPPER_FLOOR && asciiVal <= CipherConstants.ENG_UPPER_CEILING) {
            asciiVal = getCipherAscii(CipherConstants.ENG_UPPER_FLOOR, asciiVal, shiftVal);
        }

        return (char)asciiVal;
    }

    @Override
    public int getCipherAscii(int asciiDiffVal, int asciiVal, int shiftVal) {
        // map ASCII value onto index of letter in alphabet
        int alphaIdx = asciiVal - asciiDiffVal;
        // wrap rotation around alphabet indices
        alphaIdx = getRotation(alphaIdx, shiftVal);
        // return to original ASCII range
        return alphaIdx + asciiDiffVal;
    }

    @Override
    public int getRotation(int alphaIdx, int shiftVal) {
        return (alphaIdx + shiftVal) % CipherConstants.ENG_ALPHA_LEN;
    }

    @Override
    public int[] getShiftValsFromKey(String key, int[] shiftVals) {
        for (int i = 0; i < shiftVals.length; i++) {
            shiftVals[i] = getShiftValFromChar(key.toCharArray()[i]);
        }
        return shiftVals;
    }

    @Override
    public int getShiftValFromChar(char currChar) {
        int asciiVal = (int)currChar;
        int shiftVal = 0;

        //TODO refactor to work with shiftChar() & getCipherAscii() and fix ascii shift
        if (asciiVal >= CipherConstants.ENG_LOWER_FLOOR && asciiVal <= CipherConstants.ENG_LOWER_CEILING) {
            shiftVal = asciiVal - CipherConstants.ENG_LOWER_FLOOR + 1;
        } else if (asciiVal >= CipherConstants.ENG_UPPER_FLOOR && asciiVal <= CipherConstants.ENG_UPPER_CEILING) {
            shiftVal = asciiVal - CipherConstants.ENG_UPPER_FLOOR + 1;
        }

        return shiftVal;
    }
}

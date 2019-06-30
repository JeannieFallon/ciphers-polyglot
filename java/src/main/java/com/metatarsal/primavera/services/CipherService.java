package com.metatarsal.primavera.services;

import com.metatarsal.primavera.models.TextDTO;
import org.springframework.stereotype.Service;

/*
* Service interface for cipher methods
* */
@Service
public interface CipherService {

    TextDTO getSingleShiftCipher(TextDTO text);
    TextDTO getMultiShiftCipher(TextDTO text);
    char shiftChar(char charToShift, int shiftVal);
    int getCipherAscii(int asciiDiffVal, int asciiVal, int shiftVal);
    int getRotation(int alphaIdx, int shiftVal);
    int[] getShiftValsFromKey(String key, int[] shiftVals);
    int getShiftValFromChar(char currChar);
}

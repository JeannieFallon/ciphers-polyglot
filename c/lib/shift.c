#include <stdio.h>
#include "shift.h"

void getCipherChar(char * charPtr, int shiftVal) {
	
	int asciiVal;
	int * asciiPtr;

	asciiVal = *charPtr;
	asciiPtr = &asciiVal;

	// only shift upper- and lowercase letters
	if (asciiVal >= ENG_UPPER_FLOOR && asciiVal <= ENG_UPPER_CEILING) {
		getCipherAscii(ENG_UPPER_FLOOR, asciiPtr, shiftVal);
	} else if (asciiVal >= ENG_LOWER_FLOOR && asciiVal <= ENG_LOWER_CEILING) {
		getCipherAscii(ENG_LOWER_FLOOR, asciiPtr, shiftVal);
	}

	*charPtr = (char)(asciiVal);
}

void getCipherAscii(int alphaMapVal, int * asciiPtr, int shiftVal) {

    int alphaIdx;
    int * alphaIdxPtr;

    // map ASCII value onto index of letter in alphabet
    alphaIdx = *asciiPtr - alphaMapVal;
    alphaIdxPtr = &alphaIdx;

    // wrap rotation around alphabet indices
    getRotation(alphaIdxPtr, shiftVal);

    // map alphabet index back onto original ASCII range
    *asciiPtr = *alphaIdxPtr + alphaMapVal;
}

void getRotation(int * alphaIdxPtr, int shiftVal) {
	*alphaIdxPtr = (*alphaIdxPtr + shiftVal) % ENG_ALPHA_LEN;
}

void getShiftVals(int * shiftValPtr, char * keywordPtr) {

	int i, asciiVal;

	i=0;
	while (keywordPtr[i] != '\0') {
		asciiVal = keywordPtr[i];

		if (asciiVal >= ENG_UPPER_FLOOR && asciiVal <= ENG_UPPER_CEILING) {
			shiftValPtr[i] = asciiVal - ENG_UPPER_FLOOR + 1;
		} else if (asciiVal >= ENG_LOWER_FLOOR && asciiVal <= ENG_LOWER_CEILING) {
			shiftValPtr[i] = asciiVal - ENG_LOWER_FLOOR + 1;			
		}
		i++;
	}
}




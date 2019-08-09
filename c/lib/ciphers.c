#include <stdio.h>
#include "ciphers.h"
#include "shift.h"

void rot13(char * arr) {

	char * charPtr;
	int i;

	i = 0;
	while (arr[i] != '\0') {
		charPtr = &arr[i];
		getCipherChar(charPtr, SHIFT_VAL);
		i++;
	}
}

void caesar(char * arr, int shiftVal) {

	char * charPtr;
	int i;

	i=0;
	while (arr[i] != '\0') {
		charPtr = &arr[i];
		getCipherChar(charPtr, shiftVal);
		i++;
	}
}

void vigenere(char * arr, char * keyword, int arrLen, int keyLen) {

	// get array of shift values from input keyword
	// shiftVals is len-1 because no null-terminating on int array
	int shiftVals[keyLen-1];
	getShiftVals(shiftVals, keyword);

	char * charPtr;
	int i, j;

	i=0;
	while (arr[i] != '\0') {

		j=0;
		while (j < keyLen) {

			// don't include null-term in accessible array indices
			if (i >= (arrLen - 1)) {
				break;
			} else {
				charPtr = &arr[i];
				getCipherChar(charPtr, shiftVals[j]);
			}

			i++;
			j++;
		}
	}
}

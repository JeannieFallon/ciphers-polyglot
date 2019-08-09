#include <stdio.h>
#include "util.h"

void getLen(char * arr, int * lenPtr) {
	int i = 0;
	while (arr[i] != '\0') {
		*lenPtr = i+1;
		i++; 
	}
	// add space for null-terminating char
	(*lenPtr)++;
}

void copyArr(char * arr, char * newArr) {
	int i = 0;
	while (arr[i] != '\0') {
		newArr[i] = arr[i];
		i++;
	}
	// add null-terminating char
	newArr[i] = '\0';
}

void trim(char * arr) {
	int i=0;
	while (arr[i] != '\0') {
		if (arr[i] == '\n') {
			arr[i] = '\0';
			break;
		}
		i++;
	}
}

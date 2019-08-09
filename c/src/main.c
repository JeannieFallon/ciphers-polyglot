#include <stdio.h>
#include <stdlib.h>
#include "../lib/ciphers.h"
#include "../lib/util.h"
#define PLAINTXT_LEN 100
#define KEYWORD_LEN 10

int main(void) {

	//TODO use realloc & make array sizes dynamic
	char * plainArr = (char *)malloc((PLAINTXT_LEN * sizeof(char)) + 1);
	char * keyword = (char *)malloc((KEYWORD_LEN * sizeof(char)) + 1);
	char * caesKeyInput = (char *)malloc(2 * sizeof(char));
	int caesarKey = 0;

	printf("Enter string plaintext (max 100 char): ");
	fgets(plainArr, PLAINTXT_LEN, stdin);

	while (!caesarKey) {
		printf("Enter integer for Caesar key value (max value 99): ");
		fgets(caesKeyInput, sizeof(caesKeyInput), stdin);
		caesarKey = atoi(caesKeyInput);
	}

	printf("Enter string for Vigenere keyword (max 10 char): ");
	fgets(keyword, KEYWORD_LEN, stdin);
	trim(keyword);

	// get lengths of input plaintext & keyword
	int len, keyLen;
	int * lenPtr = &len;
	int * keyLenPtr = &keyLen;
	getLen(plainArr, lenPtr);
	getLen(keyword, keyLenPtr);

	// allocate cipher arrays & load with plaintext
	char * rot13Arr = (char *)malloc((len * sizeof(char)) + 1);
	char * caesarArr = (char *)malloc((len * sizeof(char)) + 1);
	char * vigenereArr = (char *)malloc((len * sizeof(char)) + 1);
	copyArr(plainArr, rot13Arr);
	copyArr(plainArr, caesarArr);
	copyArr(plainArr, vigenereArr);

	rot13(rot13Arr);
	caesar(caesarArr, caesarKey);
	vigenere(vigenereArr, keyword, len, keyLen);

	printf("Plain text:\n%s\n", plainArr);
	printf("ROT13 cipher text:\n%s\n", rot13Arr);
	printf("Caesar cipher text:\n%s\n", caesarArr);
	printf("Vigenere cipher text:\n%s\n", vigenereArr);

	return 0;
}

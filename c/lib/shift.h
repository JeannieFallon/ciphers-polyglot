#ifndef _SHIFT_H_
#define _SHIFT_H_
#define ENG_ALPHA_LEN 26
#define ENG_UPPER_FLOOR 65
#define ENG_UPPER_CEILING 90
#define ENG_LOWER_FLOOR 97
#define ENG_LOWER_CEILING 122

void getCipherChar(char *, int);
void getCipherAscii(int, int *, int);
void getRotation(int *, int);
void getShiftVals(int *, char *);

#endif

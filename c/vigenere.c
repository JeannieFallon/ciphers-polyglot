// CS50 Problem Set 2: vigenere.c

// I.   Get key 
// II.  Get plaintext
// III. Encipher
// IV.  Print cipher text

// variables: string key, int keyLength, string plain, int keyLetter

#include <stdio.h>
#include <cs50.h>
#include <ctype.h>
#include <string.h>
#include <stdlib.h>

// I.   Get key 
int main(int argc, string argv[])
{
    
//check key for single word and alpha only
    if (argc != 2)
    {
        printf("Please enter a one-word key.\n");
        return 1;
    }
    else
    {
        for (int i = 0, n = strlen(argv[1]); i < n; i++)
        {
            if (!isalpha(argv[1][i]))
            {
                printf("Invalid key.\n");
                return 1;
            }
        }
    }

string key = argv[1];
int keyLength = strlen(key);

// II. Get plaintext
string plain = GetString();

// III. Encipher
for (int i = 0, j = 0, n = strlen(plain); i < n; i++)
{
    int keyLetter = tolower(key[j % keyLength]) - 'a';
    
// IV.  Print cipher text  
    if(isupper(plain[i]))
    {
        printf("%c", 'A' + (plain[i] - 'A' + keyLetter) % 26);
        j++;
    }
    else if (islower(plain[i]))
    {
        printf("%c", 'a' + (plain[i] - 'a' + keyLetter) % 26);
        j++;
    }
    else
    {
        printf("%c", plain[i]);
    }
}
  
printf("\n");

return 0;

}

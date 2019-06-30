// CS50 Problem Set 2: caesar.c

// I.   Get the key (command-line prompt)
// II.  Get the plaintext
// III. Encipher
// IV.  Print ciphertext

#include <stdio.h>
#include <cs50.h>
#include <ctype.h>
#include <string.h>
#include <stdlib.h>

int main(int argc, string argv[])

{

    // I.   Get the key (command-line prompt)
//      condition to check that argc == 2

    if (argc != 2)
    {
        printf("Nope. Try again.\n");
        
        return 1;
    }

    else
    {

//      convert input string to integer
    int k = atoi(argv[1]);
    
    
// II.  Get the plaintext
//      store as string 'plain'
    string plain = GetString();
    
// III. Encipher
//      loop through plaintext (string 'plain')
    int i, n;
    for (i = 0, n = strlen(plain); i <= (n-1); i++)
    {
// IV.  Print ciphertext  
        if (isupper(plain[i]))
        {
            printf("%c", 'A' + (plain[i] - 'A' + k)%26);
        }
        
        else if (islower(plain[i]))
        {
            printf("%c", 'a' + (plain[i] - 'a' + k)%26);
        }
        
        else
        {
            printf("%c", plain[i]);
        }
        
        
    }
    
    printf("\n");
    
    return 0;
    
    }
 
    
}

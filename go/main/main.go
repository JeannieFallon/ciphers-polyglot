package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"

	"github.com/jeannie/cipher-go/ciphers"
)

// TODO validation

func main() {
	reader := bufio.NewReader(os.Stdin)

	fmt.Println("Enter your plain text:")
	plainTxt, _ := reader.ReadString('\n')

	fmt.Println("Enter a key value for the Caesar cipher:")
	keyStr, _ := reader.ReadString('\n')
	keyVal, _ := strconv.Atoi(strings.TrimSpace(keyStr))

	fmt.Println("Enter a key word for the Vigenere cipher:")
	keyWord, _ := reader.ReadString('\n')

	rot13Cipher := ciphers.GetRotThirteen(plainTxt)
	caesarCipher := ciphers.GetCaesar(plainTxt, keyVal)
	vigenereCipher := ciphers.GetVigenere(plainTxt, keyWord)

	fmt.Println("\n* * * * *")
	fmt.Printf("Rot-13 cipher text:\n%s\n", rot13Cipher)
	fmt.Printf("Caesar cipher text:\n%s\n", caesarCipher)
	fmt.Printf("Vigenere cipher text:\n%s\n", vigenereCipher)
}

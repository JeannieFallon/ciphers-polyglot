package ciphers

import (
	"strings"

	"github.com/jeannie/cipher-go/util"
)

// GetVigenere applies Vigenere cipher to given string
func GetVigenere(plainTxt string, keyWord string) string {

	var b strings.Builder
	var ascVal int
	var shiftVal int
	var cipherLet string

	// make sure no extraenous spaces on keyword from input
	keyWord = strings.TrimSpace(keyWord)

	txtLen := len(plainTxt)
	keyLen := len(keyWord)

	// get shift value of each letter in keyword
	shiftVals := util.GetShiftVals(keyWord, keyLen)

	// loop over each letter of plain text
	i := 0
	for i < txtLen {

		// loop over each letter of keyword
		for j := 0; j < keyLen; j++ {

			if i >= txtLen {
				break
			} else {
				ascVal = int(plainTxt[i])
				shiftVal = shiftVals[j]
				cipherLet = util.GetCipherLetter(ascVal, shiftVal)
				b.WriteString(cipherLet)

				i++
			}
		}
	}

	return b.String()
}

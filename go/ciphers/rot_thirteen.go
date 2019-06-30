package ciphers

import (
	"strings"

	"github.com/jeannie/cipher-go/util"
)

// GetRotThirteen applies Rot-13 cipher to given string
func GetRotThirteen(plainTxt string) string {

	var b strings.Builder
	var ascVal int
	var cipherLet string

	for i := 0; i < len(plainTxt); i++ {
		ascVal = int(plainTxt[i])
		cipherLet = util.GetCipherLetter(ascVal, 13)
		b.WriteString(cipherLet)
	}

	return b.String()
}

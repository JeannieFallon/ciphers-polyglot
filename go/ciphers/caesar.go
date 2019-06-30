package ciphers

import (
	"strings"

	"github.com/jeannie/cipher-go/util"
)

// GetCaesar applies Caesar cipher to given string
func GetCaesar(plainTxt string, keyVal int) string {

	var b strings.Builder
	var ascVal int
	var cipherLet string

	for i := 0; i < len(plainTxt); i++ {
		ascVal = int(plainTxt[i])
		cipherLet = util.GetCipherLetter(ascVal, keyVal)
		b.WriteString(cipherLet)
	}

	return b.String()
}

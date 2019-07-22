using System;
using System.Collections.Generic;
using System.Text;

namespace Ciphers.Models
{
    public class VigenereText : Text
    {
        public string KeyWord { get; set; }

        public VigenereText(string plainTxt, string keyWord) : base(plainTxt)
        {
            KeyWord = keyWord;
        }
    }
}

using System;
using System.Collections.Generic;
using System.Text;
using Ciphers.Models;

namespace Ciphers.Controllers
{
    public class Rot13Controller : BaseController
    {
        public Rot13Text GetRot13Text(Rot13Text rText)
        {
            foreach (char plnChar in rText.PlainText)
            {
                rText.StrBuild.Append(CipherService.GetCipherLetter(plnChar, rText.Key));
            }

            rText.CipherText = rText.StrBuild.ToString();
            return rText;
        }
    }
}

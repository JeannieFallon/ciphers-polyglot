using System;
using System.Collections.Generic;
using System.Text;
using Ciphers.Models;

namespace Ciphers.Controllers
{
    public class VigenereController : BaseController
    {
        public VigenereText GetVigenereText(VigenereText vText)
        {
            List<int> shiftVals = CipherService.GetShiftVals(vText.KeyWord);
            int i = 0;

            while (i < vText.PlainText.Length)
            {
                for (int j = 0; j < shiftVals.Count; j++)
                {   
                    if (i >= vText.PlainText.Length)
                    {
                        break;
                    }
                    else
                    {
                        vText.StrBuild.Append(CipherService.GetCipherLetter(
                                                                vText.PlainText[i], 
                                                                shiftVals[j]));
                    }

                    i++;
                }
            }

            vText.CipherText = vText.StrBuild.ToString();
            return vText;
        }
    }
}

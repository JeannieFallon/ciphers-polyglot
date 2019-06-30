package com.metatarsal.primavera.controllers;

import com.metatarsal.primavera.constants.PrimaveraConstants;
import com.metatarsal.primavera.enums.Context;
import com.metatarsal.primavera.models.PrimaveraViewModel;
import com.metatarsal.primavera.models.TextDTO;
import com.metatarsal.primavera.services.CipherServiceImpl;
import com.metatarsal.primavera.services.PrimaveraServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("vigenere")
public class VigenereController {

    @Autowired
    PrimaveraServiceImpl primaService;

    @Autowired
    CipherServiceImpl cipherService;

    @RequestMapping(value = "")
    public String index(HttpSession session, Model model) {
        // clear & update viewmodel
        session.setAttribute(PrimaveraConstants.PRIMA_VM, null);
        PrimaveraViewModel primaVM = primaService.getPrimaVM(Context.VIGENERE);
        session.setAttribute(PrimaveraConstants.PRIMA_VM, primaVM);
        model.addAttribute(PrimaveraConstants.PRIMA_VM, primaVM);

        return "vigenere/index";
    }

    @RequestMapping(value = "cipher", method = RequestMethod.POST)
    public String getVigenereCipher(HttpSession session, Model model, HttpServletRequest request) {
        // pull plaintext and key from request
        String plaintext = request.getParameter(PrimaveraConstants.PLAINTEXT);
        String key = request.getParameter(PrimaveraConstants.KEY);

        // get ciphertext
        TextDTO text = new TextDTO(plaintext, key);
        text = cipherService.getMultiShiftCipher(text);

        //update viewmodel
        PrimaveraViewModel primaVM = (PrimaveraViewModel) session.getAttribute(PrimaveraConstants.PRIMA_VM);
        if (primaVM == null) { primaVM = primaService.getPrimaVM(Context.VIGENERE); }
        primaVM.setText(text);
        model.addAttribute(PrimaveraConstants.PRIMA_VM, primaVM);

        return "shared/cipher";
    }
}

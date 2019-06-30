package com.metatarsal.primavera.controllers;

import com.metatarsal.primavera.constants.CipherConstants;
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
@RequestMapping("rot13")
public class Rot13Controller {

    @Autowired
    private PrimaveraServiceImpl primaService;

    @Autowired
    private CipherServiceImpl cipherService;

    @RequestMapping(value = "")
    public String index(HttpSession session, Model model) {
        // clear & update viewmodel
        session.setAttribute(PrimaveraConstants.PRIMA_VM, null);
        PrimaveraViewModel primaVM = primaService.getPrimaVM(Context.ROT13);
        session.setAttribute(PrimaveraConstants.PRIMA_VM, primaVM);
        model.addAttribute(PrimaveraConstants.PRIMA_VM, primaVM);

        return "rot13/index";
    }

    @RequestMapping(value = "cipher", method = RequestMethod.POST)
    public String getRot13Cipher(HttpSession session, Model model, HttpServletRequest request) {
        // get ciphertext from input plaintext
        TextDTO text = new TextDTO(request.getParameter(PrimaveraConstants.PLAINTEXT), CipherConstants.ROT13_SHIFT_VAL);
        text = cipherService.getSingleShiftCipher(text);
        // update viewmodel
        PrimaveraViewModel primaVM = (PrimaveraViewModel) session.getAttribute(PrimaveraConstants.PRIMA_VM);
        if (primaVM == null) { primaVM = primaService.getPrimaVM(Context.ROT13); } //TODO how to do null coalescing in java?
        primaVM.setText(text);
        model.addAttribute(PrimaveraConstants.PRIMA_VM, primaVM);

        return "shared/cipher";
    }
}

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
@RequestMapping("caesar")
public class CaesarController {

    @Autowired
    private PrimaveraServiceImpl primaService;

    @Autowired
    private CipherServiceImpl cipherService;

    @RequestMapping(value ="")
    public String index(HttpSession session, Model model) {
        // clear & update viewmodel
        session.setAttribute(PrimaveraConstants.PRIMA_VM, null);
        PrimaveraViewModel primaVM = primaService.getPrimaVM(Context.CAESAR);
        session.setAttribute(PrimaveraConstants.PRIMA_VM, primaVM);
        model.addAttribute(PrimaveraConstants.PRIMA_VM, primaVM);

        return "caesar/index";
    }

    @RequestMapping(value = "cipher", method = RequestMethod.POST)
    public String getRot13Cipher(HttpSession session, Model model, HttpServletRequest request) {
        // pull plaintext and shiftval from request
        String plaintext = request.getParameter(PrimaveraConstants.PLAINTEXT);
        //TODO validation
        int shiftval = Integer.parseInt(request.getParameter(PrimaveraConstants.SHIFTVAL));

        // get ciphertext
        TextDTO text = new TextDTO(plaintext, shiftval);
        text = cipherService.getSingleShiftCipher(text);

        // update viewmodel
        PrimaveraViewModel primaVM = (PrimaveraViewModel) session.getAttribute(PrimaveraConstants.PRIMA_VM);
        if (primaVM == null) { primaVM = primaService.getPrimaVM(Context.CAESAR); } //TODO how to do null coalescing in java?
        primaVM.setText(text);
        model.addAttribute(PrimaveraConstants.PRIMA_VM, primaVM);

        return "shared/cipher";
    }
}

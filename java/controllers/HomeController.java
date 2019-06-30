package com.metatarsal.primavera.controllers;

import com.metatarsal.primavera.constants.PrimaveraConstants;
import com.metatarsal.primavera.enums.Context;
import com.metatarsal.primavera.models.PrimaveraViewModel;
import com.metatarsal.primavera.services.PrimaveraServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    private PrimaveraServiceImpl primaService;

    @RequestMapping(value = "")
    public String index(Model model) {
        // no need to keep home viewmodel in session
        PrimaveraViewModel primaVM = primaService.getPrimaVM(Context.HOME);
        model.addAttribute(PrimaveraConstants.PRIMA_VM, primaVM);

        return "home/index";
    }
}

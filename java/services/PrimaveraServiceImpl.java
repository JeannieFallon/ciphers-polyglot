package com.metatarsal.primavera.services;

import com.metatarsal.primavera.constants.PrimaveraConstants;
import com.metatarsal.primavera.enums.Context;
import com.metatarsal.primavera.enums.InstructionKeys;
import com.metatarsal.primavera.models.PrimaveraViewModel;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PrimaveraServiceImpl implements PrimaveraService {

    @Override
    public PrimaveraViewModel getPrimaVM(Context context) {
        PrimaveraViewModel primaVM = new PrimaveraViewModel();

        // instructions & shared fields
        primaVM = loadInstructions(primaVM);
        primaVM.setPlainLabel(PrimaveraConstants.PLAIN_LABEL);

        // context specific fields
        switch (context) {
            case HOME:
                primaVM = getHomeFields(primaVM);
                break;
            case ROT13:
                primaVM = getRot13Fields(primaVM);
                break;
            case CAESAR:
                primaVM = getCaesarFields(primaVM);
                break;
            case VIGENERE:
                primaVM = getVigenereFields(primaVM);
                break;
            default:
                break;
        }

        return primaVM;
    }

    @Override
    public PrimaveraViewModel loadInstructions(PrimaveraViewModel primaVM) {
        HashMap<InstructionKeys, String> instructions = new HashMap<>();
        instructions.put(InstructionKeys.CHOOSE_CIPHER, PrimaveraConstants.CHOOSE_CIPHER);
        instructions.put(InstructionKeys.ENTER_PLAINTEXT, PrimaveraConstants.ENTER_PLAINTEXT);
        instructions.put(InstructionKeys.ENTER_SHIFTVAL, PrimaveraConstants.ENTER_SHIFTVAL);
        instructions.put(InstructionKeys.ENTER_KEY, PrimaveraConstants.ENTER_KEY);
        primaVM.setInstructions(instructions);
        return primaVM;
    }

    @Override
    public PrimaveraViewModel getHomeFields(PrimaveraViewModel primaVM) {
        primaVM.setTitle(PrimaveraConstants.HOME_TITLE);
        return primaVM;
    }

    @Override
    public PrimaveraViewModel getRot13Fields(PrimaveraViewModel primaVM) {
        primaVM.setTitle(PrimaveraConstants.ROT13_TITLE);
        primaVM.setCipherLabel(PrimaveraConstants.ROT13 + PrimaveraConstants.CIPHER_LABEL);
        return primaVM;
    }

    @Override
    public PrimaveraViewModel getCaesarFields(PrimaveraViewModel primaVM) {
        primaVM.setTitle(PrimaveraConstants.CAESAR_TITLE);
        primaVM.setCipherLabel(PrimaveraConstants.CAESAR + PrimaveraConstants.CIPHER_LABEL);
        return primaVM;
    }

    @Override
    public PrimaveraViewModel getVigenereFields(PrimaveraViewModel primaVM) {
        primaVM.setTitle(PrimaveraConstants.VIGENERE_TITLE);
        primaVM.setCipherLabel(PrimaveraConstants.VIGENERE + PrimaveraConstants.CIPHER_LABEL);
        return primaVM;
    }
}

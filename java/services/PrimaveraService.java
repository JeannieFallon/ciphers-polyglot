package com.metatarsal.primavera.services;

import com.metatarsal.primavera.enums.Context;
import com.metatarsal.primavera.models.PrimaveraViewModel;
import org.springframework.stereotype.Service;

/*
 * Service interface for Primavera viewmodel methods
 * */
@Service
public interface PrimaveraService {
    PrimaveraViewModel getPrimaVM(Context context);
    PrimaveraViewModel loadInstructions(PrimaveraViewModel primaVM);
    PrimaveraViewModel getHomeFields(PrimaveraViewModel primaVM);
    PrimaveraViewModel getRot13Fields(PrimaveraViewModel primaVM);
    PrimaveraViewModel getCaesarFields(PrimaveraViewModel primaVM);
    PrimaveraViewModel getVigenereFields(PrimaveraViewModel primaVM);
}

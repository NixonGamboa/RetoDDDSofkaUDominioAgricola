package com.co.gamboatech.domain.potrero.commands;

import co.com.sofka.domain.generic.Command;
import com.co.gamboatech.domain.potrero.values.Longitud;
import com.co.gamboatech.domain.potrero.values.PotreroId;

public class AmpliarCerca implements Command {
    private PotreroId potreroId;
    private Longitud longitud;

    public AmpliarCerca(PotreroId potreroId, Longitud longitud) {
        this.potreroId = potreroId;
        this.longitud = longitud;
    }

    public Longitud longitud() {
        return longitud;
    }

    public PotreroId potreroId() {
        return potreroId;
    }
}

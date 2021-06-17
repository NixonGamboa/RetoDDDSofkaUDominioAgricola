package com.co.gamboatech.potrero.commands;

import co.com.sofka.domain.generic.Command;
import com.co.gamboatech.potrero.values.Longitud;
import com.co.gamboatech.potrero.values.PotreroId;

public class AsociarCerca implements Command {
    private PotreroId potreroId;
    private Longitud longitud;

    public AsociarCerca(PotreroId potreroId, Longitud longitud) {
        this.potreroId = potreroId;
        this.longitud = longitud;
    }

    public PotreroId potreroId() {
        return potreroId;
    }

    public Longitud longitud() {
        return longitud;
    }
}

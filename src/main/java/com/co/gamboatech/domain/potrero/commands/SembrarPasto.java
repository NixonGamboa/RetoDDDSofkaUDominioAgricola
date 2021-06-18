package com.co.gamboatech.domain.potrero.commands;

import co.com.sofka.domain.generic.Command;
import com.co.gamboatech.domain.potrero.values.Densidad;
import com.co.gamboatech.domain.potrero.values.PotreroId;

public class SembrarPasto implements Command {
    private PotreroId potreroId;
    private Densidad densidad;

    public SembrarPasto( PotreroId potreroId, Densidad densidad) {
        this.potreroId = potreroId;
        this.densidad = densidad;
    }

    public Densidad densidad() {
        return densidad;
    }

    public PotreroId potreroId() {
        return potreroId;
    }
}

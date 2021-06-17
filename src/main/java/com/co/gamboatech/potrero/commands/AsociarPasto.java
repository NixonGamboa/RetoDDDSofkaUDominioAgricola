package com.co.gamboatech.potrero.commands;

import co.com.sofka.domain.generic.Command;
import com.co.gamboatech.potrero.values.Densidad;
import com.co.gamboatech.potrero.values.PastoId;
import com.co.gamboatech.potrero.values.PotreroId;

public class AsociarPasto implements Command {
    private final PotreroId potreroId;
    private final Densidad densidad;

    public AsociarPasto(PotreroId potreroId, Densidad densidad) {
        this.potreroId = potreroId;
        this.densidad = densidad;
    }

    public PotreroId potreroId() {
        return potreroId;
    }

    public Densidad getDensidad() {
        return densidad;
    }
}

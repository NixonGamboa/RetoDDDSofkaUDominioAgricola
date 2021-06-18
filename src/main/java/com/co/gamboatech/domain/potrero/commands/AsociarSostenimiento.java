package com.co.gamboatech.domain.potrero.commands;

import co.com.sofka.domain.generic.Command;
import com.co.gamboatech.domain.potrero.values.PotreroId;
import com.co.gamboatech.domain.potrero.values.Regado;

public class AsociarSostenimiento implements Command {
    private PotreroId potreroId;
    private Regado regado;

    public AsociarSostenimiento(PotreroId potreroId, Regado regado) {
        this.potreroId = potreroId;
        this.regado = regado;
    }

    public PotreroId potreroId() {
        return potreroId;
    }

    public Regado regado() {
        return regado;
    }
}

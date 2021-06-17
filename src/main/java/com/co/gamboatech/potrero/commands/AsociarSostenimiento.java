package com.co.gamboatech.potrero.commands;

import co.com.sofka.domain.generic.Command;
import com.co.gamboatech.potrero.values.PotreroId;
import com.co.gamboatech.potrero.values.Regado;
import com.co.gamboatech.potrero.values.SostenimientoId;

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

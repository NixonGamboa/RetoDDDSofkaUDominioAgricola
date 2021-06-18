package com.co.gamboatech.domain.potrero.events;

import com.co.gamboatech.domain.potrero.values.Regado;

public class SostenimientoRegado extends co.com.sofka.domain.generic.DomainEvent {
    private Regado regado;
    public SostenimientoRegado(Regado regado) {
        super("gamboatech.potrero.sostenimientoregado");
        this.regado = regado;
    }

    public Regado regado() {
        return regado;
    }
}

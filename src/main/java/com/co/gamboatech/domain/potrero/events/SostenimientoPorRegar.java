package com.co.gamboatech.domain.potrero.events;

import com.co.gamboatech.domain.potrero.values.Regado;

public class SostenimientoPorRegar extends co.com.sofka.domain.generic.DomainEvent {
    private Regado regado;

    public SostenimientoPorRegar(Regado regado) {
        super("gamboatech.potrero.sostenimientoporregar");
        this.regado = regado;
    }
    public Regado regado() {
        return regado;
    }
}

package com.co.gamboatech.domain.potrero.events;

import com.co.gamboatech.domain.potrero.values.Regado;
import com.co.gamboatech.domain.potrero.values.SostenimientoId;

public class SostenimientoAsociado extends co.com.sofka.domain.generic.DomainEvent {
    private SostenimientoId sostenimientoId;
    private Regado regado;

    public SostenimientoAsociado(SostenimientoId sostenimientoId, Regado regado) {
        super("gamboatech.potrero.sostenimientoasociado");
        this.sostenimientoId = sostenimientoId;
        this.regado = regado;
    }

    public SostenimientoId sostenimientoId() {
        return sostenimientoId;
    }

    public Regado regado() {
        return regado;
    }
}

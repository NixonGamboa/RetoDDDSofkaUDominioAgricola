package com.co.gamboatech.potrero.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.co.gamboatech.potrero.values.Densidad;
import com.co.gamboatech.potrero.values.PastoId;

public class PastoAsociado extends DomainEvent {
    private PastoId pastoId;
    private Densidad densidad;

    public PastoAsociado( PastoId pastoId, Densidad densidad) {
        super("gamboatech.potrero.pastoasociado");
        this.pastoId = pastoId;
        this.densidad = densidad;
    }

    public PastoId pastoId() {
        return pastoId;
    }

    public Densidad densidad() {
        return densidad;
    }
}

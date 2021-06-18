package com.co.gamboatech.domain.potrero.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.co.gamboatech.domain.potrero.values.Densidad;

public class PastoSembrado extends DomainEvent {
    private Densidad densidad;

    public PastoSembrado( Densidad densidad) {
        super("gamboatech.potrero.pastosembrado");
        this.densidad = densidad;
    }

    public Densidad densidad() {
        return densidad;
    }
}

package com.co.gamboatech.domain.potrero.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.co.gamboatech.domain.potrero.values.CercaId;
import com.co.gamboatech.domain.potrero.values.Longitud;

public class CercaAsociada extends DomainEvent {
    private CercaId cercaId;
    private Longitud longitud;

    public CercaAsociada(CercaId cercaId, Longitud longitud) {
        super("gamboatech.potrero.cercaasociada");
        this.cercaId = cercaId;
        this.longitud = longitud;
    }

    public CercaId cercaId() {
        return cercaId;
    }

    public Longitud longitud() {
        return longitud;
    }
}

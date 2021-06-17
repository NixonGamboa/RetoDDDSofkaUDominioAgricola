package com.co.gamboatech.potrero.events;

import com.co.gamboatech.potrero.values.CercaId;
import com.co.gamboatech.potrero.values.Longitud;

public class CercaAsociada extends co.com.sofka.domain.generic.DomainEvent {
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

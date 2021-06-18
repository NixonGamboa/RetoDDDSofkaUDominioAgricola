package com.co.gamboatech.domain.potrero.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.co.gamboatech.domain.potrero.values.Longitud;

public class CercaAmpliada extends DomainEvent {
    private Longitud longitud;

    public CercaAmpliada( Longitud longitud) {
        super("gamboatech.potrero.cercaampliada");
        this.longitud = longitud;
    }

    public Longitud longitud() {
        return longitud;
    }

}

package com.co.gamboatech.potrero.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.co.gamboatech.potrero.values.Area;
import com.co.gamboatech.potrero.values.Longitud;

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

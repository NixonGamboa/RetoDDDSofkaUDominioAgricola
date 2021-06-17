package com.co.gamboatech.potrero.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.co.gamboatech.potrero.values.Area;
import com.co.gamboatech.potrero.values.Longitud;

public class CercaAmpliada extends DomainEvent {
    private Longitud longitud;
    private Area area;

    public CercaAmpliada( Longitud longitud, Area area) {
        super("gamboatech.potrero.cercaampliada");
        this.longitud = longitud;
        this.area = area;
    }

    public Longitud longitud() {
        return longitud;
    }

    public Area area() {
        return area;
    }
}

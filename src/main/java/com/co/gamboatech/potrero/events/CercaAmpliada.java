package com.co.gamboatech.potrero.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.co.gamboatech.potrero.values.Area;
import com.co.gamboatech.potrero.values.Longitud;

public class CercaAmpliada extends DomainEvent {
    public CercaAmpliada(Longitud longitud, Area area) {
        super();
    }
}

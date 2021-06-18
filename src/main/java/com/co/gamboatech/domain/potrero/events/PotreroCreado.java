package com.co.gamboatech.domain.potrero.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.co.gamboatech.domain.potrero.values.Area;

public class PotreroCreado extends DomainEvent {

    private Area area;

    public PotreroCreado(Area area) {
        super("gamboatech.potrero.potrerocreado");
        this.area = area;
    }

    public Area area() {
        return area;
    }

}

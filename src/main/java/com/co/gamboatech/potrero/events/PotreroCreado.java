package com.co.gamboatech.potrero.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.co.gamboatech.potrero.entities.Cerca;
import com.co.gamboatech.potrero.entities.Pasto;
import com.co.gamboatech.potrero.entities.Sostenimiento;
import com.co.gamboatech.potrero.values.Area;

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

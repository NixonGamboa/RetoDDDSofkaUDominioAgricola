package com.co.gamboatech.potrero.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.co.gamboatech.potrero.values.Area;

public class AreaActualizada extends DomainEvent {
    private Area area;

    public AreaActualizada( Area area) {
        super("gamboatech.potrero.areaactualizada");
        this.area = area;
    }

    public Area area() {
        return area;
    }
}

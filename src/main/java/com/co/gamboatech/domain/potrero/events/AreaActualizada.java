package com.co.gamboatech.domain.potrero.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.co.gamboatech.domain.potrero.values.Area;

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

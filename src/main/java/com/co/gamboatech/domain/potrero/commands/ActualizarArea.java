package com.co.gamboatech.domain.potrero.commands;

import co.com.sofka.domain.generic.Command;
import com.co.gamboatech.domain.potrero.values.Area;
import com.co.gamboatech.domain.potrero.values.PotreroId;

public class ActualizarArea implements Command {
    private PotreroId potreroId;
    private Area area;

    public ActualizarArea(PotreroId potreroId, Area area) {
        this.potreroId = potreroId;
        this.area = area;
    }

    public Area area() {
        return area;
    }

    public PotreroId potreroId() {
        return potreroId;
    }
}

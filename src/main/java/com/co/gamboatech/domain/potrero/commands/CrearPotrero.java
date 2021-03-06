package com.co.gamboatech.domain.potrero.commands;

import co.com.sofka.domain.generic.Command;
import com.co.gamboatech.domain.potrero.values.Area;
import com.co.gamboatech.domain.potrero.values.PotreroId;

public class CrearPotrero implements Command {
    private PotreroId potreroId;
    private Area area;

    public CrearPotrero(PotreroId potreroId, Area area) {
        this.area = area;
        this.potreroId = potreroId;
    }

    public Area area() {
        return area;
    }
    public PotreroId potreroId() {
        return potreroId;
    }
}

package com.co.gamboatech.domain.potrero.commands;

import co.com.sofka.domain.generic.Command;
import com.co.gamboatech.domain.potrero.values.Area;
import com.co.gamboatech.domain.potrero.values.PotreroId;

public class PorRegarSostenimiento implements Command {
    private PotreroId potreroId;

    public PorRegarSostenimiento(PotreroId potreroId) {
        this.potreroId = potreroId;
    }


    public PotreroId potreroId() {
        return potreroId;
    }
}

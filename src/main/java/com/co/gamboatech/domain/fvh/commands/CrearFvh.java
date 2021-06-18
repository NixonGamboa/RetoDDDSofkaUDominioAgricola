package com.co.gamboatech.domain.fvh.commands;

import co.com.sofka.domain.generic.Command;
import com.co.gamboatech.domain.fvh.values.FvhId;
import com.co.gamboatech.domain.potrero.values.PotreroId;

public class CrearFvh implements Command {
    private FvhId fvhId;
    private PotreroId potreroId;

    public CrearFvh(FvhId fvhId, PotreroId potreroId) {
        this.fvhId=fvhId;
        this.potreroId=potreroId;
    }

    public FvhId fvhId() {
        return fvhId;
    }

    public PotreroId potreroId() {
        return potreroId;
    }
}

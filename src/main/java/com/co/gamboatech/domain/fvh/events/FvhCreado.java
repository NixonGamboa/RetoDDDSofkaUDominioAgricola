package com.co.gamboatech.domain.fvh.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.co.gamboatech.domain.potrero.values.PotreroId;

public class FvhCreado extends DomainEvent {
    private PotreroId potreroId;
    public FvhCreado(PotreroId potreroId) {
        super("gamboatech.fvh.fvhcreado");
        this.potreroId=potreroId;
    }

    public PotreroId potreroId() {
        return potreroId;
    }
}

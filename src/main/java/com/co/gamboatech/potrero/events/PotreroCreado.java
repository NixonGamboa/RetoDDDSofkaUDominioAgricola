package com.co.gamboatech.potrero.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.co.gamboatech.potrero.entities.Cerca;
import com.co.gamboatech.potrero.entities.Pasto;

public class PotreroCreado extends DomainEvent {
    private Pasto pasto;
    private Cerca cerca;

    public PotreroCreado(Pasto pasto, Cerca cerca) {
        super("gamboatech.potrero.potrerocreado");
        this.pasto = pasto;
        this.cerca = cerca;
    }

    public Pasto pasto() {
        return pasto;
    }

    public Cerca cerca() {
        return cerca;
    }
}

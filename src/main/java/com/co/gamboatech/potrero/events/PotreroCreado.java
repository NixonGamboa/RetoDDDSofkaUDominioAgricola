package com.co.gamboatech.potrero.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.co.gamboatech.potrero.entities.Cerca;
import com.co.gamboatech.potrero.entities.Pasto;
import com.co.gamboatech.potrero.entities.Sostenimiento;

public class PotreroCreado extends DomainEvent {
    private Pasto pasto;
    private Cerca cerca;
    private Sostenimiento sostenimiento;

    public PotreroCreado(Pasto pasto, Cerca cerca, Sostenimiento sostenimiento) {
        super("gamboatech.potrero.potrerocreado");
        this.pasto = pasto;
        this.cerca = cerca;
        this.sostenimiento = sostenimiento;
    }

    public Pasto pasto() {
        return pasto;
    }

    public Cerca cerca() {
        return cerca;
    }

    public Sostenimiento sostenimiento() {
        return sostenimiento;
    }
}

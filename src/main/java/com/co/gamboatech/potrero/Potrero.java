package com.co.gamboatech.potrero;

import co.com.sofka.domain.generic.AggregateEvent;
import com.co.gamboatech.potrero.entities.Cerca;
import com.co.gamboatech.potrero.entities.Pasto;
import com.co.gamboatech.potrero.entities.Sostenimiento;
import com.co.gamboatech.potrero.values.Carga;
import com.co.gamboatech.potrero.values.PotreroId;

public class Potrero extends AggregateEvent<PotreroId> {
    protected Pasto pasto;
    protected Cerca cerca;
    protected Sostenimiento sostenimiento;
    protected Carga carga;

    public Potrero(PotreroId entityId, Pasto pasto, Cerca cerca) {
        super(entityId);
        this.pasto = pasto;
        this.cerca = cerca;
    }


}

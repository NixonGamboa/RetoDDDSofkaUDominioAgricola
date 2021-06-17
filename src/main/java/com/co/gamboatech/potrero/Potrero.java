package com.co.gamboatech.potrero;

import co.com.sofka.domain.generic.AggregateEvent;
import com.co.gamboatech.potrero.entities.Cerca;
import com.co.gamboatech.potrero.entities.Pasto;
import com.co.gamboatech.potrero.entities.Sostenimiento;
import com.co.gamboatech.potrero.events.PotreroCreado;
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
        appendChange(new PotreroCreado(pasto,cerca)).apply();
    }

    public void actualizarCarga(){

    }
    public void sembrarPasto(){

    }
    public void regarSostenimiento(){

    }
    public void desmalezarSostenimiento(){

    }
    public void fertilizarSostenimiento(){

    }
    public void porRegarSostenimiento(){

    }
    public void porDesmalezarSostenimiento(){

    }
    public void porFertilizarSostenimiento(){

    }
    public void ampliarCerca(){

    }
    public void registrarDanioCerca(){

    }
    public void repararCerca(){

    }



}

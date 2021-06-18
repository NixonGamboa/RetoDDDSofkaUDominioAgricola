package com.co.gamboatech.domain.potrero.entities;

import co.com.sofka.domain.generic.Entity;
import com.co.gamboatech.domain.potrero.values.Regado;
import com.co.gamboatech.domain.potrero.values.SostenimientoId;

public class Sostenimiento extends Entity<SostenimientoId> {
    private Regado regado;

    public Sostenimiento(SostenimientoId entityId, Regado regado) {
        super(entityId);
        this.regado = regado;
    }

    public void regar(){
        this.regado = Regado.regar();
    }
    public void porRegar(){
        this.regado = Regado.porRegar();
    }

    public Regado regado() {
        return regado;
    }

}

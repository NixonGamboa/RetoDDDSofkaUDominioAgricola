package com.co.gamboatech.potrero.entities;

import co.com.sofka.domain.generic.Entity;
import com.co.gamboatech.potrero.values.Regado;
import com.co.gamboatech.potrero.values.SostenimientoId;

public class Sostenimiento extends Entity<SostenimientoId> {
    private Regado regado;

    public Sostenimiento(SostenimientoId entityId) {
        super(entityId);
        this.regado = Regado.regar();
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

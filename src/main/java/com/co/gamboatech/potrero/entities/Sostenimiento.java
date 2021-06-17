package com.co.gamboatech.potrero.entities;

import co.com.sofka.domain.generic.Entity;
import com.co.gamboatech.potrero.values.Desmalezado;
import com.co.gamboatech.potrero.values.Fertilizado;
import com.co.gamboatech.potrero.values.Regado;
import com.co.gamboatech.potrero.values.SostenimientoId;

public class Sostenimiento extends Entity<SostenimientoId> {
    private Regado regado;
    private Desmalezado desmalezado;
    private Fertilizado fertilizado;

    public Sostenimiento(SostenimientoId entityId) {
        super(entityId);
        this.regado = Regado.regar();
        this.desmalezado = Desmalezado.desmalezar();
        this.fertilizado = Fertilizado.fertilizar();
    }

    public void regar(){
        this.regado = Regado.regar();
    }
    public void porRegar(){
        this.regado = Regado.porRegar();
    }
    public void desmalezar(){
        this.desmalezado = Desmalezado.desmalezar();
    }
    public void porDesmalezar(){
        this.desmalezado = Desmalezado.porDesmalezar();
    }
    public void fertilizar(){
        this.fertilizado = Fertilizado.fertilizar();
    }
    public void porFertilizar(){
        this.fertilizado = Fertilizado.porFertilizar();
    }

    public Fertilizado fertilizado() {
        return fertilizado;
    }
}

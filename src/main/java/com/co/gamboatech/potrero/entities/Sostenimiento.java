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

    public Sostenimiento(SostenimientoId entityId, Regado regado, Desmalezado desmalezado, Fertilizado fertilizado) {
        super(entityId);
        this.regado = regado;
        this.desmalezado = desmalezado;
        this.fertilizado = fertilizado;
    }
}

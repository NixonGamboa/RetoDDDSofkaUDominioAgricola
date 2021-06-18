package com.co.gamboatech.domain.potrero.entities;

import co.com.sofka.domain.generic.Entity;
import com.co.gamboatech.domain.potrero.values.Densidad;
import com.co.gamboatech.domain.potrero.values.PastoId;

import java.util.Objects;

public class Pasto extends Entity<PastoId> {
   private Densidad densidad;

    public Pasto(PastoId entityId, Densidad densidad) {
        super(entityId);
        this.densidad=densidad;
    }
    private Pasto(){
        super(new PastoId());
    }
    public static Pasto of(){
        return new Pasto();
    }
    public void sembrar(Densidad densidad){
        this.densidad= Objects.requireNonNull(densidad);
    }
}

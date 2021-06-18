package com.co.gamboatech.domain.potrero.entities;

import co.com.sofka.domain.generic.Entity;
import com.co.gamboatech.domain.potrero.values.*;

import java.util.Objects;

public class Cerca extends Entity<CercaId> {
    private Longitud longitud;

    public Cerca(CercaId entityId, Longitud longitud) {
        super(entityId);
        this.longitud = longitud;
    }
    private Cerca(){
        super(new CercaId());
    }
    public static Cerca of(){
        return new Cerca();
    }
    public void ampliar(Longitud longitud){
        this.longitud= Objects.requireNonNull(longitud);
    }

}

package com.co.gamboatech.domain.fvh.entities;

import co.com.sofka.domain.generic.Entity;
import com.co.gamboatech.domain.fvh.values.BandejaId;
import com.co.gamboatech.domain.fvh.values.Etapa;
import com.co.gamboatech.domain.fvh.values.NutrienteId;
import com.co.gamboatech.domain.fvh.values.Riqueza;
import com.co.gamboatech.domain.potrero.values.PastoId;

import java.util.Objects;

public class Nutriente extends Entity<NutrienteId> {
    private Riqueza riqueza;

    public Nutriente(NutrienteId entityId, Riqueza riqueza) {
        super(entityId);
        this.riqueza=riqueza;
    }
    private Nutriente(){
        super(new NutrienteId());
    }
    public static Nutriente of(){
        return new Nutriente();
    }
    public void nutrir(Riqueza riqueza){
        this.riqueza= Objects.requireNonNull(riqueza);
    }

    public Riqueza riqueza() {
        return riqueza;
    }
}

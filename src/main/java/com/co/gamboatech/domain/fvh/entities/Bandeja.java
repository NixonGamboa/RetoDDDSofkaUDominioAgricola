package com.co.gamboatech.domain.fvh.entities;

import co.com.sofka.domain.generic.Entity;
import com.co.gamboatech.domain.fvh.values.BandejaId;
import com.co.gamboatech.domain.fvh.values.Etapa;
import com.co.gamboatech.domain.potrero.entities.Pasto;
import com.co.gamboatech.domain.potrero.values.Densidad;
import com.co.gamboatech.domain.potrero.values.PastoId;

import java.util.Objects;

public class Bandeja extends Entity {
    private Etapa etapa;

    public Bandeja(BandejaId entityId, Etapa etapa) {
        super(entityId);
        this.etapa=etapa;
    }
    private Bandeja(){
        super(new PastoId());
    }
    public static Bandeja of(){
        return new Bandeja();
    }
    public void cambiarEtapa(Etapa etapa){
        this.etapa= Objects.requireNonNull(etapa);
    }
}

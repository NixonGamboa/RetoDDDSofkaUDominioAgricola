package com.co.gamboatech.potrero.entities;

import co.com.sofka.domain.generic.Entity;
import com.co.gamboatech.potrero.values.*;

import java.util.Objects;

public class Cerca extends Entity<CercaId> {
    private TipoCerca tipoCerca;
    private Longitud longitud;
    private Estado estado;
    private Area area;

    public Cerca(CercaId entityId, TipoCerca tipoCerca, Longitud longitud, Area area) {
        super(entityId);
        this.tipoCerca = tipoCerca;
        this.longitud = longitud;
        this.area = area;
        this.estado = Estado.cercaNueva();
    }
    public void ampliar(Longitud longitud, Area area){
        this.longitud= Objects.requireNonNull(longitud);
        this.area= Objects.requireNonNull(area);
    }
    public void registrarDanio(){
        this.estado = estado.registrarDanio();
    }
    public void reparar(){
        this.estado = estado.reparar();
    }
}

package com.co.gamboatech.potrero.entities;

import co.com.sofka.domain.generic.Entity;
import com.co.gamboatech.potrero.values.*;

public class Cerca extends Entity<CercaId> {
    private TipoCerca tipoCerca;
    private Longitud longitud;
    private Estado estado;
    private Area area;

    public Cerca(CercaId entityId, TipoCerca tipoCerca, Longitud longitud, Estado estado, Area area) {
        super(entityId);
        this.tipoCerca = tipoCerca;
        this.longitud = longitud;
        this.estado = estado;
        this.area = area;
    }
}

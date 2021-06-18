package com.co.gamboatech.domain.fvh.entities;

import co.com.sofka.domain.generic.Entity;
import com.co.gamboatech.domain.fvh.values.ForrajeId;
import com.co.gamboatech.domain.fvh.values.Rociado;


public class Forraje extends Entity<ForrajeId> {
    private Rociado rociado;

    public Forraje(ForrajeId entityId, Rociado rociado) {
        super(entityId);
        this.rociado = rociado;
    }

    public void regar(){
        this.rociado = Rociado.rociar();
    }
    public void porRegar(){
        this.rociado = Rociado.porRociar();
    }

    public Rociado rociado() {
        return rociado;
    }
}

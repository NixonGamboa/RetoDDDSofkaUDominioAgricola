package com.co.gamboatech.domain.potrero.values;

import co.com.sofka.domain.generic.Identity;

public class SostenimientoId extends Identity {
    public SostenimientoId(){}

    private SostenimientoId(String id){
        super(id);
    }

    public static SostenimientoId of(String id){
        return new SostenimientoId(id);
    }
}

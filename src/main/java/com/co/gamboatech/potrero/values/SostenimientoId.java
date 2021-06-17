package com.co.gamboatech.potrero.values;

import co.com.sofka.domain.generic.Identity;

public class SostenimientoId extends Identity {
    public SostenimientoId(){}

    public static SostenimientoId of(String id){
        return new SostenimientoId(id);
    }
    private SostenimientoId(String id){
        super(id);
    }
}

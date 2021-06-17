package com.co.gamboatech.potrero.values;

import co.com.sofka.domain.generic.Identity;

public class PastoId extends Identity {
    public PastoId(){}

    public static PastoId of(String id){
        return new PastoId(id);
    }

    private PastoId(String id){
        super(id);
    }
}

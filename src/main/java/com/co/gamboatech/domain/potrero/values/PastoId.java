package com.co.gamboatech.domain.potrero.values;

import co.com.sofka.domain.generic.Identity;

public class PastoId extends Identity {
    public PastoId(){}

    private PastoId(String id){
        super(id);
    }

    public static PastoId of(String id){
        return new PastoId(id);
    }
}

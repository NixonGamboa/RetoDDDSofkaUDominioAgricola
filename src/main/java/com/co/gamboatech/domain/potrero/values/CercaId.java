package com.co.gamboatech.domain.potrero.values;

import co.com.sofka.domain.generic.Identity;

public class CercaId extends Identity {
    public CercaId(){}

    private CercaId(String id){
        super(id);
    }

    public static CercaId of(String id){
        return new CercaId(id);
    }
}

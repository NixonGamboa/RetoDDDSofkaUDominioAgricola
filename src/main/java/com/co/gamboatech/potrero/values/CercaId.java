package com.co.gamboatech.potrero.values;

import co.com.sofka.domain.generic.Identity;

public class CercaId extends Identity {
    public CercaId(){}

    public static CercaId of(String id){
        return new CercaId(id);
    }
    private CercaId(String id){
        super(id);
    }
}

package com.co.gamboatech.domain.fvh.values;

import co.com.sofka.domain.generic.Identity;

public class BandejaId extends Identity {
    public BandejaId(){}

    private BandejaId(String id){
        super(id);
    }

    public static BandejaId of(String id){
        return new BandejaId(id);
    }
}

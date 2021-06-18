package com.co.gamboatech.domain.fvh.values;

import co.com.sofka.domain.generic.Identity;

public class ForrajeId extends Identity {
    public ForrajeId(){}

    private ForrajeId(String id){
        super(id);
    }

    public static ForrajeId of(String id){
        return new ForrajeId(id);
    }
}

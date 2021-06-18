package com.co.gamboatech.domain.fvh.values;

import co.com.sofka.domain.generic.Identity;

public class NutrienteId extends Identity {
    public NutrienteId(){}

    private NutrienteId(String id){
        super(id);
    }

    public static NutrienteId of(String id){
        return new NutrienteId(id);
    }
}

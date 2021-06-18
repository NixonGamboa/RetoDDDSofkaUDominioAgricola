package com.co.gamboatech.domain.fvh.values;

import co.com.sofka.domain.generic.Identity;

public class FvhId extends Identity {
    public FvhId(){}

    private FvhId(String id){
        super(id);
    }

    public static FvhId of(String id){
        return new FvhId(id);
    }
}

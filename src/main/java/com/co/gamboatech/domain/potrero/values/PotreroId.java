package com.co.gamboatech.domain.potrero.values;

import co.com.sofka.domain.generic.Identity;

public class PotreroId extends Identity {
    public PotreroId(){}

    private PotreroId(String id){
        super(id);
    }

    public static PotreroId of(String id){
        return new PotreroId(id);
    }
}

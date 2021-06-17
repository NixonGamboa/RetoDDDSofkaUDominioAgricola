package com.co.gamboatech.potrero.values;

import co.com.sofka.domain.generic.Identity;

public class PotreroId extends Identity {
    public PotreroId(){}

    public static PotreroId of(String id){
        return new PotreroId(id);
    }
    private PotreroId(String id){
        super(id);
    }
}

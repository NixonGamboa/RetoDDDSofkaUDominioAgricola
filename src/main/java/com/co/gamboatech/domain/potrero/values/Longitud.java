package com.co.gamboatech.domain.potrero.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Longitud implements ValueObject<Integer> {
    private final Integer longitud;

    public Longitud(Integer longitud) {
        this.longitud = Objects.requireNonNull(longitud);
        if(this.longitud<0){
            throw new IllegalArgumentException("La longitud no puede ser menor que cero");
        }
    }

    @Override
    public Integer value() {
        return longitud;
    }
}

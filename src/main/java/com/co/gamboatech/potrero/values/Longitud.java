package com.co.gamboatech.potrero.values;

import co.com.sofka.domain.generic.ValueObject;

public class Longitud implements ValueObject<Integer> {
    private Integer longitud;

    public Longitud(Integer longitud) {
        this.longitud = longitud;
    }

    @Override
    public Integer value() {
        return longitud;
    }
}

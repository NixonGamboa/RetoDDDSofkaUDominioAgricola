package com.co.gamboatech.potrero.values;

import co.com.sofka.domain.generic.ValueObject;

public class Densidad implements ValueObject<Integer> {
    private Integer porcentaje;

    public Densidad(Integer porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public Integer value() {
        return porcentaje;
    }
}

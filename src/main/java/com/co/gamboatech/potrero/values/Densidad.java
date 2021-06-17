package com.co.gamboatech.potrero.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Densidad implements ValueObject<Integer> {
    private final Integer porcentaje;

    public Densidad(Integer porcentaje) {
        this.porcentaje = Objects.requireNonNull(porcentaje);
        if(this.porcentaje<0){
            throw new IllegalArgumentException("El porcentaje no puede ser menor de 0%");
        }
        if(this.porcentaje>100){
            throw new IllegalArgumentException("El porcentaje no puede ser mayor de 100%");
        }
    }

    @Override
    public Integer value() {
        return porcentaje;
    }
}

package com.co.gamboatech.potrero.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Area implements ValueObject<Integer> {
    private Integer area;

    public Area(Integer area) {
        this.area = Objects.requireNonNull(area);
        if(this.area<0){
            throw new IllegalArgumentException("El area no puede ser menor que cero");
        }
    }

    @Override
    public Integer value() {
        return area;
    }
}

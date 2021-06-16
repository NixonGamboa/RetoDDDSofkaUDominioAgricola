package com.co.gamboatech.potrero.values;

import co.com.sofka.domain.generic.ValueObject;

public class Area implements ValueObject<Integer> {
    private Integer area;

    public Area(Integer area) {
        this.area = area;
    }

    @Override
    public Integer value() {
        return area;
    }
}

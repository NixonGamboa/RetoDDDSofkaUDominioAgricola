package com.co.gamboatech.potrero.values;

import co.com.sofka.domain.generic.ValueObject;

public class Fertilizado implements ValueObject<Boolean> {
    private Boolean fertilizado;

    public Fertilizado(Boolean fertilizado) {
        this.fertilizado = fertilizado;
    }

    @Override
    public Boolean value() {
        return fertilizado;
    }
}

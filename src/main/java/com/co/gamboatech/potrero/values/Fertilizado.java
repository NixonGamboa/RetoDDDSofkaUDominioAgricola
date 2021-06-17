package com.co.gamboatech.potrero.values;

import co.com.sofka.domain.generic.ValueObject;

public class Fertilizado implements ValueObject<Boolean> {
    private Boolean fertilizado;

    public Fertilizado(Boolean fertilizado) {
        this.fertilizado = fertilizado;
    }

    public static Fertilizado fertilizar() {
        return new Fertilizado(true);
    }

    public static Fertilizado porFertilizar() {
        return new Fertilizado(false);
    }
    @Override
    public Boolean value() {
        return fertilizado;
    }
}

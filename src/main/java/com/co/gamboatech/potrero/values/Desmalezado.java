package com.co.gamboatech.potrero.values;

import co.com.sofka.domain.generic.ValueObject;

public class Desmalezado implements ValueObject<Boolean> {
    private Boolean desmalezado;

    public Desmalezado(Boolean desmalezado) {
        this.desmalezado = desmalezado;
    }

    public static Desmalezado desmalezar() {
        return new Desmalezado(true);
    }

    public static Desmalezado porDesmalezar() {
        return new Desmalezado(false);
    }

    @Override
    public Boolean value() {
        return desmalezado;
    }
}

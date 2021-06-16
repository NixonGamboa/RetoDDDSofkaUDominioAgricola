package com.co.gamboatech.potrero.values;

import co.com.sofka.domain.generic.ValueObject;

public class Desmalezado implements ValueObject<Boolean> {
    private Boolean desmalezado;

    public Desmalezado(Boolean desmalezado) {
        this.desmalezado = desmalezado;
    }

    @Override
    public Boolean value() {
        return desmalezado;
    }
}

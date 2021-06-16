package com.co.gamboatech.potrero.values;

import co.com.sofka.domain.generic.ValueObject;

public class Regado implements ValueObject<Boolean> {
    private Boolean regado;

    public Regado(Boolean regado) {
        this.regado = regado;
    }

    @Override
    public Boolean value() {
        return regado;
    }
}

package com.co.gamboatech.potrero.values;

import co.com.sofka.domain.generic.ValueObject;

public class Regado implements ValueObject<Boolean> {
    private final Boolean regado;

    public Regado(Boolean regado) {
        this.regado = regado;
    }

    public static Regado regar() {
        return new Regado(true);
    }
    public static Regado porRegar() {
        return new Regado(false);
    }

    @Override
    public Boolean value() {
        return regado;
    }
}

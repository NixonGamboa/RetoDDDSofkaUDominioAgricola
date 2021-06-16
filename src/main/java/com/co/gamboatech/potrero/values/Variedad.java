package com.co.gamboatech.potrero.values;

import co.com.sofka.domain.generic.ValueObject;

public class Variedad implements ValueObject<String> {
    private String variedad;

    public Variedad(String variedad) {
        this.variedad = variedad;
    }

    @Override
    public String value() {
        return variedad;
    }
}

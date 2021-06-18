package com.co.gamboatech.domain.fvh.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Etapa implements ValueObject<String> {
    private final String value;

    public Etapa(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()) throw new IllegalArgumentException("La etapa no puede estar en blanco");
        if(this.value.length()>10) throw new IllegalArgumentException("La etapa no debe tener mas de 10 caracteres");
    }

    @Override
    public String value() {
        return value;
    }
}

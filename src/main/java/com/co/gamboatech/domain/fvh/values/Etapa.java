package com.co.gamboatech.domain.fvh.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Etapa implements ValueObject<String> {
    private String etapa;

    public Etapa(String etapa) {
        this.etapa = Objects.requireNonNull(etapa);
        if(this.etapa.isBlank()) throw new IllegalArgumentException("La etapa no puede estar en blanco");
        if(this.etapa.length()>10) throw new IllegalArgumentException("La etapa no debe tener mas de 10 caracteres");
    }

    @Override
    public String value() {
        return etapa;
    }
}

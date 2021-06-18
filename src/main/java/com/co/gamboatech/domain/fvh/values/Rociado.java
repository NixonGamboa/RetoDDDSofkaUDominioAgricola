package com.co.gamboatech.domain.fvh.values;

import co.com.sofka.domain.generic.ValueObject;
import com.co.gamboatech.domain.potrero.values.Regado;

import java.util.Objects;

public class Rociado implements ValueObject<Boolean> {
    private final Boolean value;

    public Rociado(Boolean value) {
        this.value = Objects.requireNonNull(value);
    }

    public static Rociado rociar() {
        return new Rociado(true);
    }
    public static Rociado porRociar() {
        return new Rociado(false);
    }

    @Override
    public Boolean value() {
        return value;
    }
}

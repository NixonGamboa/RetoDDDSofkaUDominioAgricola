package com.co.gamboatech.potrero.values;

import co.com.sofka.domain.generic.ValueObject;

public class TipoCerca implements ValueObject<String> {
    private String tipoCerca;

    public TipoCerca(String tipoCerca) {
        this.tipoCerca = tipoCerca;
    }

    @Override
    public String value() {
        return tipoCerca;
    }
}

package com.co.gamboatech.potrero.values;

import co.com.sofka.domain.generic.ValueObject;

public class TipoPasto implements ValueObject<String> {
    private String tipoPasto;

    public TipoPasto(String tipoPasto) {
        this.tipoPasto = tipoPasto;
    }

    @Override
    public String value() {
        return tipoPasto;
    }
}

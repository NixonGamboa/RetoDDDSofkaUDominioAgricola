package com.co.gamboatech.potrero.values;

import co.com.sofka.domain.generic.ValueObject;

public class Carga implements ValueObject<Integer> {
    private Integer carga;

    public Carga(Integer carga) {
        this.carga = carga;
    }

    @Override
    public Integer value() {
        return carga;
    }
}

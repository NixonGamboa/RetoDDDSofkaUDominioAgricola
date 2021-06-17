package com.co.gamboatech.potrero.values;

import co.com.sofka.domain.generic.ValueObject;

public class Estado implements ValueObject<Boolean> {
    private Boolean estado;

    public Estado(Boolean estado) {
        this.estado = estado;
    }

    public static Estado cercaNueva(){
        return new Estado(true);
    }

    public Estado registrarDanio(){
        return new Estado(false);
    }

    public Estado reparar() {
        return new Estado(true);
    }

    @Override
    public Boolean value() {
        return estado;
    }
}

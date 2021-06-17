package com.co.gamboatech.potrero.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.co.gamboatech.potrero.values.Carga;

public class CargaActualizada extends DomainEvent {
    private Carga carga;

    public CargaActualizada( Carga carga) {
        super("gamboatech.potrero.cargaactualizada");
        this.carga = carga;
    }

    public Carga carga() {
        return carga;
    }
}

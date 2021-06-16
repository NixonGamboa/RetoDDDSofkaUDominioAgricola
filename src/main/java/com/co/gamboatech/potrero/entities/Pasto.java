package com.co.gamboatech.potrero.entities;

import co.com.sofka.domain.generic.Entity;
import com.co.gamboatech.potrero.values.Densidad;
import com.co.gamboatech.potrero.values.PastoId;
import com.co.gamboatech.potrero.values.TipoPasto;
import com.co.gamboatech.potrero.values.Variedad;

public class Pasto extends Entity<PastoId> {
    private TipoPasto tipoPasto;
    private Variedad variedad;
    private Densidad densidad;

    public Pasto(PastoId entityId, TipoPasto tipoPasto, Variedad variedad) {
        super(entityId);
        this.tipoPasto = tipoPasto;
        this.variedad = variedad;
    }
}

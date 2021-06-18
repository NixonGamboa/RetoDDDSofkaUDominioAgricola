package com.co.gamboatech.domain.potrero;

import co.com.sofka.domain.generic.EventChange;
import com.co.gamboatech.domain.potrero.entities.Pasto;
import com.co.gamboatech.domain.potrero.entities.Sostenimiento;
import com.co.gamboatech.domain.potrero.events.*;

import java.util.Objects;

public class PotreroChange extends EventChange {
    public PotreroChange(Potrero potrero) {
        apply((PotreroCreado event)->{
            potrero.area= event.area();
            potrero.sostenimiento=null;
            potrero.cerca=null;
            potrero.pasto=null;
        });
        apply((SostenimientoAsociado event)->{
            potrero.sostenimiento= new Sostenimiento(
                    event.sostenimientoId(),
                    event.regado());
        });
        apply((AreaActualizada event)->{
            potrero.area= event.area();
        });
        apply((CercaAmpliada event)->{
            var cerca = potrero.cerca;
            cerca.ampliar(event.longitud());
        });
        apply((PastoSembrado event)->{
            var pasto = potrero.pasto;
            if(Objects.isNull(pasto)){
                potrero.pasto=Pasto.of();
            }
            potrero.pasto.sembrar(event.densidad());
        });
        apply((SostenimientoPorRegar event)->{
            potrero.sostenimiento.porRegar();
        });
        apply((SostenimientoRegado event)->{
            var sostenimiento= potrero.sostenimiento;
            if(sostenimiento.regado().value()){
                throw new IllegalArgumentException("No debes regar un potrero ya regado");
            }
            sostenimiento.regar();
        });
    }
}

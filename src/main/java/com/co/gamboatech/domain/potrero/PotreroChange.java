package com.co.gamboatech.domain.potrero;

import co.com.sofka.domain.generic.EventChange;
import com.co.gamboatech.domain.potrero.events.*;

public class PotreroChange extends EventChange {
    public PotreroChange(Potrero potrero) {
        apply((PotreroCreado event)->{
            potrero.area= event.area();
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
            pasto.sembrar(event.densidad());
        });
        apply((SostenimientoPorRegar event)->{
            potrero.sostenimiento.porRegar();
        });
        apply((SostenimientoRegado event)->{
            var sostenimiento= potrero.sostenimiento;
            //Es correcta esta asignacion?
            if(sostenimiento.regado().value()){
                throw new IllegalArgumentException("No debes regar un potrero ya regado");
            }
            sostenimiento.regar();
        });
    }
}

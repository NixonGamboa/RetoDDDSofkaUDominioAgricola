package com.co.gamboatech.potrero;

import co.com.sofka.domain.generic.EventChange;
import com.co.gamboatech.potrero.entities.Sostenimiento;
import com.co.gamboatech.potrero.events.*;

import java.util.Objects;

public class PotreroChange extends EventChange {
    public PotreroChange(Potrero potrero) {
        apply((PotreroCreado event)->{
            potrero.pasto= event.pasto();
            potrero.cerca= event.cerca();
            potrero.sostenimiento= event.sostenimiento();
        });
        apply((CargaActualizada event)->{
            potrero.carga= event.carga();
        });
        apply((CercaAmpliada event)->{
            var cerca = potrero.cerca;
            cerca.ampliar(event.longitud(),event.area());
        });
        apply((CercaReparada event)->{
            potrero.cerca.reparar();
        });
        apply((DanioCercaRegistrado event)->{
            potrero.cerca.registrarDanio();
        });
        apply((PastoSembrado event)->{
            var pasto = potrero.pasto;
            pasto.sembrar(event.densidad());
        });
        apply((SostenimientoDesmalezado event)->{
            potrero.sostenimiento.desmalezar();
        });
        apply((SostenimientoFertilizado event)->{
            var sostenimiento= potrero.sostenimiento;
            if(sostenimiento.fertilizado().value()){
                throw new IllegalArgumentException("No debes fertilizar un potrero ya fertilizado");
            }
            sostenimiento.fertilizar();
        });
        apply((SostenimientoPorDesmalezar event)->{
            potrero.sostenimiento.porDesmalezar();
        });
        apply((SostenimientoPorFertilizar event)->{
            potrero.sostenimiento.porFertilizar();
        });
        apply((SostenimientoPorRegar event)->{
            potrero.sostenimiento.porRegar();
        });
        apply((SostenimientoRegado event)->{
            potrero.sostenimiento.regar();
        });
    }
}

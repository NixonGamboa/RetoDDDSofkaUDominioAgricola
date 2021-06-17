package com.co.gamboatech.potrero;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.co.gamboatech.potrero.entities.Cerca;
import com.co.gamboatech.potrero.entities.Pasto;
import com.co.gamboatech.potrero.entities.Sostenimiento;
import com.co.gamboatech.potrero.events.*;
import com.co.gamboatech.potrero.values.*;

import java.util.List;
import java.util.Objects;

public class Potrero extends AggregateEvent<PotreroId> {
    protected Pasto pasto;
    protected Cerca cerca;
    protected Sostenimiento sostenimiento;
    protected Area area;

    public static Potrero from (PotreroId potreroId, List<DomainEvent> events){
        var potrero = new Potrero(potreroId);
        events.forEach(potrero::applyEvent);
        return potrero;
    }

    private Potrero(PotreroId potreroId){
        super(potreroId);
        subscribe(new PotreroChange(this));
    }


    public Potrero(PotreroId entityId, Area area) {
        super(entityId);
        Objects.requireNonNull(area);
        appendChange(new PotreroCreado(area)).apply();
    }

    public void asociarPasto(PastoId pastoId,Densidad densidad){
        Objects.requireNonNull(pastoId);
        Objects.requireNonNull(densidad);
        appendChange(new PastoAsociado(pastoId,densidad)).apply();
    }
    public void asociarCerca(CercaId cercaId, Longitud longitud){
        Objects.requireNonNull(cercaId);
        Objects.requireNonNull(longitud);
        appendChange(new CercaAsociada(cercaId,longitud)).apply();
    }
    public void asociarSostenimiento(SostenimientoId sostenimientoId, Regado regado){
        Objects.requireNonNull(sostenimientoId);
        Objects.requireNonNull(regado);
        appendChange(new SostenimientoAsociado(sostenimientoId,regado)).apply();
    }

    public void actualizarArea(Area area){
        Objects.requireNonNull(area);
        appendChange(new AreaActualizada(area)).apply();
    }
    public void sembrarPasto(Densidad densidad){
        Objects.requireNonNull(densidad);
        appendChange(new PastoSembrado(densidad)).apply();
    }
    public void regarSostenimiento(){
        appendChange(new SostenimientoRegado()).apply();
    }
    public void porRegarSostenimiento(){
        appendChange(new SostenimientoPorRegar()).apply();
    }
    public void ampliarCerca(Longitud longitud){
        Objects.requireNonNull(longitud);
        appendChange(new CercaAmpliada(longitud)).apply();
    }


    public Pasto pasto() {
        return pasto;
    }

    public Cerca cerca() {
        return cerca;
    }

    public Sostenimiento sostenimiento() {
        return sostenimiento;
    }

    public Area area() {
        return area;
    }
}

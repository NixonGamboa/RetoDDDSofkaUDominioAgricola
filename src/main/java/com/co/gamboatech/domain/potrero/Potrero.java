package com.co.gamboatech.domain.potrero;

import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.co.gamboatech.domain.potrero.entities.Cerca;
import com.co.gamboatech.domain.potrero.entities.Pasto;
import com.co.gamboatech.domain.potrero.entities.Sostenimiento;
import com.co.gamboatech.domain.potrero.events.*;
import com.co.gamboatech.domain.potrero.values.*;

import java.util.List;
import java.util.Objects;

public class Potrero extends AggregateEvent<PotreroId> {
    protected Pasto pasto;
    protected Cerca cerca;
    protected Sostenimiento sostenimiento;
    protected Area area;

    private Potrero(PotreroId potreroId){
        super(potreroId);
        subscribe(new PotreroChange(this));
    }

    public static Potrero from (PotreroId potreroId, List<DomainEvent> events){
        var potrero = new Potrero(potreroId);
        events.forEach(potrero::applyEvent);
        return potrero;
    }


    public Potrero(PotreroId entityId, Area area) {
        super(Objects.requireNonNull(entityId));
        Objects.requireNonNull(area);
        subscribe(new PotreroChange(this));
        appendChange(new PotreroCreado(area)).apply();
    }

    public void asociarPasto(Densidad densidad){
        var pastoId = new PastoId();
        Objects.requireNonNull(pastoId);
        Objects.requireNonNull(densidad);
        appendChange(new PastoAsociado(pastoId,densidad)).apply();
    }
    public void asociarCerca( Longitud longitud){
        var cercaId = new CercaId();
        Objects.requireNonNull(cercaId);
        Objects.requireNonNull(longitud);
        appendChange(new CercaAsociada(cercaId,longitud)).apply();
    }
    public void asociarSostenimiento(Regado regado){
        var sostenimientoId = new SostenimientoId();
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
        appendChange(new SostenimientoRegado(Regado.regar())).apply();
    }
    public void porRegarSostenimiento(){
        appendChange(new SostenimientoPorRegar(Regado.porRegar())).apply();
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

package com.co.gamboatech.potrero;

import co.com.sofka.domain.generic.AggregateEvent;
import com.co.gamboatech.potrero.entities.Cerca;
import com.co.gamboatech.potrero.entities.Pasto;
import com.co.gamboatech.potrero.entities.Sostenimiento;
import com.co.gamboatech.potrero.events.*;
import com.co.gamboatech.potrero.values.*;

import java.util.Objects;

public class Potrero extends AggregateEvent<PotreroId> {
    protected Pasto pasto;
    protected Cerca cerca;
    protected Sostenimiento sostenimiento;
    protected Carga carga;

    public Potrero(PotreroId entityId, Pasto pasto, Cerca cerca) {
        super(entityId);
        Objects.requireNonNull(pasto);
        Objects.requireNonNull(cerca);
        this.pasto = pasto;
        this.cerca = cerca;
        appendChange(new PotreroCreado(pasto,cerca)).apply();
    }

    public void actualizarCarga(Carga carga){
        Objects.requireNonNull(carga);
        appendChange(new CargaActualizada(carga)).apply();
    }
    public void sembrarPasto(Densidad densidad){
        Objects.requireNonNull(densidad);
        appendChange(new PastoSembrado(densidad)).apply();
    }
    public void regarSostenimiento(){
        appendChange(new SostenimientoRegado()).apply();
    }
    public void desmalezarSostenimiento(){
        appendChange(new SostenimientoDesmalezado()).apply();
    }
    public void fertilizarSostenimiento(){
        appendChange(new SostenimientoFertilizado()).apply();
    }
    public void porRegarSostenimiento(){
        appendChange(new SostenimientoPorRegar()).apply();
    }
    public void porDesmalezarSostenimiento(){
        appendChange(new SostenimientoPorDesmalezar()).apply();
    }
    public void porFertilizarSostenimiento(){
        appendChange(new SostenimientoPorFertilizar()).apply();
    }
    public void ampliarCerca(Longitud longitud, Area area){
        Objects.requireNonNull(longitud);
        Objects.requireNonNull(area);
        appendChange(new CercaAmpliada(longitud,area)).apply();
    }
    public void registrarDanioCerca(){
        appendChange(new DanioCercaRegistrado()).apply();
    }
    public void repararCerca(){
        appendChange(new CercaReparada()).apply();
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

    public Carga carga() {
        return carga;
    }
}

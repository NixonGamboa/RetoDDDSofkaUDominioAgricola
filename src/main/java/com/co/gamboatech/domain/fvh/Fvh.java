package com.co.gamboatech.domain.fvh;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.co.gamboatech.domain.fvh.entities.Bandeja;
import com.co.gamboatech.domain.fvh.entities.Forraje;
import com.co.gamboatech.domain.fvh.entities.Nutriente;
import com.co.gamboatech.domain.fvh.values.FvhId;
import com.co.gamboatech.domain.potrero.values.PotreroId;
import com.co.gamboatech.domain.fvh.events.FvhCreado;

import java.util.List;
import java.util.Objects;

public class Fvh extends AggregateEvent<FvhId> {
    protected PotreroId potreroId;
    protected Bandeja bandeja;
    protected Forraje forraje;
    protected Nutriente nutriente;

    private Fvh(FvhId fvhId) {
        super(fvhId);
        subscribe(new FvhChange(this));
    }

    public static Fvh from (FvhId fvhId, List<DomainEvent> events){
        var fvh = new Fvh(fvhId);
        events.forEach(fvh::applyEvent);
        return fvh;
    }
    public Fvh(FvhId entityId, PotreroId potreroId) {
        super(Objects.requireNonNull(entityId));
        Objects.requireNonNull(potreroId);
        subscribe(new FvhChange(this));
        appendChange(new FvhCreado(potreroId)).apply();
    }

}

package com.co.gamboatech.usecases.evenst;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.co.gamboatech.domain.fvh.events.FvhCreado;
import com.co.gamboatech.domain.potrero.events.PotreroCreado;
import com.co.gamboatech.usecases.evenst.servicios.GanaderoService;
import com.co.gamboatech.usecases.evenst.servicios.SenderEmailService;

public class NotificarNuevaFvhUseCase extends UseCase<TriggeredEvent<FvhCreado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<FvhCreado> fvhCreadoTriggeredEvent) {
        var event = fvhCreadoTriggeredEvent.getDomainEvent();
        var ganaderoService = getService(GanaderoService.class).orElseThrow();
        var sender = getService(SenderEmailService.class).orElseThrow();
        var email = ganaderoService.getFarmerEmail("admin");
        sender.sendEmail(email, "Nuevo Forraje para el potrero: "+event.potreroId());

    }
}

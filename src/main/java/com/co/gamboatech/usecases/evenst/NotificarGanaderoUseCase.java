package com.co.gamboatech.usecases.evenst;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.co.gamboatech.domain.potrero.events.PotreroCreado;
import com.co.gamboatech.usecases.evenst.servicios.GanaderoService;
import com.co.gamboatech.usecases.evenst.servicios.SenderEmailService;

public class NotificarGanaderoUseCase  extends UseCase<TriggeredEvent<PotreroCreado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<PotreroCreado> potreroCreadoTriggeredEvent) {
        var event = potreroCreadoTriggeredEvent.getDomainEvent();
        var ganaderoService = getService(GanaderoService.class).orElseThrow();
        var sender = getService(SenderEmailService.class).orElseThrow();


        var email = ganaderoService.getFarmerEmail("admin");
        sender.sendEmail(email, "Nuevo potrero de area: "+event.area());

    }
}

package com.co.gamboatech.usecases.potrero;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.co.gamboatech.domain.potrero.Potrero;
import com.co.gamboatech.domain.potrero.commands.CrearPotrero;

public class CrearPotreroUseCase extends UseCase<RequestCommand<CrearPotrero>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearPotrero> crearPotreroRequestCommand) {
        var command = crearPotreroRequestCommand.getCommand();
        var potrero = new Potrero(command.potreroId(), command.area());
        emit().onResponse(new ResponseEvents(potrero.getUncommittedChanges()));
    }
}

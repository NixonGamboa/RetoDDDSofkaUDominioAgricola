package com.co.gamboatech.usecases.potrero;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.co.gamboatech.domain.potrero.Potrero;
import com.co.gamboatech.domain.potrero.commands.ActualizarArea;

public class ActualizarAreaUseCase extends UseCase<RequestCommand<ActualizarArea>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarArea> actualizarAreaRequestCommand) {
        var command = actualizarAreaRequestCommand.getCommand();
        var potrero = Potrero.from(
                command.potreroId(),
                retrieveEvents(command.potreroId().value()));
        potrero.actualizarArea(command.area());
        emit().onResponse(new ResponseEvents(potrero.getUncommittedChanges()));
    }
}

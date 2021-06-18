package com.co.gamboatech.usecases.potrero;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.co.gamboatech.domain.potrero.Potrero;
import com.co.gamboatech.domain.potrero.commands.AsociarPasto;

public class AsociarPastoUseCase extends UseCase<RequestCommand<AsociarPasto>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AsociarPasto> asociarPastoRequestCommand) {
        var command = asociarPastoRequestCommand.getCommand();
        var potrero = Potrero.from(
                command.potreroId(),
                retrieveEvents(command.potreroId().value()));
        potrero.asociarPasto((command.densidad()));
        emit().onResponse(new ResponseEvents(potrero.getUncommittedChanges()));
    }
}

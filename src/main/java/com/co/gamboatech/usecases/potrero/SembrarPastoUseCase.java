package com.co.gamboatech.usecases.potrero;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.co.gamboatech.domain.potrero.Potrero;
import com.co.gamboatech.domain.potrero.commands.SembrarPasto;

public class SembrarPastoUseCase extends UseCase<RequestCommand<SembrarPasto>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<SembrarPasto> sembrarPastoRequestCommand) {
        var command = sembrarPastoRequestCommand.getCommand();
        var potrero = Potrero.from(
                command.potreroId(),
                retrieveEvents(command.potreroId().value()));
        potrero.sembrarPasto(command.densidad());
        emit().onResponse(new ResponseEvents(potrero.getUncommittedChanges()));
    }
}

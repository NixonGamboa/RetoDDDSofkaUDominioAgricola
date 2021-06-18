package com.co.gamboatech.usecases.potrero;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.co.gamboatech.domain.potrero.Potrero;
import com.co.gamboatech.domain.potrero.commands.AmpliarCerca;

public class AmpliarCercaUseCase extends UseCase<RequestCommand<AmpliarCerca>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AmpliarCerca> ampliarCercaRequestCommand) {
        var command = ampliarCercaRequestCommand.getCommand();
        var potrero = Potrero.from(
                command.potreroId(),
                retrieveEvents(command.potreroId().value()));
        potrero.ampliarCerca(command.longitud());
        emit().onResponse(new ResponseEvents(potrero.getUncommittedChanges()));
    }
}

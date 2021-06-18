package com.co.gamboatech.usecases.potrero;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.co.gamboatech.domain.potrero.Potrero;
import com.co.gamboatech.domain.potrero.commands.AsociarCerca;

public class AsociarCercaUseCase   extends UseCase<RequestCommand<AsociarCerca>, ResponseEvents>{

    @Override
    public void executeUseCase(RequestCommand<AsociarCerca> asociarCercaRequestCommand) {
        var command = asociarCercaRequestCommand.getCommand();
        var potrero = Potrero.from(
                command.potreroId(),
                retrieveEvents(command.potreroId().value()));
        potrero.asociarCerca(command.longitud());
        emit().onResponse(new ResponseEvents(potrero.getUncommittedChanges()));
    }
}

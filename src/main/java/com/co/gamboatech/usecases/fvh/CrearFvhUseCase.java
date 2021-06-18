package com.co.gamboatech.usecases.fvh;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.co.gamboatech.domain.fvh.Fvh;
import com.co.gamboatech.domain.fvh.commands.CrearFvh;

public class CrearFvhUseCase extends UseCase<RequestCommand<CrearFvh>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearFvh> crearFvhRequestCommand) {
        var command = crearFvhRequestCommand.getCommand();
        var fvh = new Fvh(command.fvhId(), command.potreroId());
        emit().onResponse(new ResponseEvents(fvh.getUncommittedChanges()));
    }
}

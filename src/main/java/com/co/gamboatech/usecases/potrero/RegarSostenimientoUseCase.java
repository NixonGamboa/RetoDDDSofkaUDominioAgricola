package com.co.gamboatech.usecases.potrero;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.co.gamboatech.domain.potrero.Potrero;
import com.co.gamboatech.domain.potrero.commands.RegarSostenimiento;

public class RegarSostenimientoUseCase extends UseCase<RequestCommand<RegarSostenimiento>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<RegarSostenimiento> regarSostenimientoRequestCommand) {
        var command = regarSostenimientoRequestCommand.getCommand();
        var potrero = Potrero.from(
                command.potreroId(),
                retrieveEvents(command.potreroId().value()));
        try{
            potrero.regarSostenimiento();
            emit().onResponse(new ResponseEvents(potrero.getUncommittedChanges()));
        }catch (IllegalArgumentException exception){
            emit().onError(new BusinessException(command.potreroId().value(),exception.getMessage()));
        }

    }
}

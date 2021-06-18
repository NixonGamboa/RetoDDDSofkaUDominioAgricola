package com.co.gamboatech.usecases.potrero;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.co.gamboatech.domain.potrero.Potrero;
import com.co.gamboatech.domain.potrero.commands.PorRegarSostenimiento;

public class PorRegarSostenimientoUseCase extends UseCase<RequestCommand<PorRegarSostenimiento>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<PorRegarSostenimiento> porRegarSostenimientoRequestCommand) {
        var command = porRegarSostenimientoRequestCommand.getCommand();
        var potrero = Potrero.from(
                command.potreroId(),
                retrieveEvents(command.potreroId().value()));
        potrero.porRegarSostenimiento();
        emit().onResponse(new ResponseEvents(potrero.getUncommittedChanges()));

    }
}

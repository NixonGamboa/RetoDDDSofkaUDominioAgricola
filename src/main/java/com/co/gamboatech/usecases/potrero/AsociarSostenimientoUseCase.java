package com.co.gamboatech.usecases.potrero;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.co.gamboatech.domain.potrero.Potrero;
import com.co.gamboatech.domain.potrero.commands.AsociarCerca;
import com.co.gamboatech.domain.potrero.commands.AsociarSostenimiento;

public class AsociarSostenimientoUseCase extends UseCase<RequestCommand<AsociarSostenimiento>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AsociarSostenimiento> asociarSostenimientoRequestCommand) {
        var command = asociarSostenimientoRequestCommand.getCommand();
        var potrero = Potrero.from(
                command.potreroId(),
                retrieveEvents(command.potreroId().value()));
        potrero.asociarSostenimiento(command.regado());
        emit().onResponse(new ResponseEvents(potrero.getUncommittedChanges()));
    }
}

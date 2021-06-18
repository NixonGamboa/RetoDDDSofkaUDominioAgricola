package com.co.gamboatech.usecases.potrero;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.co.gamboatech.domain.potrero.commands.PorRegarSostenimiento;
import com.co.gamboatech.domain.potrero.events.PotreroCreado;
import com.co.gamboatech.domain.potrero.events.SostenimientoAsociado;
import com.co.gamboatech.domain.potrero.events.SostenimientoPorRegar;
import com.co.gamboatech.domain.potrero.values.Area;
import com.co.gamboatech.domain.potrero.values.PotreroId;
import com.co.gamboatech.domain.potrero.values.Regado;
import com.co.gamboatech.domain.potrero.values.SostenimientoId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PorRegarSostenimientoUseCaseTest {
    private PorRegarSostenimientoUseCase porRegarSostenimientoUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        porRegarSostenimientoUseCase = new PorRegarSostenimientoUseCase();
        repository = mock(DomainEventRepository.class);
        porRegarSostenimientoUseCase.addRepository(repository);
    }

    @Test
    void porRegarSostenimientoHappyPath(){
        //Arrange
        var command = new PorRegarSostenimiento(
                PotreroId.of("Id03"));
        when(repository.getEventsBy("Id03")).thenReturn(events());
        //Act
        var response = UseCaseHandler.getInstance().syncExecutor(
                porRegarSostenimientoUseCase,new RequestCommand<>(command)
        ).orElseThrow();
        var events = response.getDomainEvents();

        //Asserts
        SostenimientoPorRegar sostenimientoPorRegar = (SostenimientoPorRegar) events.get(0);
        Assertions.assertEquals(false,sostenimientoPorRegar.regado().value());
    }

    private List<DomainEvent> events() {
        return List.of(
                new PotreroCreado(
                        new Area(200) ),
                new SostenimientoAsociado(
                        new SostenimientoId(),
                        new Regado(true))
        );
    }

}

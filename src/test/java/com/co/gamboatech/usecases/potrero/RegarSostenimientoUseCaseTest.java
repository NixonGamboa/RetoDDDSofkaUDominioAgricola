package com.co.gamboatech.usecases.potrero;


import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UnexpectedException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.co.gamboatech.domain.potrero.commands.RegarSostenimiento;
import com.co.gamboatech.domain.potrero.commands.SembrarPasto;
import com.co.gamboatech.domain.potrero.events.PastoSembrado;
import com.co.gamboatech.domain.potrero.events.PotreroCreado;
import com.co.gamboatech.domain.potrero.events.SostenimientoAsociado;
import com.co.gamboatech.domain.potrero.events.SostenimientoRegado;
import com.co.gamboatech.domain.potrero.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RegarSostenimientoUseCaseTest  {
    private RegarSostenimientoUseCase regarSostenimientoUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        regarSostenimientoUseCase = new RegarSostenimientoUseCase();
        repository = mock(DomainEventRepository.class);
        regarSostenimientoUseCase.addRepository(repository);
    }

    @Test
    void regarSostenimientoHappyPath(){
        //Arrange
        var command = new RegarSostenimiento(
                PotreroId.of("Id03"));
        when(repository.getEventsBy("Id03")).thenReturn(events());
        //Act
        var response = UseCaseHandler.getInstance().syncExecutor(
                regarSostenimientoUseCase,new RequestCommand<>(command)
        ).orElseThrow();
        var events = response.getDomainEvents();

        //Asserts
        SostenimientoRegado sostenimientoRegado = (SostenimientoRegado) events.get(0);
        Assertions.assertEquals(true,sostenimientoRegado.regado().value());
    }

    @Test
    void regarSostenimientoSadPath(){
        //Arrange
        var command = new RegarSostenimiento(
                PotreroId.of("Id03"));
        when(repository.getEventsBy("Id03")).thenReturn(eventsSad());
        //Act
        var response = Assertions.assertThrows(BusinessException.class, () ->{
            UseCaseHandler.getInstance()
                    .setIdentifyExecutor("Id03")
                    .syncExecutor(
                            regarSostenimientoUseCase,new RequestCommand<>(command))
                    .orElseThrow();
        });

        //Asserts
        Assertions.assertEquals("No debes regar un potrero ya regado", response.getMessage());
    }
    private List<DomainEvent> events() {
        return List.of(
                new PotreroCreado(
                new Area(200) ),
                new SostenimientoAsociado(
                        new SostenimientoId(),
                        new Regado(false)
                ));
    }
    private List<DomainEvent> eventsSad() {
        return List.of(
                new PotreroCreado(
                        new Area(200) ),
                new SostenimientoAsociado(
                        new SostenimientoId(),
                        new Regado(true)
                ));
    }
}

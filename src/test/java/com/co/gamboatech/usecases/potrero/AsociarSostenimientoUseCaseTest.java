package com.co.gamboatech.usecases.potrero;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.co.gamboatech.domain.potrero.commands.AsociarPasto;
import com.co.gamboatech.domain.potrero.commands.AsociarSostenimiento;
import com.co.gamboatech.domain.potrero.events.PastoAsociado;
import com.co.gamboatech.domain.potrero.events.PotreroCreado;
import com.co.gamboatech.domain.potrero.events.SostenimientoAsociado;
import com.co.gamboatech.domain.potrero.values.Area;
import com.co.gamboatech.domain.potrero.values.Densidad;
import com.co.gamboatech.domain.potrero.values.PotreroId;
import com.co.gamboatech.domain.potrero.values.Regado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AsociarSostenimientoUseCaseTest {
    private AsociarSostenimientoUseCase asociarSostenimientoUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        asociarSostenimientoUseCase = new AsociarSostenimientoUseCase();
        repository = mock(DomainEventRepository.class);
        asociarSostenimientoUseCase.addRepository(repository);
    }

    @Test
    void asociarSostenimientoHappyPath(){
        //Arrange
        var command = new AsociarSostenimiento(
                PotreroId.of("Id02"),
                new Regado(true));
        when(repository.getEventsBy("Id02")).thenReturn(events());

        //Act
        var response = UseCaseHandler.getInstance().syncExecutor(
                asociarSostenimientoUseCase, new RequestCommand<>(command)
        ).orElseThrow();
        var events = response.getDomainEvents();


        //Asserts
        SostenimientoAsociado sostenimientoAsociado = (SostenimientoAsociado) events.get(0);
        Assertions.assertEquals(true,sostenimientoAsociado.regado().value());

    }

    private List<DomainEvent> events() {
        return List.of(new PotreroCreado(
                new Area(200) ));
    }
}

package com.co.gamboatech.usecases.potrero;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.co.gamboatech.domain.potrero.commands.AsociarCerca;
import com.co.gamboatech.domain.potrero.events.CercaAsociada;
import com.co.gamboatech.domain.potrero.events.PotreroCreado;
import com.co.gamboatech.domain.potrero.values.Area;
import com.co.gamboatech.domain.potrero.values.Longitud;
import com.co.gamboatech.domain.potrero.values.PotreroId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class AsociarCercaUseCaseTest {
    private AsociarCercaUseCase asociarCercaUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        asociarCercaUseCase = new AsociarCercaUseCase();
        repository = mock(DomainEventRepository.class);
        asociarCercaUseCase.addRepository(repository);
    }

    @Test
    void asociarCercaHappyPath(){
        //Arrange
        var command = new AsociarCerca(
                PotreroId.of("Id02"),
                new Longitud(300));
        when(repository.getEventsBy("Id02")).thenReturn(events());

        //Act
        var response = UseCaseHandler.getInstance().syncExecutor(
                asociarCercaUseCase, new RequestCommand<>(command)
        ).orElseThrow();
        var events = response.getDomainEvents();
        //Asserts
        //Asserts
        CercaAsociada cercaAsociada = (CercaAsociada) events.get(0);
        Assertions.assertEquals(300,cercaAsociada.longitud().value());

    }

    private List<DomainEvent> events() {
        return List.of(new PotreroCreado(
                new Area(200) ));
    }
}

package com.co.gamboatech.usecases.potrero;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.co.gamboatech.domain.potrero.commands.AmpliarCerca;
import com.co.gamboatech.domain.potrero.events.CercaAmpliada;
import com.co.gamboatech.domain.potrero.events.PastoSembrado;
import com.co.gamboatech.domain.potrero.events.PotreroCreado;
import com.co.gamboatech.domain.potrero.values.Area;
import com.co.gamboatech.domain.potrero.values.Densidad;
import com.co.gamboatech.domain.potrero.values.Longitud;
import com.co.gamboatech.domain.potrero.values.PotreroId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AmpliarCercaUseCaseTest {
    private AmpliarCercaUseCase ampliarCercaUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        ampliarCercaUseCase = new AmpliarCercaUseCase();
        repository = mock(DomainEventRepository.class);
        ampliarCercaUseCase.addRepository(repository);
    }

    @Test
    void ampliarCercaHappyPath(){
        //Arrange
        var command = new AmpliarCerca(
                PotreroId.of("Id03"),
                new Longitud(900));
        when(repository.getEventsBy("Id03")).thenReturn(events());
        //Act
        var response = UseCaseHandler.getInstance().syncExecutor(
                ampliarCercaUseCase,new RequestCommand<>(command)
        ).orElseThrow();
        var events = response.getDomainEvents();

        //Asserts
        CercaAmpliada cercaAmpliada = (CercaAmpliada) events.get(0);
        Assertions.assertEquals(900,cercaAmpliada.longitud().value());
    }
    private List<DomainEvent> events() {
        return List.of(new PotreroCreado(
                new Area(200) ));
    }
}

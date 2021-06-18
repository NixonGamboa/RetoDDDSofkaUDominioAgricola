package com.co.gamboatech.usecases.potrero;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.co.gamboatech.domain.potrero.commands.ActualizarArea;
import com.co.gamboatech.domain.potrero.commands.SembrarPasto;
import com.co.gamboatech.domain.potrero.events.AreaActualizada;
import com.co.gamboatech.domain.potrero.events.PastoSembrado;
import com.co.gamboatech.domain.potrero.events.PotreroCreado;
import com.co.gamboatech.domain.potrero.values.Area;
import com.co.gamboatech.domain.potrero.values.Densidad;
import com.co.gamboatech.domain.potrero.values.PotreroId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SembrarPastoUseCaseTest {
    private SembrarPastoUseCase sembrarPastoUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        sembrarPastoUseCase = new SembrarPastoUseCase();
        repository = mock(DomainEventRepository.class);
        sembrarPastoUseCase.addRepository(repository);
    }

    @Test
    void sembrarPastoHappyPath(){
        //Arrange
        var command = new SembrarPasto(
                PotreroId.of("Id03"),
                new Densidad(90));
        when(repository.getEventsBy("Id03")).thenReturn(events());
        //Act
        var response = UseCaseHandler.getInstance().syncExecutor(
                sembrarPastoUseCase,new RequestCommand<>(command)
        ).orElseThrow();
        var events = response.getDomainEvents();

        //Asserts
        PastoSembrado pastoSembrado = (PastoSembrado) events.get(0);
        Assertions.assertEquals(90,pastoSembrado.densidad().value());
    }
    private List<DomainEvent> events() {
        return List.of(new PotreroCreado(
                new Area(200) ));
    }
}

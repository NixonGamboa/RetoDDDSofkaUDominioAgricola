package com.co.gamboatech.usecases.potrero;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.co.gamboatech.domain.potrero.commands.ActualizarArea;
import com.co.gamboatech.domain.potrero.events.AreaActualizada;
import com.co.gamboatech.domain.potrero.events.PotreroCreado;
import com.co.gamboatech.domain.potrero.values.Area;
import com.co.gamboatech.domain.potrero.values.PotreroId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ActualizarAreaUseCaseTest {
    private ActualizarAreaUseCase actualizarAreaUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        actualizarAreaUseCase = new ActualizarAreaUseCase();
        repository = mock(DomainEventRepository.class);
        actualizarAreaUseCase.addRepository(repository);
    }

    @Test
    void actualizarAreaHappyPath(){
        //Arrange
        var command = new ActualizarArea(
                PotreroId.of("Id03"),
                new Area(900));
        when(repository.getEventsBy("Id03")).thenReturn(events());
        //Act
        var response = UseCaseHandler.getInstance().syncExecutor(
                actualizarAreaUseCase,new RequestCommand<>(command)
        ).orElseThrow();
        var events = response.getDomainEvents();

        //Asserts
        AreaActualizada areaActualizada = (AreaActualizada) events.get(0);
        Assertions.assertEquals(900,areaActualizada.area().value());
    }
    private List<DomainEvent> events() {
        return List.of(new PotreroCreado(
                new Area(200) ));
    }
}

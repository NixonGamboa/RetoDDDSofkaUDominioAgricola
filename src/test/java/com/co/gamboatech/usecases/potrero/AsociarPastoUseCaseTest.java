package com.co.gamboatech.usecases.potrero;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.co.gamboatech.domain.potrero.commands.AsociarCerca;
import com.co.gamboatech.domain.potrero.commands.AsociarPasto;
import com.co.gamboatech.domain.potrero.events.PastoAsociado;
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

public class AsociarPastoUseCaseTest {
    private AsociarPastoUseCase asociarPastoUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        asociarPastoUseCase = new AsociarPastoUseCase();
        repository = mock(DomainEventRepository.class);
        asociarPastoUseCase.addRepository(repository);
    }

    @Test
    void asociarPastoHappyPath(){
        //Arrange
        var command = new AsociarPasto(
                PotreroId.of("Id02"),
                new Densidad(60));
        when(repository.getEventsBy("Id02")).thenReturn(events());

        //Act
        var response = UseCaseHandler.getInstance().syncExecutor(
                asociarPastoUseCase, new RequestCommand<>(command)
        ).orElseThrow();
        var events = response.getDomainEvents();


        //Asserts
        PastoAsociado pastoAsociado = (PastoAsociado) events.get(0);
        Assertions.assertEquals(60,pastoAsociado.densidad().value());

    }

    private List<DomainEvent> events() {
        return List.of(new PotreroCreado(
                new Area(200) ));
    }
}

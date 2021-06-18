package com.co.gamboatech.usecases.potrero;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.co.gamboatech.domain.potrero.commands.CrearPotrero;
import com.co.gamboatech.domain.potrero.events.PotreroCreado;
import com.co.gamboatech.domain.potrero.values.Area;
import com.co.gamboatech.domain.potrero.values.PotreroId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CrearPotreroUseCaseTest {
    private CrearPotreroUseCase crearPotreroUseCase;

    @BeforeEach
    public void setup(){
        crearPotreroUseCase = new CrearPotreroUseCase();
    }
    @Test
    void crearPotreroHappyPath(){
        //Arrange
        var command = new CrearPotrero(
                PotreroId.of("ID01"),
                new Area(500));
        //Act
        var response = UseCaseHandler.getInstance().syncExecutor(
                crearPotreroUseCase,new RequestCommand<>(command)
        ).orElseThrow();

        var events = response.getDomainEvents();

        //Asserts
        PotreroCreado potreroCreado = (PotreroCreado) events.get(0);
        Assertions.assertEquals(500,potreroCreado.area().value());
    }

}

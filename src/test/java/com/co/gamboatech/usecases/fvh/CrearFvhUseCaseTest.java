package com.co.gamboatech.usecases.fvh;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.co.gamboatech.domain.fvh.commands.CrearFvh;
import com.co.gamboatech.domain.fvh.events.FvhCreado;
import com.co.gamboatech.domain.fvh.values.FvhId;
import com.co.gamboatech.domain.potrero.values.PotreroId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CrearFvhUseCaseTest {
    private CrearFvhUseCase crearFvhUseCase;

    @BeforeEach
    public void setup(){
        crearFvhUseCase = new CrearFvhUseCase();
    }
    @Test
    void crearFvhHappyPath(){
        //Arrange
        var command = new CrearFvh(
                FvhId.of("FVH001"),
                PotreroId.of("POTRERO01"));
        //Act
        var response = UseCaseHandler.getInstance().syncExecutor(
                crearFvhUseCase,new RequestCommand<>(command)
        ).orElseThrow();

        var events = response.getDomainEvents();

        //Asserts
        FvhCreado fvhCreado = (FvhCreado) events.get(0);
        Assertions.assertEquals("POTRERO01",fvhCreado.potreroId().value());
    }
}

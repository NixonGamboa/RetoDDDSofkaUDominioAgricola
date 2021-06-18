package com.co.gamboatech.usecases.events;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import com.co.gamboatech.domain.potrero.events.PotreroCreado;
import com.co.gamboatech.domain.potrero.values.Area;
import com.co.gamboatech.usecases.evenst.NotificarGanaderoUseCase;
import com.co.gamboatech.usecases.evenst.servicios.GanaderoService;
import com.co.gamboatech.usecases.evenst.servicios.SenderEmailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class NotificarGanaderoUseCaseTest {
    private NotificarGanaderoUseCase notificarGanaderoUseCase;

    private GanaderoService ganaderoService;
    private SenderEmailService senderEmailService;

    @BeforeEach
    public void setup(){
        notificarGanaderoUseCase = new NotificarGanaderoUseCase();
        ganaderoService = mock(GanaderoService.class);
        senderEmailService = mock(SenderEmailService.class);

        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(ganaderoService);
        builder.addService(senderEmailService);

        notificarGanaderoUseCase.addServiceBuilder(builder);
    }

    @Test
    void notificarCrearPotreroHappyPath(){
        var event = new PotreroCreado(
                new Area(800)
        );
        when(ganaderoService.getFarmerEmail(any())).thenReturn("administrador@gmail.com");
        doNothing().when(senderEmailService).sendEmail(any(),anyString());

        UseCaseHandler.getInstance()
                .syncExecutor(
                        notificarGanaderoUseCase,
                        new TriggeredEvent<>(event)
                );

        verify(ganaderoService).getFarmerEmail(any());
        verify(senderEmailService).sendEmail(any(),anyString());
    }
}

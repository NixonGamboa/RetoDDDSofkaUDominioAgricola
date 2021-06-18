package com.co.gamboatech.domain.potrero.commands;

import co.com.sofka.domain.generic.Command;
import com.co.gamboatech.domain.potrero.values.Densidad;

public class SembrarPasto implements Command {
    private Densidad densidad;

    public SembrarPasto( Densidad densidad) {
        this.densidad = densidad;
    }

    public Densidad densidad() {
        return densidad;
    }
}

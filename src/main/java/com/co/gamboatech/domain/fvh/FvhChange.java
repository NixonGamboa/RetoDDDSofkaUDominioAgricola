package com.co.gamboatech.domain.fvh;

import co.com.sofka.domain.generic.EventChange;
import com.co.gamboatech.domain.fvh.events.FvhCreado;

public class FvhChange extends EventChange {
    public FvhChange(Fvh fvh) {
        apply((FvhCreado event)->{
            fvh.potreroId= event.potreroId();
            fvh.bandeja=null;
            fvh.forraje=null;
            fvh.nutriente=null;
        });
    }
}

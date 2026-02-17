package org.integracode.chatapp.controller;

import org.integracode.chatapp.model.Reciclaje;

public class CalcularReciclaje {
     public void calcular(Reciclaje r) {

        double factor = 0;

        switch (r.getMaterial()) {
            case "Plástico":
                factor = 1.5;
                break;
            case "Papel":
                factor = 1.0;
                break;
            case "Vidrio":
                factor = 2.0;
                break;
            case "Metal": 
                factor = 2.5;
                break;
        }

        double puntos = r.getCantidad() * factor;

        r.setPuntos(puntos);
    }
}

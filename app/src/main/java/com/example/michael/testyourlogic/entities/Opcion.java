package com.example.michael.testyourlogic.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Opcion {


    @JsonProperty("opcion")
    private String opcion;

    @JsonProperty("correcta")
    private boolean correcta;

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public boolean isCorrecta() {
        return correcta;
    }

    public void setCorrecta(boolean correcta) {
        this.correcta = correcta;
    }
}

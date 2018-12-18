package com.example.michael.testyourlogic.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Pregunta {

    @JsonProperty("enunciado")
    private String enunciado;
    @JsonProperty("opciones")
    private List<Opcion> opciones;

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public List<Opcion> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<Opcion> opciones) {
        this.opciones = opciones;
    }
}

package com.example.michael.testyourlogic.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Preguntas {

    @JsonProperty("preguntas")
    private List<Pregunta> preguntas;

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }
}

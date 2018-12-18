package com.example.michael.testyourlogic.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Preguntas {

    @JsonProperty("preguntas")
    private List<Pregunta> pregunstasl;
}

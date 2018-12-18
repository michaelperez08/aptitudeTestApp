package com.example.michael.testyourlogic.core;

import com.example.michael.testyourlogic.entities.Pregunta;
import com.example.michael.testyourlogic.entities.Preguntas;

import java.util.List;

public class ManagerPreguntas {

    private static ManagerPreguntas instance;

    private Preguntas preguntas;

    public static ManagerPreguntas getInstance(){
        if(instance==null){
            instance = new ManagerPreguntas();
        }
        return instance;
    }

    public Preguntas getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(Preguntas preguntas) {
        this.preguntas = preguntas;
    }
}

package com.example.michael.testyourlogic.core;

import com.example.michael.testyourlogic.entities.Preguntas;

public class ManagerPreguntas {

    private static ManagerPreguntas instance;

    private Preguntas listaDePreguntas;

    public static ManagerPreguntas getInstance(){
        if(instance==null){
            instance = new ManagerPreguntas();
        }
        return instance;
    }

    public Preguntas getListaDePreguntas() {
        return listaDePreguntas;
    }

    public void setListaDePreguntas(Preguntas listaDePreguntas) {
        this.listaDePreguntas = listaDePreguntas;
    }
}

package com.example.ucemap.utilidades;

import com.example.ucemap.repository.modelo.ListaOpciones;

import java.util.ArrayList;
import java.util.List;

public class metodosPruebas {

    public static List<ListaOpciones> obtenerOpciones() {
        List<ListaOpciones> opciones = new ArrayList<ListaOpciones>();
        opciones.add(new ListaOpciones("Facultad_1"));
        opciones.add(new ListaOpciones("Facultad_2"));
        opciones.add(new ListaOpciones("Facultad_3"));
        opciones.add(new ListaOpciones("Facultad_4"));
        opciones.add(new ListaOpciones("Facultad_5"));
        opciones.add(new ListaOpciones("Facultad_6"));
        opciones.add(new ListaOpciones("Facultad_7"));
        opciones.add(new ListaOpciones("Facultad_9"));
        opciones.add(new ListaOpciones("Facultad_10"));
        opciones.add(new ListaOpciones("Facultad_11"));

        return opciones;
    }
}

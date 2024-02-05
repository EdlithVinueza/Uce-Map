package com.example.ucemap.service.listaOpcionesFactory;

import android.util.Log;

import com.example.ucemap.repository.modelo.ListaOpciones;
import com.example.ucemap.service.informacionFactory.InformacionEdificio;
import com.example.ucemap.service.informacionFactory.InformacionFacultad;

import java.util.List;

public class ListaOpcionesFactory {

    public static IListaOpcionesFactory generarListaOpciones(String tipo){
        if ("facultades".equalsIgnoreCase(tipo)) {
            Log.d("Tipo", tipo);
            return new ListaFacultades();
        } else if ("edificios".equalsIgnoreCase(tipo)) {
            return  new ListaEdificios();

        }
        return null;

    };
}

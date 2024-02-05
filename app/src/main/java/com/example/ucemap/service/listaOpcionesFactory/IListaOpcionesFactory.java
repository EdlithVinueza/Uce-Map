package com.example.ucemap.service.listaOpcionesFactory;

import android.content.Context;

import com.example.ucemap.repository.modelo.ListaOpciones;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public interface IListaOpcionesFactory {
    public List<ListaOpciones> crearListaOpciones(Context context) throws JSONException, IOException;

}

package com.example.ucemap.repository;

import android.content.Context;

import com.example.ucemap.repository.modelo.Facultad;
import com.example.ucemap.repository.modelo.ListaOpciones;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public interface IFacultadRepository {
    public  Facultad seleccionarFacultadPorNombre(Context context, String atributoParaExtraer, String atributoComparacion) throws IOException, JSONException;
    public List<ListaOpciones> seleccionarTodasLasFacultadPorNombre(Context context) throws JSONException, IOException;
}

package com.example.ucemap.service;

import android.content.Context;

import com.example.ucemap.repository.modelo.Descripcion;
import com.example.ucemap.repository.modelo.Edificio;
import com.example.ucemap.repository.modelo.ListaOpciones;
import com.example.ucemap.repository.modelo.Posicion;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public interface IEdificioService {

    public Edificio buscarEdificioPorNombre(Context context, String atributoParaExtraer, String atributoComparacion) throws IOException, JSONException;
    public List<ListaOpciones> buscarTodasLosEdificiosPorNombre(Context context) throws IOException, JSONException;
    public List<Descripcion> generarDescripcionEdificio(Edificio edificio);
    public Posicion generarPosicionEdificio(Edificio edificio);

}

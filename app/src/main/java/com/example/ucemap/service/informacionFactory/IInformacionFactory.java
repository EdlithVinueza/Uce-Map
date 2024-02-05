package com.example.ucemap.service.informacionFactory;

import android.content.Context;

import com.example.ucemap.repository.modelo.Informacion;

import org.json.JSONException;

import java.io.IOException;

public interface IInformacionFactory {
    public Informacion generarInformacion(Context context, String atributoParaExtraer, String atributoComparacion) throws JSONException, IOException;
}

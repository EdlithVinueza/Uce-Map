package com.example.ucemap.repository;

import android.content.Context;
import android.util.Log;

import com.example.ucemap.data.DatosJason;
import com.example.ucemap.repository.modelo.Facultad;
import com.example.ucemap.repository.modelo.ListaOpciones;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FacultadRepositoryImpl implements IFacultadRepository {
    @Override
    public Facultad seleccionarFacultadPorNombre(Context context, String atributoParaExtraer, String atributoComparacion) throws IOException, JSONException {
        String jsonFileContent = DatosJason.leerJson(context);
        JSONObject jsonObject = new JSONObject(jsonFileContent);
        JSONArray documentoArray = jsonObject.getJSONArray(DatosJason.FACULTAD_NOMBRE_DOCUMENTO_INTERNO);
        for (int i = 0; i < documentoArray.length(); i++) {
            JSONObject Object = documentoArray.getJSONObject(i);
            String atributoExtraido = Object.getString(atributoParaExtraer);
            if (atributoExtraido.equals(atributoComparacion)) {
                // Coincidencia encontrada, construir el objeto Edificio
                Facultad facultad = new Facultad();
                facultad.setNombre(Object.getString("nombre"));
                facultad.setServicios(DatosJason.extraerListaString(Object,"servicios"));
                facultad.setImagenes(DatosJason.extraerListaString(Object,"imagenes"));
                facultad.setDescripcion(Object.getString( "descripcion"));
                facultad.setLatitud(Object.getDouble( "latitud"));
                facultad.setLongitud(Object.getDouble( "longitud"));
                Log.d("Objeto Facultad", facultad.toString());
                return facultad;
            }
        }
        Log.e("ERROR", "No se creo una Facultas");
        return null;
    }

    @Override
    public List<ListaOpciones> seleccionarTodasLasFacultadPorNombre(Context context) throws JSONException, IOException {
        return DatosJason.extraerUnAtributo(context, DatosJason.FACULTAD_NOMBRE_DOCUMENTO_INTERNO, DatosJason.ATRIBUTO_GENERAL_NOMBRE);
    }




}

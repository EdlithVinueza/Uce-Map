package com.example.ucemap.repository;

import android.content.Context;
import android.util.Log;

import com.example.ucemap.data.DatosJason;
import com.example.ucemap.repository.modelo.Edificio;
import com.example.ucemap.repository.modelo.ListaOpciones;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

public class EdificioRepositoryImpl implements IEdificioRepository {
    @Override
    public Edificio seleccionarEdificioPorNombre(Context context, String atributoParaExtraer, String atributoComparacion) throws IOException, JSONException {
        String jsonFileContent = DatosJason.leerJson(context);
        JSONObject jsonObject = new JSONObject(jsonFileContent);
        JSONArray documentoArray = jsonObject.getJSONArray(DatosJason.EDIFICIO_NOMBRE_DOCUMENTO_INTERNO);
        for (int i = 0; i < documentoArray.length(); i++) {
            JSONObject Object = documentoArray.getJSONObject(i);
            String atributoExtraido = Object.getString(atributoParaExtraer);
            if (atributoExtraido.equals(atributoComparacion)) {
                // Coincidencia encontrada, construir el objeto Edificio
                Edificio edificio = new Edificio();
                edificio.setNombre(Object.getString("nombre"));
                edificio.setServicios(DatosJason.extraerListaString(Object,"servicios"));
                edificio.setImagenes(DatosJason.extraerListaString(Object,"imagenes"));
                edificio.setDescripcion(Object.getString( "descripcion"));
                edificio.setLatitud(Object.getDouble( "latitud"));
                edificio.setLongitud(Object.getDouble( "longitud"));
                Log.d("Objeto Edificio", edificio.toString());
                return edificio;
            }
        }
        Log.e("ERROR", "No se creo un Edificio");
        return null;
    }

    @Override
    public List<ListaOpciones> seleccionarTodasLosEdificiosPorNombre(Context context) throws IOException, JSONException {
        return DatosJason.extraerUnAtributo(context, DatosJason.EDIFICIO_NOMBRE_DOCUMENTO_INTERNO, DatosJason.ATRIBUTO_GENERAL_NOMBRE);


    }

}

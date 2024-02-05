package com.example.ucemap.data;

import android.content.Context;

import com.example.ucemap.repository.modelo.ListaOpciones;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DatosJason {
    public static final String DIRECTORIO_JASSON= "prototipo.json";
    public static final String FACULTAD_NOMBRE_DOCUMENTO_INTERNO = "facultades";
    public static final String EDIFICIO_NOMBRE_DOCUMENTO_INTERNO = "edificios";
    public static final String ATRIBUTO_GENERAL_NOMBRE = "nombre";

    public static String leerJson(Context context) throws IOException
    {
        BufferedReader reader = null;
        reader = new BufferedReader(new InputStreamReader(context.getAssets().open(DIRECTORIO_JASSON), "UTF-8"));
        String content = "";
        String line;
        while ((line = reader.readLine()) != null)
        {
            content = content + line;
        }
        return content;
    }


    public static List<ListaOpciones> extraerUnAtributo(Context context, String nombreDocumentoInterno, String atributoParaExtraer) throws IOException, JSONException {
        String jsonFileContent = leerJson(context);
        List<ListaOpciones> opciones = new ArrayList<>();

        JSONObject jsonObject = new JSONObject(jsonFileContent);
        JSONArray documentoArray = jsonObject.getJSONArray(nombreDocumentoInterno);

        for (int i = 0; i < documentoArray.length(); i++) {
            JSONObject facultadObject = documentoArray.getJSONObject(i);
            String atributoExtraido = facultadObject.getString(atributoParaExtraer);
            opciones.add(new ListaOpciones(atributoExtraido));
        }
        return opciones;
    }

    public static List<String> extraerListaString(JSONObject Object,String nombreAtributo) throws JSONException {
        JSONArray array = Object.getJSONArray(nombreAtributo);
        List<String> lista = new ArrayList<>();
        for (int j = 0; j < array.length(); j++) {
            String servicio = array.getString(j);
            lista.add(servicio);
        }
        return lista;
    }
}

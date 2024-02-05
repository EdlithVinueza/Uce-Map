package com.example.ucemap.service.listaOpcionesFactory;

import android.content.Context;

import com.example.ucemap.repository.modelo.ListaOpciones;
import com.example.ucemap.service.FacultadServiceImpl;
import com.example.ucemap.service.IFacultadService;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public class ListaFacultades  implements IListaOpcionesFactory{

    private IFacultadService iFacultadService;
    @Override
    public List<ListaOpciones> crearListaOpciones(Context context) throws JSONException, IOException {
        iFacultadService = new FacultadServiceImpl();
        return iFacultadService.buscarTodasLasFacultadPorNombre(context);
    }
}
